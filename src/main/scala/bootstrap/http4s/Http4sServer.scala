package bootstrap.http4s

import bootstrap.http4s.middleware.JsonErrorHandlerMiddleware
import bootstrap.http4s.middleware.ResponseMiddleware.contentTypeMiddleware
import cats.data.{Kleisli, OptionT}
import cats.effect.kernel.Async
import cats.effect.{ExitCode, IO, IOApp}
import cats.syntax.all._
import com.comcast.ip4s.{Host, Port}
import fs2.io.net.tls.TLSContext
import org.http4s.ember.client.EmberClientBuilder
import org.http4s.ember.server.EmberServerBuilder
import org.http4s.implicits._
import org.http4s.{Uri, _}
import org.slf4j.LoggerFactory
import pureconfig._

import java.io.FileInputStream
import java.security.KeyStore
import javax.net.ssl.{KeyManagerFactory, SSLContext, TrustManagerFactory}
import scala.language.higherKinds

object Http4sServer extends IOApp  {
  private val logger = LoggerFactory.getLogger(classOf[Nothing])


  // Log level startup message
  def logStartupMessage(): Unit = {
    // Log the current log level (this will print the level of the root logger)
    val logLevel = org.slf4j.LoggerFactory.getLogger(org.slf4j.Logger.ROOT_LOGGER_NAME).asInstanceOf[ch.qos.logback.classic.Logger].getLevel
    logger.info(s"Application started with log level: $logLevel")
  }
  
  val HOST_NAME = ConfigSource.default.at("app.dispatch_host").loadOrThrow[String]
  val DEV_PORT = ConfigSource.default.at("app.dispatch_dev_port").loadOrThrow[Int]
  val OBP_API_1_BASE_URI = ConfigSource.default.at("app.obp_api_1_base_uri").loadOrThrow[String]
  

  val host: Host = Host.fromString(HOST_NAME).head
  val port: Option[Port] = Port.fromInt(DEV_PORT)
  val obpApi1BaseUri: Uri = Uri.unsafeFromString(OBP_API_1_BASE_URI)
  
  
  // Convert SSLContext to TLSContext
  private def toTLSContext(sslContext: SSLContext): IO[TLSContext[IO]] = {
    IO(TLSContext.Builder.forAsync[IO](Async[IO]).fromSSLContext(sslContext))
  }

  // Load the keystore and create an SSLContext (optional) //TODO this should be a helper function
  private def createSSLContext: IO[Option[SSLContext]] = IO {
    // Path to the keystore file
    val keystorePath = "path/to/keystore.jks"
    // Keystore password
    val keystorePassword = "changeit".toCharArray

    // Load the keystore
    val keystore = KeyStore.getInstance("JKS")
    val keystoreStream = new FileInputStream(keystorePath)
    keystore.load(keystoreStream, keystorePassword)
    keystoreStream.close()

    // Initialize KeyManagerFactory
    val keyManagerFactory = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm)
    keyManagerFactory.init(keystore, keystorePassword)

    // Initialize TrustManagerFactory
    val trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm)
    trustManagerFactory.init(keystore)

    // Create and initialize the SSLContext
    val sslContext = SSLContext.getInstance("TLS")
    sslContext.init(keyManagerFactory.getKeyManagers, trustManagerFactory.getTrustManagers, null)
    Some(sslContext)
  }.handleErrorWith { _ =>
    IO.pure(None) // If keystore loading fails, return None (HTTPS disabled)
  }

  override def run(args: List[String]): IO[ExitCode] = {
    // Log the startup message with the current log level
    logStartupMessage()
    
    // Create an Ember client
    EmberClientBuilder.default[IO].build.use { client =>
      
      val obpApi1Dispatch = new ObpApiDispatch(client, obpApi1BaseUri).routes

      //this is the routers
      val services: Kleisli[({type λ[β$0$] = OptionT[IO, β$0$]})#λ, Request[IO], Response[IO]] = contentTypeMiddleware(JsonErrorHandlerMiddleware(
          HealthCheck.healthCheck <+>
          obpApi1Dispatch //just pass though any request to the obp api and get the response
      ))

      val httpApp: Kleisli[IO, Request[IO], Response[IO]] = (services).orNotFound

      for {
        sslContextOpt <- createSSLContext // Create the SSLContext (optional)
        tlsContextOpt <- sslContextOpt match {
          case Some(sslContext) => toTLSContext(sslContext).map(Some(_)) // Convert to TLSContext
          case None => IO.pure(None) // No TLSContext if SSLContext is not available
        }
        exitCode <- {
          // Start with the default EmberServerBuilder
          val serverBuilder = EmberServerBuilder
            .default[IO]
            .withHost(host) // Use the extracted hostname

          // Conditionally add the port if it is provided
          val serverBuilderWithPort = port match {
            case Some(p) => serverBuilder.withPort(p)
            case None => serverBuilder
          }

          // Conditionally enable HTTPS if TLSContext is available
          val serverBuilderWithTLS = tlsContextOpt match {
            case Some(tlsContext) => serverBuilderWithPort.withTLS(tlsContext) // Enable HTTPS
            case None => serverBuilderWithPort // Use HTTP
          }

          // Build and start the server
          serverBuilderWithTLS
            .withHttpApp(httpApp)
            .build
            .use(_ => IO.never) // Keep the server running indefinitely
            .as(ExitCode.Success)
        }
      } yield exitCode
    }
  }
}

