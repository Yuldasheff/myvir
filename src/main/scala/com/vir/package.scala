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

  class PingApi() extends Http4sDsl[IO]{
    val routes = HttpRoutes.of[IO]{
      case GET -> Root / "ping" => Ok("pong")
    }
  }

  object PingApi extends IOApp{
    val httpApp = Router(
      "/" -> new PingApi().routes
    ).orNotFound



  override def run(args: List[String]): IO[ExitCode] = stream(args).compile.drain.as(ExitCode.Success)

  private def stream(value: List[String]): fs2.Stream[IO, ExitCode] =
    BlazeServerBuilder[IO](ExecutionContext.global)
      .bindHttp(8000, "0.0.0.0")
      .withHttpApp(httpApp)
      .serve
}}
