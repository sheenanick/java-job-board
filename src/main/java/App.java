import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.time.LocalDate;
import java.time.Month;
import java.text.DateFormatSymbols;

import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {

  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/", (request, response) ->  {
    Map<String, Object> model = new HashMap<String, Object>();
    model.put("jobOpenings", request.session().attribute("jobOpenings"));
    model.put("template", "templates/index.vtl");
    return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/jobOpenings", (request,response) -> {
      Map<String, Object> model = new HashMap<String, Object>();

      ArrayList<JobOpening> jobOpenings = request.session().attribute("jobOpenings");
      if (jobOpenings == null) {
        jobOpenings = new ArrayList<JobOpening>();
        request.session().attribute("jobOpenings", jobOpenings);
      }

      String title = request.queryParams("title");
      String description = request.queryParams("description");
      String contact = request.queryParams("contact");

      JobOpening newOpening = new JobOpening(title,description, contact);
      jobOpenings.add(newOpening);
      model.put("jobOpenings", request.session().attribute("jobOpenings"));
      model.put("template","templates/index.vtl");
      return new ModelAndView(model,layout);
    }, new VelocityTemplateEngine());


  }

}
