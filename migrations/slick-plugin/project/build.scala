import sbt._
import Keys._
import Tests._

object slickPluginBuild extends Build {
  lazy val pluginProject = Project(
    "slick-migrations-sbt-plugin", file(".")) dependsOn(slickMigrationProject)
  lazy val slickMigrationProject = ProjectRef(
    file("../.."), "slick-migrations")
}
