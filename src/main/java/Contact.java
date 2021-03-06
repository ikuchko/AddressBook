import java.util.Date;
import java.util.*;
import java.text.SimpleDateFormat;
import org.sql2o.*;

  public class Contact {
  // private ArrayList<Phone> phoneNumbers = new ArrayList<Phone>();
  // private static ArrayList<Contact> contactList = new ArrayList<Contact>();
  // private ArrayList<Email> emailList = new ArrayList<Email>();
  // private ArrayList<Address> addressList = new ArrayList<Address>();
  private String mFirstName;
  private String mLastName;
  private String mBirthDate;
  private int id;

  public Contact(String firstName, String lastName, String birthDate) {
    mFirstName = firstName;
    mLastName = lastName;
    mBirthDate = birthDate;
  }

  public String getFirstName(){
    return mFirstName;
  }

  public String getLastName() {
    return mLastName;
  }

  public String getBirthDate(){
    return mBirthDate;
  }

  public int getId(){
    return id;
  }

  @Override
  public boolean equals(Object otherContact) {
    if (!(otherContact instanceof Contact)) {
      return false;
    } else {
      Contact newContact = (Contact) otherContact;
      return (this.getFirstName().equals(newContact.getFirstName())) &&
             (this.getLastName().equals(newContact.getLastName())) &&
             (this.getBirthDate().equals(newContact.getBirthDate())) &&
             (this.getId() == newContact.getId());
    }
  }

  public void save() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "INSERT INTO contacts(first_name, last_name, birth_date) VALUES (:firstName, :lastName, TO_DATE(:birthDate, 'yyyy-mm-dd'))";
      this.id = (int) con.createQuery(sql, true)
        .addParameter("firstName", this.mFirstName)
        .addParameter("lastName", this.mLastName)
        .addParameter("birthDate", this.mBirthDate)
        .executeUpdate()
        .getKey();
    }
  }

  public static List<Contact> all(){
    String sql = "SELECT id, first_name AS mFirstName, last_name AS mLastName, birth_date AS mBirthDate FROM contacts";
    try (Connection con = DB.sql2o.open()){
      return con.createQuery(sql).executeAndFetch(Contact.class);
    }
  }

  public static Contact find(int id) {
    try(Connection con = DB.sql2o.open()) {
      String sql = "SELECT id, first_name AS mFirstName, last_name AS mLastName, birth_date AS mBirthDate FROM contacts WHERE id=:id";
      Contact contact = con.createQuery(sql)
        .addParameter("id", id)
        .executeAndFetchFirst(Contact.class);
      return contact;
    }
  }



  // public int numberAmount(){
  //   return phoneNumbers.size();
  // }

  // public String getPhoneNumber(int number) {
  //   Phone phone;
  //   phone = phoneNumbers.get(number-1);
  //   return phone.getPhoneNumber() + " " + phone.getType();
  // }


  public List<Email> getEmailList() {
    String sql = "SELECT id, email, type, contact_id AS contactId FROM emails WHERE contact_id=:id";
    try(Connection con = DB.sql2o.open()) {
      return con.createQuery(sql)
        .addParameter("id", id)
        .executeAndFetch(Email.class);
    }
  }

  public List<Address> getAddressList(){
    String sql = "SELECT id, street, apartment, city, state, zip_code AS zipCode, type, contact_id AS contactId FROM addresses WHERE contact_id=:id";
    try(Connection con = DB.sql2o.open()){
      return con.createQuery(sql)
      .addParameter("id", id)
      .executeAndFetch(Address.class);
    }
  }

  public List<Phone> getPhoneList() {
    String sql = "SELECT id, area_code AS mAreaCode, phone AS mPhoneNumber, type AS mType, contact_id AS contactId FROM phones WHERE contact_id=:id";
    try(Connection con = DB.sql2o.open()) {
      return con.createQuery(sql)
        .addParameter("id", id)
        .executeAndFetch(Phone.class);
    }
  }

}
