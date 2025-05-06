package bootstrap.http4s

import cats.effect.IO
import cats.syntax.all._
import org.http4s._
import org.http4s.client.Client
import org.http4s.headers.`Content-Type`
import org.slf4j.LoggerFactory

class ObpApiDispatch(client: Client[IO], obpApiBaseUri: Uri){
  private val logger = LoggerFactory.getLogger(classOf[Nothing])
  
  def routes: HttpRoutes[IO] = HttpRoutes.of[IO] {
    case req =>
      val queryParams: Map[String, String] =
        req.uri.query.pairs.collect {
          case (k, Some(v)) => k -> v
        }.toMap

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
            Response[IO](
              status = dispatchResponse.status,
              headers = dispatchResponse.headers,
              body = dispatchResponse.body
            ).pure[IO]
        }.handleErrorWith { ex => 
          IO(logger.error(s"[Dispatch] Error Dispatching to OBP API: ${ex.getMessage}", ex)) *>
            Response[IO](
              status = Status.InternalServerError
            ).withEntity(s"""{"message": "${ErrorMessages.UnknownError} Please check if OBP-API is dead, details:${ex.getMessage} "}""")
              .withContentType(`Content-Type`(MediaType.application.json))
              .pure[IO]
        }
  }

}
