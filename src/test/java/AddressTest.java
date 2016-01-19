import org.junit.*;
import static org.junit.Assert.*;

public class AddressTest {

  @Rule
  public ClearRule clearRule = new ClearRule();

  @Test
  public void address_instantiatesCorrectly(){
    Address newAddress = new Address("Abbe St.", "301", "Portland", "Oregon", "97210", "home");
    assertTrue(newAddress instanceof Address);
  }

  @Test
  public void address_returnStreetAptCityStateZipCode_true(){
    Address newAddress = new Address("Abbe St.", "301", "Portland", "Oregon", "97210", "home");
    assertEquals("Abbe St.", newAddress.getStreet());
    assertEquals("301", newAddress.getApartment());
    assertEquals("Portland", newAddress.getCity());
    assertEquals("Oregon", newAddress.getState());
    assertEquals("97210", newAddress.getZipCode());
    assertEquals("home", newAddress.getType());
  }

  @Test
  public void address_returnWholeAdressOnce_true(){
    Address newAddress = new Address("Abbe St.", "301", "Portland", "Oregon", "97210", "home");
    assertEquals("Abbe St. Apt 301 Portland Oregon 97210", newAddress.getAddress());
  }


}
