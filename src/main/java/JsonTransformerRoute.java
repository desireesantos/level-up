import com.google.gson.Gson;
import com.google.gson.JsonElement;
import spark.ResponseTransformerRoute;

public abstract class JsonTransformerRoute extends ResponseTransformerRoute {

    private Gson gson = new Gson();

    protected JsonTransformerRoute(String path) {
        super(path, "application/json");
    }

    @Override
    public String render(Object model) {
        JsonElement element = gson.fromJson((String) model,JsonElement.class);

        return element.getAsString();
    }

}
 