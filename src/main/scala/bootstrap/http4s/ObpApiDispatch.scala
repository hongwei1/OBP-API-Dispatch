package bootstrap.http4s

import cats.effect.IO
import cats.syntax.all._
import org.http4s._
import org.http4s.client.Client
import org.http4s.headers.`Content-Type`
import org.slf4j.LoggerFactory

class ObpApiDispatch(client: Client[IO], obpApi1BaseUri: Uri, obpApi2BaseUri: Uri){
  private val logger = LoggerFactory.getLogger(classOf[Nothing])
  
  def routes: HttpRoutes[IO] = HttpRoutes.of[IO] {
    case req =>
      val queryParams: Map[String, String] =
        req.uri.query.pairs.collect {
          case (k, Some(v)) => k -> v
        }.toMap

      //here we need to decide which obp api to use, obpApi1 or obpApi2
      //we have the resource docs in,
      //if V1.3.0, we use obpApi2, others we use obpApi1
      val obpApiBaseUri = req.uri.path.toString().startsWith("/obp/v1.3.0") match {
        case true => obpApi2BaseUri
        case false => obpApi1BaseUri
      }
      
      val proxiedUri = obpApiBaseUri
        .withPath(req.uri.path)
        .withQueryParams(queryParams)

      val proxiedRequest = Request[IO](
        method = req.method,
        uri = proxiedUri,
        httpVersion = req.httpVersion,
        headers = req.headers,
        body = req.body
      )

      IO(logger.debug(s"[Dispatch] Request: ${req.method} ${req.uri} -> ${proxiedUri}")) *>
        client.run(proxiedRequest).use { dispatchResponse =>
          IO(logger.debug(s"[Dispatch] Response: ${proxiedUri}: ${dispatchResponse.status}")) *>
            dispatchResponse.body.compile.toVector.flatMap { bodyBytes => 
              //In http4s, the body is a Stream, and you cannot directly copy the response’s stream because a stream 
              // can only be consumed once. Once dispatchResponse.body is consumed, it cannot be used again.
              val newBody = fs2.Stream.emits(bodyBytes)
              Response[IO](
                status = dispatchResponse.status,
                headers = dispatchResponse.headers,
                body = newBody
              ).pure[IO]
            }
        }.handleErrorWith { ex => 
          val errorMessage = s"""${ErrorMessages.UnknownError} Can not get response from Request: ${req.method} ${req.uri} -> ${proxiedUri}. Please check if ${proxiedUri} is running. The exception details:${ex.getMessage}""".stripMargin
          IO(logger.error(
            errorMessage, ex)) *> 
            Response[IO](
              status = Status.InternalServerError
            ).withEntity(
                s"""{"message": "$errorMessage"}""".stripMargin
              )
              .withContentType(`Content-Type`(MediaType.application.json))
              .pure[IO]
        }
  }

}
