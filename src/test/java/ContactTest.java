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
  public void contact_returnId_1(){
    Contact date = new Contact("", "", "1960/01/01");
    assertEquals(1, date.getId());
  }

  @Test
  public void contact_returnsContactById_true(){
    Contact newContact = new Contact("Vasya", "Petrov", "1987/07/7");
    assertEquals(newContact, Contact.find(1));
  }

  @Test
  public void contact_returnsContactById_null(){
    Contact newContact = new Contact("Vasya", "Petrov", "1987/07/7");
    assertEquals(null, Contact.find(898));
  }

  @Test
  public void contact_returnAmountOfNumbers_2(){
    Contact contact = new Contact("Fist", "Last", "1960/01/01");
    Phone firstPhone = new Phone (503, 1112233, "cell");
    Phone secondPhone = new Phone (503, 1112234, "home");
    contact.addNumber(firstPhone);
    contact.addNumber(secondPhone);
    assertEquals(2, contact.numberAmount());
  }

  @Test
  public void contact_returnNumberByID_5031112233cell(){
    Contact contact = new Contact("Fist", "Last", "1960/01/01");
    Phone firstPhone = new Phone (503, 1112233, "cell");
    Phone secondPhone = new Phone (503, 1112234, "home");
    contact.addNumber(firstPhone);
    contact.addNumber(secondPhone);
    assertEquals("503-1112233 cell", contact.getPhoneNumber(1));
    assertEquals("503-1112234 home", contact.getPhoneNumber(2));
  }

  @Test
  public void contact_returnListOfNumbers(){
    Contact contact = new Contact("Fist", "Last", "1960/01/01");
    Phone firstPhone = new Phone (503, 1112233, "cell");
    Phone secondPhone = new Phone (503, 1112234, "home");
    contact.addNumber(firstPhone);
    contact.addNumber(secondPhone);
    assertEquals(2, contact.getNumberList().size());
  }

  @Test
  public void contact_emptiesAllTasksFromArrayList() {
    Contact contact = new Contact("Fist", "Last", "1960/01/01");
    Contact.clear();
    assertEquals(contact.getNumberList().size(), 0);
  }

  @Test
  public void contact_returnListOfContacts_true() {
    Contact firstContact = new Contact("Fist", "Last", "1960/01/01");
    Contact secondContact = new Contact("Very fist", "Very last", "960/01/02");
    assertEquals(2, Contact.getContactList().size());
  }

  @Test
  public void contact_returnListOfEmails_true() {
    Contact newContact = new Contact("First", "Last", "1900/01/22");
    Email firstEmail = new Email("awd@awd.awd", "home");
    Email secondEmail = new Email("ad@aw.awd", "work");
    newContact.addEmail(firstEmail);
    newContact.addEmail(secondEmail);
    assertTrue(newContact.getEmailList().contains(firstEmail));
    assertTrue(newContact.getEmailList().contains(secondEmail));
  }

  @Test
  public void contact_returnListOfAddresses_true() {
    Contact newContact = new Contact("First", "Last", "1900/01/22");
    Address firstAddress = new Address("Abbe St.", "301", "Portland", "Oregon", "97210", "home");
    Address secondAddress = new Address("Abbe St.", "302", "Portland", "Oregon", "97210", "work");
    newContact.addAddress(firstAddress);
    newContact.addAddress(secondAddress);
    assertTrue(newContact.getAddressList().contains(firstAddress));
    assertTrue(newContact.getAddressList().contains(secondAddress));
  }


}
