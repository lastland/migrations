package example.build

import scala.migrations.slick._

trait MyCommands {
  def codegen(mm: MyMigrationManager) {
    SampleCodegen.gen( mm ) // mm is passed in here only because it contains the db connection
  }
}
