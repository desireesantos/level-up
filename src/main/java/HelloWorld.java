import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import spark.Request;
import spark.Response;
import spark.Route;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;

public class HelloWorld {

    public static void main(String[] args) {

        final Configuration configuration = new Configuration();
        configuration.setClassForTemplateLoading(HelloWorld.class, "/");

        setPort(Integer.parseInt(System.getenv("PORT")));
        staticFileLocation("/public");

        get(new Route("/") {
            @Override
            public Object handle(final Request request, final Response response) {
                Writer stringWriter = new StringWriter();
                Map<String, Object> attributes = new HashMap<String, Object>();
                attributes.put("name", "Start Project");
                try {
                    Template template = configuration.getTemplate("/public/template/index.html");
                    template.process(attributes, stringWriter);
                } catch (TemplateException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                return stringWriter;
            }
        });

        get(new Route("/brazil") {
            @Override
            public Object handle(final Request request, final Response response) {
                Writer stringWriter = new StringWriter();
                Map<String, Object> attributes = new HashMap<String, Object>();
                attributes.put("name", "Start Project");
                try {
                    Template template = configuration.getTemplate("/public/template/brazil.html");
                    template.process(attributes, stringWriter);
                } catch (TemplateException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                return stringWriter;
            }
        });

    }
}