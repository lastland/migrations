organization := "com.typesafe"

name := "slick-migrations"

version := "1.0"

scalaVersion := "2.11.6"

scalacOptions += "-deprecation"

scalacOptions += "-feature"

libraryDependencies ++= List(
  "com.typesafe.slick" %% "slick" % "2.1.0"
  ,"com.typesafe.slick" %% "slick-codegen" % "2.1.0"
  ,"org.scala-lang" % "scala-compiler" % "2.11.6"
  ,"com.typesafe" % "config" % "1.3.0"
  ,"com.h2database" % "h2" % "1.3.166"
  ,"org.xerial" % "sqlite-jdbc" % "3.6.20"
  ,"org.slf4j" % "slf4j-nop" % "1.6.4" // <- disables logging
  ,"org.scalatest" % "scalatest_2.11" % "2.2.4" % "test"
  ,"commons-io" % "commons-io" % "2.4" % "test"
)
