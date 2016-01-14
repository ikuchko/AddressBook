import java.util.Date;
import java.util.*;
import java.text.SimpleDateFormat;

  public class Contact {
  private static ArrayList<Phone> phoneNumbers = new ArrayList<Phone>();

  private String mFirstName;
  private String mLastName;
  private String mBirthDate;

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


}
