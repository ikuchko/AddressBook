public class Address{
  private String street;
  private String apartment;
  private String city;
  private String state;
  private String zipCode;
  private String type;

  public Address(String street, String apartment, String city, String state, String zipCode, String type){
    this.street = street;
    this.apartment = apartment;
    this.city = city;
    this.state = state;
    this.zipCode = zipCode;
    this.type = type;
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


}
