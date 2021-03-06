import slick.driver.H2Driver.api._
import scala.migrations.slick.GenericMigration
import datamodel.v1.schema.tables.Users
import datamodel.v1.schema.tables.UsersRow

object M2 {
  MyMigrations.migrations = MyMigrations.migrations :+ GenericMigration( 2 )(
    // this is typesafe :), but requires the corresponding code version to have been generated
    // if you really have to do content changes in migrations, make sure they cannot conflict with data in one of your installations
    DBIO.seq(Users ++= Seq(
      UsersRow(1, "Chris","Vogt"),
      UsersRow(2, "Stefan","Zeiger")
    )))
}
