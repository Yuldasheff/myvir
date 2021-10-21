package com.vir


import org.http4s._
import org.http4s.blaze.server.BlazeServerBuilder
import org.http4s.server.Router
import cats.effect._
import cats.implicits._
import org.http4s.circe._
import org.http4s._
import io.circe.generic.auto._
import io.circe.syntax._
import org.http4s.dsl._
import org.http4s.dsl.impl._
import org.http4s.headers._
import org.http4s.implicits._
import org.http4s.server._
import scala.concurrent.ExecutionContext

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