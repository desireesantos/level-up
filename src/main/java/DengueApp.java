import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
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
import java.util.List;
import java.util.Map;

import static spark.Spark.*;

public class DengueApp {

    public static void main(String[] args) {

        final Configuration configuration = new Configuration();
        configuration.setClassForTemplateLoading(DengueApp.class, "/");

        String port = System.getenv("PORT");

        if(port == null){
          port = "8082";
        }
        setPort(Integer.parseInt(port));
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

        get (new Route("/coordinates") {
            @Override
            public Object handle(final Request request, final Response response) {
                Gson gson = new Gson();
                FocusPointsFetcher focusPointsFetcher = new FocusPointsFetcher();
                List<Point> points = focusPointsFetcher.fetchPoints();
                return gson.toJson(points);
            }
        });

    }
}