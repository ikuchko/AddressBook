import org.fluentlenium.adapter.FluentTest;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.Rule;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import static org.fluentlenium.core.filter.FilterConstructor.*;
import static org.assertj.core.api.Assertions.assertThat;

public class AppTest extends FluentTest {
  public WebDriver webDriver = new HtmlUnitDriver();
  public WebDriver getDefaultDriver() {
      return webDriver;
  }

  @ClassRule
  public static ServerRule server = new ServerRule();

  @Rule
  public ClearRule clearRule = new ClearRule();

  // @Test
  // public void rootTest(){
  //   goTo("http://localhost:4567/");
  //   assertThat(pageSource()).contains("Welcome to address book");
  // }
  //
  // @Test
  // public void newContactPageTest(){
  //   goTo("http://localhost:4567/");
  //   submit(".btn");
  //   assertThat(pageSource()).contains("Enter your first name");
  // }
  //
  // @Test
  // public void newContactSuccsessfulyCreated(){
  //   goTo("http://localhost:4567/newContact");
  //   fill("#firstName").with("Sergei");
  //   fill("#lastName").with("Seroeschkin");
  //   fill("#dateOfBirth").with("1654/12/12");
  //   submit(".btn");
  //   assertThat(pageSource()).contains("You successfuly create new contact");
  // }
  //
  // @Test
  // public void contactInformationPageTest(){
  //   goTo("http://localhost:4567/newContact");
  //   fill("#firstName").with("Sergei");
  //   fill("#lastName").with("Seroeschkin");
  //   fill("#dateOfBirth").with("1654/12/12");
  //   submit(".btn");
  //   click("a", withText("Return to contacts"));
  //   click("a", withText("Seroeschkin Sergei (0 number(s) available)"));
  //   assertThat(pageSource()).contains("Contacts: Sergei Seroeschkin");
  // }
  //
  // @Test
  // public void NewPhoneNumberPageTest(){
  //   goTo("http://localhost:4567/contact/1");
  //   submit(".btn");
  //   assertThat(pageSource()).contains("Enter area code");
  // }
  //
  // @Test
  // public void createdNewPhoneNumberSuccessfuly(){
  //   goTo("http://localhost:4567/newContact");
  //   fill("#firstName").with("Sergei");
  //   fill("#lastName").with("Seroeschkin");
  //   fill("#dateOfBirth").with("1654/12/12");
  //   submit(".btn");
  //   click("a", withText("Return to contacts"));
  //   click("a", withText("Seroeschkin Sergei (0 number(s) available)"));
  //   submit(".btn");
  //   fill("#areaCode").with("503");
  //   fill("#phoneNumber").with("1112233");
  //   fill("#type").with("home");
  //   submit(".btn");
  //   assertThat(pageSource()).contains("You successfuly create new phone number:");
  // }


}
