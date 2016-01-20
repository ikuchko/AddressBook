import org.junit.*;
import static org.junit.Assert.*;
import java.util.*;

public class PhoneTest {

  @Rule
  public DatabaseRule database = new DatabaseRule();

  @Test
  public void phone_instantiatesCorrectly_true(){
    Phone newPhone = new Phone(503, 5551212, "Home", 1);
    assertEquals(true, newPhone instanceof Phone);
  }

  @Test
  public void phone_savesAreaCode_503() {
    Phone areaCode = new Phone(503, 5555555, "", 1);
    assertEquals(503, areaCode.getAreaCode());
  }

  @Test
  public void phone_returnsNumber_5551122(){
    Phone phoneNumber = new Phone(503, 5551122, "cell", 1);
    assertEquals("503-5551122", phoneNumber.getPhoneNumber());
  }

  @Test
  public void phone_returnsType_cell() {
    Phone type = new Phone(503, 5551122, "cell", 1);
    assertEquals("cell", type.getType());
  }

  @Test
  public void phone_entersIdintoDB() {
    Phone newPhone = new Phone (503, 5551122, "cell", 1);
    newPhone.save();
    assertEquals(Phone.all(1).get(0).getId(), newPhone.getId());
  }

  @Test
  public void phone_findsPhoneInDatabase_true() {
    Phone newPhone = new Phone (503, 5551122, "cell", 1);
    newPhone.save();
    Phone savedPhone = Phone.find(newPhone.getId());
    assertTrue(newPhone.equals(savedPhone));
  }

  @Test
  public void email_retunsAllPhones_true(){
    Contact newContact = new Contact("First", "Last", "1900-01-22");
    Phone firstPhone = new Phone(503, 5551122, "cell", newContact.getId());
    Phone secondPhone = new Phone(503, 5551121, "home", newContact.getId());
    firstPhone.save();
    secondPhone.save();
    Phone[] phones = new Phone[] {firstPhone, secondPhone};
    assertTrue(newContact.getPhoneList().containsAll(Arrays.asList(phones)));
  }
}
