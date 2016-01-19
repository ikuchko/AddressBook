import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;
import java.util.Random;

public class App {
  public static void main(String[] args) {
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/index.vtl");

      model.put("contacts", Contact.getContactList());

      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/contact/:id", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/contact.vtl");

      model.put("contact", Contact.find(Integer.parseInt(request.params(":id"))));

      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/newContact", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/newContact.vtl");

      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/success", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/success.vtl");

      Contact contact = new Contact(request.queryParams("firstName"), request.queryParams("lastName"), request.queryParams("dateOfBirth"));

      model.put("contact", contact);
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/newNumber", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/newNumber.vtl");

      model.put("contactId", request.queryParams("contactId"));

      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
    // post("/newNumber", (request, response) -> {
    //   Map<String, Object> model = new HashMap<String, Object>();
    //   model.put("template", "templates/success.vtl");
    //
    //   String id = request.queryParams("contactId");
    //   Phone phone = new Phone(Integer.parseInt(request.queryParams("areaCode")), (Integer.parseInt(request.queryParams("phoneNumber"))), request.queryParams("type"));
    //   Contact.find(Integer.parseInt(id)).addNumber(phone);
    //   model.put("phone", phone);
    //   model.put("contactId", id);
    //   return new ModelAndView(model, layout);
    // }, new VelocityTemplateEngine());
  }
}
