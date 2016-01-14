public class Phone {
  private int mAreaCode;
  private int mPhoneNumber;
  private String mType;

  public Phone(int areaCode, int phoneNumber, String type) {
    mAreaCode = areaCode;
    mPhoneNumber = phoneNumber;
    mType = type;
  }

  public int getAreaCode(){
    return mAreaCode;
  }

  public String getPhoneNumber() {
    String areaCode = Integer.toString(mAreaCode);
    String phoneNumber = Integer.toString(mPhoneNumber);
    return areaCode + "-" + phoneNumber;
  }
  public String getType(){
    return mType;
  }
}
