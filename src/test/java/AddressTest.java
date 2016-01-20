import org.junit.*;
import static org.junit.Assert.*;
import java.util.*;

public class AddressTest {

  @Rule
  public DatabaseRule database = new DatabaseRule();

  @Test
  public void address_instantiatesCorrectly(){
    Address newAddress = new Address("Abbe St.", "301", "Portland", "Oregon", "97210", "home", 1);
    assertTrue(newAddress instanceof Address);
  }

  @Test
  public void address_returnStreetAptCityStateZipCode_true(){
    Address newAddress = new Address("Abbe St.", "301", "Portland", "Oregon", "97210", "home", 1);
    assertEquals("Abbe St.", newAddress.getStreet());
    assertEquals("301", newAddress.getApartment());
    assertEquals("Portland", newAddress.getCity());
    assertEquals("Oregon", newAddress.getState());
    assertEquals("97210", newAddress.getZipCode());
    assertEquals("home", newAddress.getType());
  }

  @Test
  public void address_returnWholeAdressOnce_true(){
    Address newAddress = new Address("Abbe St.", "301", "Portland", "Oregon", "97210", "home", 1);
    assertEquals("Abbe St. Apt 301 Portland Oregon 97210", newAddress.getAddress());
  }

  @Test
  public void address_findAddressById() {
    Address newAddress = new Address ("Abbe St.", "301", "Portland", "Oregon", "97210", "home", 1);
    newAddress.save();
    Address savedAddress = Address.find(newAddress.getId());
    assertEquals(newAddress.getId(), savedAddress.getId());
  }

  @Test
  public void address_returnsAllAddresses_true() {
    Contact newContact = new Contact("First", "Last", "1900-01-22");
    Address firstAddress = new Address ("Abbe St.", "301", "Portland", "Oregon", "97210", "home", 1);
    Address secondAddress = new Address ("Abbe St.", "301", "Portland", "Oregon", "97210", "home", 1);
    firstAddress.save();
    secondAddress.save();
    Address[] addresses = new Address[] {firstAddress, secondAddress};
    assertTrue(newContact.getAddressList().containsAll(Arrays.asList(addresses)));
  }
}
