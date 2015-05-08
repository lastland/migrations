package example.build

import sbt._
import Keys._

import scala.migrations.slick.sbtplugin.SlickMigrationPlugin

object MyMigrationPlugin extends SlickMigrationPlugin with MyCommands {
  override def migrationManager = SampleMigrations
  override def allCommands = super.allCommands ++ Seq(codegenCommand)

  lazy val codegenCommand = Command.command("codegen") { (state: State) =>
    codegen(migrationManager)
    state
  }

}
