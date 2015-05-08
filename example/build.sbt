lazy val root = project.in(file(".")).
  enablePlugins(MyMigrationPlugin).
  settings(
    organization := "com.typesafe",
    name := "migrations-example",
    version := "1.0",
    scalaVersion := "2.11.6",
    scalacOptions += "-deprecation",
    scalacOptions += "-feature",
    libraryDependencies ++= List(
      "com.h2database" % "h2" % "1.3.166"
        ,"org.xerial" % "sqlite-jdbc" % "3.6.20"
        ,"org.slf4j" % "slf4j-nop" % "1.6.4" // <- disables logging
        ,"com.typesafe" %% "slick-migrations" % "1.0"
/*
  // enables logging
  ,"org.slf4j" % "slf4j-api" % "1.6.4"
  ,"ch.qos.logback" % "logback-classic" % "0.9.28"
*/
    ))
