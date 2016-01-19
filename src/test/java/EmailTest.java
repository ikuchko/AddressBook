import org.junit.*;
import static org.junit.Assert.*;
import java.util.*;

public class EmailTest {

  @Rule
   public DatabaseRule database = new DatabaseRule();

  @Test
  public void email_instantiateCorrectly_true(){
    Email newEmail = new Email ("email@mail.com", "home", 1);
    assertTrue(newEmail instanceof Email);
  }

  @Test
  public void email_returnEmail(){
    Email newEmail = new Email("email@mail.com", "home", 1);
    assertEquals("email@mail.com", newEmail.getEmail());
  }

  @Test
  public void email_returnType(){
    Email newEmail = new Email("email@mail.com", "home", 1);
    assertEquals("home", newEmail.getType());
  }

  @Test
  public void email_findEmailById(){
    Email newEmail = new Email("email@mail.com", "home", 1);
    newEmail.save();
    Email savedEmail = Email.find(newEmail.getId());
    assertTrue(newEmail.equals(savedEmail));
  }

  @Test
  public void email_retunsAllEmails_true(){
    Contact newContact = new Contact("First", "Last", "1900-01-22");
    Email firstEmail = new Email("emsail@mail.com", "work", newContact.getId());
    Email secondEmail = new Email("email@mail.com", "home", newContact.getId());
    firstEmail.save();
    secondEmail.save();
    Email[] emails = new Email[] {firstEmail, secondEmail};
    assertTrue(newContact.getEmailList().containsAll(Arrays.asList(emails)));
  }

}
