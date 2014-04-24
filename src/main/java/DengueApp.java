import com.google.gson.Gson;
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

import static spark.Spark.get;
import static spark.Spark.setPort;
import static spark.Spark.staticFileLocation;

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
                CSVReader csvReader = new CSVReader();
                List<Point> points = null;
                try {
                    points = csvReader.readLatitudeLongitudeFromFile("src/main/resources/public/csv/long_lat_cep.csv");
                } catch (IOException e) {
                    e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                }
                return gson.toJson(points);
            }
        });

    }
}