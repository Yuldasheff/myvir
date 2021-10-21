package com

import org.http4s.*
import org.http4s.blaze.server.BlazeServerBuilder
import org.http4s.server.Router
import cats.*
import cats.effect.*
import cats.effect.{ExitCode, IO, IOApp}
import cats.implicits.*
import org.http4s.circe.*
import org.http4s.*
import io.circe.generic.auto.*
import io.circe.syntax.*
import org.http4s.dsl.*
import org.http4s.dsl.impl.*
import org.http4s.headers.*
import org.http4s.implicits.*
import org.http4s.server.*

import scala.concurrent.ExecutionContext


package object vir {

  object PingApi extends IOApp with Http4sDsl[IO]{
    val httpApp = Router(
      "/" -> HttpRoutes.of[IO]{
        case GET -> Root / "ping" => Ok("pong")
        case _ => BadRequest("The given year is not valid")
      }
    ).orNotFound



  override def run(args: List[String]): IO[ExitCode] = stream(args).compile.drain.as(ExitCode.Success)

  private def stream(value: List[String]): fs2.Stream[IO, ExitCode] =
    BlazeServerBuilder[IO](ExecutionContext.global)
      .bindHttp(8000, "0.0.0.0")
      .withHttpApp(httpApp)
      .serve
}

}
