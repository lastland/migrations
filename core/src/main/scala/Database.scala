package scala.migrations

abstract class MigrationDatabase {
  def copy(branch: String, commitId: String): Unit
  def use(branch: String, commitId: String): Unit
  def rebuild(branch: String, commitId: String): Unit
}
