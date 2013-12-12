import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.template.freemarker.FreeMarkerRoute;
import java.util.HashMap;
import java.util.Map;
import static spark.Spark.get;

public class HelloWorld {

    public static void main(String[] args) {

        get(new FreeMarkerRoute("/index") {
            @Override
            public ModelAndView handle(Request request, Response response) {
                Map<String, Object> attributes = new HashMap<>();
                attributes.put("message", "Hello World!");

                return modelAndView(attributes, "index.ftl");
            }
        });

    }
}