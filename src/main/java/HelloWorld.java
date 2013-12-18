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

import static spark.Spark.get;
import static spark.Spark.setPort;
import static spark.Spark.staticFileLocation;

public class HelloWorld {

    public static void main(String[] args) {

        final Configuration configuration = new Configuration();
        configuration.setClassForTemplateLoading(HelloWorld.class, "/");

        setPort(8000);
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