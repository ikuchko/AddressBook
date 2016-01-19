import java.util.List;
import org.sql2o.*;

public class Email{
  private String email;
  private String type;
  private int id;
  private int contactId;

  public Email(String email, String type, int contactId){
    this.email = email;
    this.type = type;
    this.contactId = contactId;
  }

  @Override
  public boolean equals(Object otherEmail) {
    if (!(otherEmail instanceof Email)) {
      return false;
    } else {
      Email newEmail = (Email) otherEmail;
      return this.getEmail().equals(newEmail.getEmail());
    }
  }

  public String getEmail(){
    return email;
  }

  public String getType(){
    return type;
  }

  public int getId(){
    return id;
  }

  public void save(){
    String sql = "INSERT INTO emails (email, type, contact_id) VALUES (:email, :type, :contactId)";
    try (Connection con = DB.sql2o.open()){
      this.id = (int) con.createQuery(sql, true)
        .addParameter("email", email)
        .addParameter("type", type)
        .addParameter("contactId", contactId)
        .executeUpdate()
        .getKey();
    }
  }

  public static List<Email> all(){
    String sql = "SELECT id, email, type, contact_id AS contactId FROM emails";
    try (Connection con = DB.sql2o.open()){
      return con.createQuery(sql).executeAndFetch(Email.class);
    }
  }

  public static Email find(int id){
    String sql = "SELECT id, email, type, contact_id AS contactId FROM emails WHERE id=:id";
    try(Connection con = DB.sql2o.open()){
      return (Email) con.createQuery(sql)
        .addParameter("id", id)
        .executeAndFetchFirst(Email.class);
    }
  }
}
