package bootstrap.http4s

import cats.effect.IO
import org.http4s.HttpRoutes
import org.http4s.dsl.io._
import org.slf4j.LoggerFactory

import scala.language.higherKinds

/**
 * this to test the error handing. try to make the proper error response
 */
object HealthCheck {

  private val logger = LoggerFactory.getLogger(classOf[Nothing])
  
  val healthCheck: HttpRoutes[IO] = HttpRoutes.of[IO] {
    case GET -> Root / "check"  =>
      logger.debug("Health check request received.")
      Ok(s"Thanks for checking, server is ready.")
  }
  
}