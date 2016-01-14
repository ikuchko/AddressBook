import java.util.Date;
import java.util.*;
import java.text.SimpleDateFormat;

  public class Contact {
  private static ArrayList<Phone> phoneNumbers = new ArrayList<Phone>();
  private static ArrayList<Contact> contactList = new ArrayList<Contact>();
  private String mFirstName;
  private String mLastName;
  private String mBirthDate;

  public Contact(String firstName, String lastName, String birthDate) {
    mFirstName = firstName;
    mLastName = lastName;
    mBirthDate = birthDate;
    contactList.add(this);
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

  public Boolean addNumber(int areaCode, int number, String phoneNumberType){
    if ((areaCode >= 0) && (number >= 0) && !(phoneNumberType == "")){
        Phone phoneNumber = new Phone(areaCode, number, phoneNumberType);
        phoneNumbers.add(phoneNumber);
        return true;
    } else {
      return false;
    }
  }

  public int numberAmount(){
    return phoneNumbers.size();
  }

  public String getPhoneNumber(int number) {
    Phone phone;
    phone = phoneNumbers.get(number-1);
    return phone.getPhoneNumber() + " " + phone.getType();
  }

  public static ArrayList<Phone> getNumberList() {
    return phoneNumbers;

  }

  public static void clear(){
    phoneNumbers.clear();
    contactList.clear();
  }

  public static ArrayList<Contact> getContactList() {
    return contactList;
  }
}
