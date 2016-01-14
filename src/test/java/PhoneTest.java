import org.junit.*;
import static org.junit.Assert.*;

public class PhoneTest {

  @Test
  public void phone_instantiatesCorrectly_true(){
    Phone newPhone = new Phone(503, 5551212, "Home");
    assertEquals(true, newPhone instanceof Phone);
  }

  @Test
  public void phone_savesAreaCode_503() {
    Phone areaCode = new Phone(503, 5555555, "");
    assertEquals(503, areaCode.getAreaCode());
  }

  @Test
  public void phone_returnsNumber_5551122(){
    Phone phoneNumber = new Phone(503, 5551122, "cell");
    assertEquals("503-5551122", phoneNumber.getPhoneNumber());
  }

  @Test
  public void phone_returnsType_cell() {
    Phone type = new Phone(503, 5551122, "cell");
    assertEquals("cell", type.getType());
  }

}
