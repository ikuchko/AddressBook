import org.junit.rules.ExternalResource;
import org.sql2o.*;

public class DatabaseRule extends ExternalResource {

  protected void before() {
    DB.sql2o = new Sql2o("jdbc:postgresql://localhost:5432/address_book_test", null, null);
   }

  protected void after() {
    try(Connection con = DB.sql2o.open()) {
      String sqlContact = "DELETE FROM contacts *;";
      String sqlPhone = "DELETE FROM phones *;";
      String sqlAddress = "DELETE FROM addresses *;";
      String sqlEmail = "DELETE FROM emails *;";
      con.createQuery(sqlContact).executeUpdate();
      con.createQuery(sqlPhone).executeUpdate();
      con.createQuery(sqlAddress).executeUpdate();
      con.createQuery(sqlEmail).executeUpdate();
    }
  }
}
