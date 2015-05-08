package scala.migrations.slick.sbtplugin

import scala.migrations.slick._

import sbt._
import Keys._

trait Commands {
  def init(mm: SlickMigrationManager) = {
    mm.init
  }

  def reset(mm: SlickMigrationManager) = {
    mm.reset
  }

  def status(mm: SlickMigrationManager) = {
    val ny = mm.notYetAppliedMigrations
    if( ny.size == 0 )
      println("your database is up-to-date")
    else
      println("your database is outdated, not yet applied migrations: " + mm.notYetAppliedMigrations.map(_.id).mkString(", "))
  }

  def migrate(mm: SlickMigrationManager) = {
    println("applying migrations: "+mm.notYetAppliedMigrations.map(_.id).mkString(", "))
    mm.up
  }

  def preview(mm: SlickMigrationManager) = {
    println("-" * 80)
    println("NOT YET APPLIED MIGRATIONS PREVIEW:")
    println("")
    mm.notYetAppliedMigrations.map{
      migration =>
      migration match{
        case m:SqlMigration[_] =>
          println( migration.id+" SqlMigration:")
          println( "\t" + m.queries.mkString("\n\t") )
        case m:GenericMigration[_] =>
          println( migration.id+" GenericMigration:")
          println( "\t" + m.code )
      }
      println("")
    }
    println("-" * 80)
  }

  def dbdump(mm: SlickMigrationManager) = {
    import scala.slick.driver.H2Driver.simple._
    import Database.dynamicSession
    import scala.slick.jdbc.StaticQuery._
    mm.db.withDynSession{
      println( queryNA[String]("SCRIPT").list.mkString("\n") )
    }
  }
}


class SlickMigrationPlugin extends AutoPlugin with Commands {

  // not intended to be used by users
  private object EmptySlickMigrationManager extends SlickMigrationManager {
    override def migrations = List()
  }

  def migrationManager: SlickMigrationManager = EmptySlickMigrationManager

  override lazy val projectSettings = Seq(commands ++= allCommands)

  def allCommands = Seq(
    initCommand, resetCommand, statusCommand,
    applyCommand, previewCommand, dbdumpCommand)

  lazy val initCommand = Command.command("init") { (state: State) =>
    init(migrationManager)
    state
  }

  lazy val resetCommand = Command.command("reset") { (state: State) =>
    reset(migrationManager)
    state
  }

  lazy val statusCommand = Command.command("status") { (state: State) =>
    status(migrationManager)
    state
  }

  lazy val migrateCommand = Command.command("migrate") { (state: State) =>
    migrate(migrationManager)
    state
  }

  lazy val previewCommand = Command.command("preview") { (state: State) =>
    preview(migrationManager)
    state
  }

  lazy val dbdumpCommand = Command.command("dbdump") { (state: State) =>
    dbdump(migrationManager)
    state
  }
}

object SlickMigrationPlugin
