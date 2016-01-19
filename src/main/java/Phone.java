import java.util.List;
import org.sql2o.*;

public class Phone {
  private int mAreaCode;
  private int mPhoneNumber;
  private String mType;
  private int id;
  private int contactId;

  public Phone(int areaCode, int phoneNumber, String type, int contactId) {
    mAreaCode = areaCode;
    mPhoneNumber = phoneNumber;
    mType = type;
    this.contactId = contactId;
  }

  public int getAreaCode(){
    return mAreaCode;
  }

  public int getId(){
    return id;
  }

  public String getPhoneNumber() {
    String areaCode = Integer.toString(mAreaCode);
    String phoneNumber = Integer.toString(mPhoneNumber);
    return areaCode + "-" + phoneNumber;
  }
  public String getType(){
    return mType;
  }

  public void save(){
    String sql = "INSERT INTO phones (area_code, phone, type, contact_id) VALUES(:area, :phone, :type, :contact)";
    try (Connection con = DB.sql2o.open()){
      this.id = (int) con.createQuery(sql, true)
        .addParameter("area", mAreaCode)
        .addParameter("phone", mPhoneNumber)
        .addParameter("type", mType)
        .addParameter("contact", contactId)
        .executeUpdate()
        .getKey();
    }
  }

  public static List<Phone> all(int contactId){
    String sql = "SELECT id, area_code AS mAreaCode, phone AS mPhoneNumber, type AS mType, contact_id AS contactId FROM phones WHERE contact_id = :id";
    try(Connection con = DB.sql2o.open()){
      return con.createQuery(sql)
        .addParameter("id", contactId)
        .executeAndFetch(Phone.class);
    }
  }

}
