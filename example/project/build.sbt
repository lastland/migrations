organization := "com.typesafe"

name := "migrations-example"

version := "1.0"

scalaVersion := "2.10.4"

scalacOptions += "-deprecation"

scalacOptions += "-feature"

libraryDependencies ++= List(
  "com.typesafe" %% "migrations-core" % "1.0"
    ,"com.typesafe" %% "slick-migrations" % "1.0"
)
