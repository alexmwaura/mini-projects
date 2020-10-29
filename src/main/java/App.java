import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;

public class App {
    public static void main(String[] args) {
        staticFileLocation("/public");
        get("/", (req,res)-> {
            Map<String, Object> model = new HashMap<String,Object >();
            return new ModelAndView(model,"hello.hbs");
        }, new HandlebarsTemplateEngine());
        get("/images", (req,res)->{
            Map<String, Object> model = new HashMap<String, Object>();
            return new ModelAndView(model, "favorite-images.hbs");
        }, new HandlebarsTemplateEngine());
        get("/forms", (req,res)-> {
            Map<String, Object> model = new HashMap<String, Object>();
            return new ModelAndView(model, "forms.hbs");
        },new HandlebarsTemplateEngine());
        get("/greeting_card", (req,res)-> {
            Map<String, Object> model = new HashMap<String, Object>();
            String recipient = req.queryParams("recipient");
            String sender = req.queryParams("sender");
            model.put("recipient", recipient);
            model.put("sender", sender);
            return new ModelAndView(model, "greeting_card.hbs");
        }, new HandlebarsTemplateEngine());
    }

}
