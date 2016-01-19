import java.util.Date;
import java.util.*;
import java.text.SimpleDateFormat;

  public class Contact {
  private ArrayList<Phone> phoneNumbers = new ArrayList<Phone>();
  private static ArrayList<Contact> contactList = new ArrayList<Contact>();
  private ArrayList<Email> emailList = new ArrayList<Email>();
  private ArrayList<Address> addressList = new ArrayList<Address>();
  private String mFirstName;
  private String mLastName;
  private String mBirthDate;
  private int id;

  public Contact(String firstName, String lastName, String birthDate) {
    mFirstName = firstName;
    mLastName = lastName;
    mBirthDate = birthDate;
    contactList.add(this);
    this.id = contactList.size();
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

  public static Contact find(int id){
    try {
      return contactList.get(id-1);
    } catch (IndexOutOfBoundsException ioobe) {
      return null;
    }
  }

  public void addNumber(Phone phoneNumber){
    phoneNumbers.add(phoneNumber);
  }

  public int numberAmount(){
    return phoneNumbers.size();
  }

  public String getPhoneNumber(int number) {
    Phone phone;
    phone = phoneNumbers.get(number-1);
    return phone.getPhoneNumber() + " " + phone.getType();
  }

  public ArrayList<Phone> getNumberList() {
    return phoneNumbers;

  }

  public static void clear(){
    contactList.clear();
    for (Contact contact: Contact.getContactList()){
      contact.clearData();
    }
  }
  public void clearData(){
    phoneNumbers.clear();
    emailList.clear();
    addressList.clear();
  }

  public static ArrayList<Contact> getContactList() {
    return contactList;
  }

  public void addEmail(Email email){
    emailList.add(email);
  }

  public ArrayList<Email> getEmailList() {
    return emailList;
  }

  public void addAddress(Address address){
    addressList.add(address);
  }

  public ArrayList<Address> getAddressList(){
    return addressList;
  }

}
