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

      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/blabla", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/contacts.vtl");

      //Contact contact =

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

      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
    post("/newNumber", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/success.vtl");
      Phone phone = new Phone(Integer.parseInt(request.queryParams("areaCode")), (Integer.parseInt(request.queryParams("phoneNumber"))), request.queryParams("type"));
      model.put("phone", phone);
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
  }
}
