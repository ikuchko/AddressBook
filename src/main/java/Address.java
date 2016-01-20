import java.util.*;
import org.sql2o.*;

public class Address{
  private String street;
  private String apartment;
  private String city;
  private String state;
  private String zipCode;
  private String type;
  private int id;
  private int contactId;

  public Address(String street, String apartment, String city, String state, String zipCode, String type, int contactId){
    this.street = street;
    this.apartment = apartment;
    this.city = city;
    this.state = state;
    this.zipCode = zipCode;
    this.type = type;
  }

  @Override
  public boolean equals(Object otherAddress) {
    if (!(otherAddress instanceof Address)) {
      return false;
    } else {
      Address newAddress = (Address) otherAddress;
      return this.getAddress().equals(newAddress.getAddress());
    }
  }

  public String getStreet(){
    return street;
  }
  public String getApartment(){
    return apartment;
  }
  public String getCity(){
    return city;
  }
  public String getState(){
    return state;
  }
  public String getZipCode(){
    return zipCode;
  }
  public String getType(){
    return type;
  }

  public String getAddress(){
    return String.format("%s Apt %s %s %s %s", street, apartment, city, state, zipCode);
  }

  public int getId() {
    return id;
  }

  public void save() {
    String sql = "INSERT INTO addresses (street, apartment, city, state, zip_code, type, contact_id) VALUES (:street, :apartment, :city, :state, :zipCode, :type, :contactId)";
    try (Connection con = DB.sql2o.open()) {
      this.id = (int) con.createQuery(sql, true)
        .addParameter("street", street)
        .addParameter("apartment", apartment)
        .addParameter("city", city)
        .addParameter("state", state)
        .addParameter("zipCode", Integer.valueOf(zipCode))
        .addParameter("type", type)
        .addParameter("contactId", contactId)
        .executeUpdate()
        .getKey();
    }
  }

  public static List<Address> all() {
    String sql = "SELECT id, street, apartment, city, state, zip_code AS zipCode, type, contact_id AS contactId FROM addresses";
    try (Connection con = DB.sql2o.open()) {
      return con.createQuery(sql).executeAndFetch(Address.class);
    }
  }

  public static Address find(int id) {
    String sql = "SELECT id, street, apartment, city, state, zip_code AS zipCode, type, contact_id AS contactId FROM addresses WHERE id=:id";
    try(Connection con = DB.sql2o.open()) {
      return (Address) con.createQuery(sql)
        .addParameter("id", id)
        .executeAndFetchFirst(Address.class);
    }
  }
}
