name := "vir"

Global / onChangedBuildSource := ReloadOnSourceChanges
ThisBuild / scalaVersion := "3.0.2"
ThisBuild / useSuperShell := false

lazy val backend = project
  .in(file("."))
  .settings(
    libraryDependencies ++= Seq(
      "org.tpolecat" %% "doobie-core" % "1.0.0-RC1",
      "org.tpolecat" %% "doobie-hikari" % "1.0.0-RC1",
      "org.tpolecat" %% "doobie-postgres"  % "1.0.0-RC1",
      "org.http4s" %% "http4s-blaze-server" % "0.23.5",
      "org.http4s" %% "http4s-circe" % "0.23.5",
      "org.http4s" %% "http4s-dsl" % "0.23.5",
      "io.circe" %% "circe-generic" % "0.14.1",
      "org.scalameta" %% "munit" % "0.7.29" % Test,
      "org.typelevel" %% "munit-cats-effect-3" % "1.0.6" % Test,
      "org.typelevel" %% "cats-core" % "2.6.1",
      "org.typelevel" %% "cats-effect" % "3.2.9",
      "ch.qos.logback" % "logback-classic" % "1.2.6"
    )
  )