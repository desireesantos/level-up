import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import spark.Request;
import spark.Response;
import spark.Route;

import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import static spark.Spark.get;

public class HelloWorld {

    public static void main(String[] args) {

        final Configuration setup = new Configuration();
        setup.setClassForTemplateLoading(HelloWorld.class, "/");

        get(new Route("/index") {
            @Override
            public Object handle(Request request, Response response) {
                StringWriter view = new StringWriter();
                Map<String, Object> attributes = new HashMap<>();
                attributes.put("name", "Hello Word");
                try {
                    Template template = setup.getTemplate("view/index.html");
                    template.process(attributes, view);
                } catch (TemplateException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return view;
            }
        });
    }
}