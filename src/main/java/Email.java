public class Email{
  private String email;
  private String type;

  public Email(String email, String type){
    this.email = email;
    this.type = type;
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
}
