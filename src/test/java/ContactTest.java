import org.junit.*;
import static org.junit.Assert.*;

public class ContactTest {

  @Rule
  public ClearRule clearRule = new ClearRule();

  @Test
  public void contact_instantiatesCorrectly_true(){
    Contact newContact = new Contact("Chris", "Houghton", "1980/01/01");
    assertEquals(true, newContact instanceof Contact);
  }

  @Test
  public void contact_returnsFirstName_Chris(){
    Contact newContact = new Contact("Chris","","1980/01/01");
    assertEquals("Chris",newContact.getFirstName());
  }

  @Test
  public void contact_returnsLastName_Kuchko(){
    Contact myContact = new Contact("Illia", "Kuchko", "1960/02/02");
    assertEquals("Kuchko", myContact.getLastName());
  }

  @Test
  public void contact_returnBirthDate_19600101(){
    Contact date = new Contact("", "", "1960/01/01");
    assertEquals("1960/01/01", date.getBirthDate());
  }

  @Test
  public void contact_CreatedANumberCorrectly_true(){
    Contact contact = new Contact("Fist", "Last", "1960/01/01");
    assertEquals(true, contact.addNumber(503, 1112233, "cell"));
  }

  @Test
  public void contact_returnAmountOfNumbers_2(){
    Contact contact = new Contact("Fist", "Last", "1960/01/01");
    contact.addNumber(503, 1112233, "cell");
    contact.addNumber(503, 1112244, "home");
    assertEquals(2, contact.numberAmount());
  }

  @Test
  public void contact_returnNumberByID_5031112233cell(){
    Contact contact = new Contact("Fist", "Last", "1960/01/01");
    contact.addNumber(503, 1112233, "cell");
    contact.addNumber(503, 1112244, "home");
    assertEquals("503-1112233 cell", contact.getPhoneNumber(1));
    assertEquals("503-1112244 home", contact.getPhoneNumber(2));
  }

  @Test
  public void contact_returnListOfNumbers(){
    Contact contact = new Contact("Fist", "Last", "1960/01/01");
    contact.addNumber(503, 1112233, "cell");
    contact.addNumber(503, 1112244, "home");
    assertEquals(2, contact.getNumberList().size());
  }

  @Test
  public void contact_emptiesAllTasksFromArrayList() {
    Contact contact = new Contact("Fist", "Last", "1960/01/01");
    Contact.clear();
    assertEquals(Contact.getNumberList().size(), 0);
  }

  @Test
  public void contact_returnListOfContacts_true() {
    Contact firstContact = new Contact("Fist", "Last", "1960/01/01");
    Contact secondContact = new Contact("Very fist", "Very last", "960/01/02");
    assertEquals(2, Contact.getContactList().size());
  }


}
