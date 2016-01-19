import org.junit.*;
import static org.junit.Assert.*;

public class EmailTest {

  @Rule
  public ClearRule clearRule = new ClearRule();

  @Test
  public void email_instantiateCorrectly_true(){
    Email newEmail = new Email ("email@mail.com", "home");
    assertTrue(newEmail instanceof Email);
  }

  @Test
  public void email_returnEmail(){
    Email newEmail = new Email("email@mail.com", "home");
    assertEquals("email@mail.com", newEmail.getEmail());
  }

  @Test
  public void email_returnType(){
    Email newEmail = new Email("email@mail.com", "home");
    assertEquals("home", newEmail.getType());
  }


}
