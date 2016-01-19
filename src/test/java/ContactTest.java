import org.junit.*;
import static org.junit.Assert.*;

public class ContactTest {

  @Rule
  public DatabaseRule database = new DatabaseRule();

  @Test
  public void contact_instantiatesCorrectly_true(){
    Contact newContact = new Contact("Chris", "Houghton", "1980/01/01");
    assertEquals(true, newContact instanceof Contact);
  }

  @Test
  public void contact_returnsTrueIfContactsAreTheSame(){
    Contact firstContact = new Contact("First", "Last", "1900/01/22");
    Contact secondContact = new Contact("First", "Last", "1900/01/22");
    assertTrue(firstContact.equals(secondContact));
  }

  @Test
  public void contact_entersIdIntoDB() {
    Contact newContact = new Contact ("First", "Last", "1900-01-22");
    newContact.save();
    assertEquals(Contact.all().get(0).getId(), newContact.getId());
  }

  @Test
  public void contact_findContactById_true(){
    Contact newContact = new Contact("First", "Last", "1900-01-22");
    newContact.save();
    assertTrue(newContact.equals(Contact.find(newContact.getId())));
  }


}
