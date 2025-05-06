package bootstrap.http4s.middleware

import cats.data.{Kleisli, OptionT}
import cats.effect.IO
import net.liftweb.json.{DefaultFormats, Extraction, compactRender, parse}
import org.http4s.headers.`Content-Type`
import org.http4s.{MediaType, _}
import org.typelevel.log4cats.slf4j.Slf4jLogger

object JsonErrorHandlerMiddleware {

  private val logger = Slf4jLogger.getLogger[IO]
  implicit val formats = DefaultFormats
  
  case class ErrorMessage(code: Int, message: String)

  case class APIFailureNewStyle(
    failMsg: String,
    failCode: Int = 400
  )
  
  def apply(routes: HttpRoutes[IO]): HttpRoutes[IO] =
    Kleisli { req =>
      OptionT {
        routes(req).value.handleErrorWith { error =>
          val stackTrace = error.getStackTrace.mkString("\n")
          logger.error(s"[${error.toString}]-Message:${error.getMessage} at ${req.method} ${req.uri}\n Error StackTrace: $stackTrace") *> IO {
            try {
              val failure = parse(error.getMessage).extract[APIFailureNewStyle]
              val errorMessage = ErrorMessage(failure.failCode, failure.failMsg)
              val json = compactRender(Extraction.decompose(errorMessage))
              Some(Response[IO](status = Status.InternalServerError)
                .withEntity(json)
                .withContentType(`Content-Type`(MediaType.application.json)))
            } catch {
              case _: Throwable =>
                val safeMsg = error.getMessage.replace("\"", "\'")
                val fallbackJson = s"""{"message": "$safeMsg"}"""
                Some(Response[IO](status = Status.InternalServerError)
                  .withEntity(fallbackJson)
                  .withContentType(`Content-Type`(MediaType.application.json)))
            }
          }
        }
      }
    }
}
