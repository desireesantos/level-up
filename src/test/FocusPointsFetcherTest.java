import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class FocusPointsFetcherTest {

    @Test
    public void fetchesPointsFromJson() throws Exception {

        FocusPointsFetcher fetcher = new FocusPointsFetcher();
        String points = fetcher.fetchPoints();
        String json = "[\n" +
                "  {\n" +
                "    latitude: -30.028938,\n" +
                "    longitude: -51.210841\n" +
                "  },\n" +
                "  {\n" +
                "    latitude: -30.026745,\n" +
                "    longitude: -51.200165\n" +
                "  },\n" +
                "  {\n" +
                "    latitude: -12.0716333,\n" +
                "    longitude: -77.0566000\n" +
                "  },\n" +
                "  {\n" +
                "    latitude: -30.027489,\n" +
                "    longitude: -51.205931\n" +
                "  },\n" +
                "  {\n" +
                "    latitude: -30.048591,\n" +
                "    longitude: -51.189108\n" +
                "  },\n" +
                "  {\n" +
                "    latitude: -12.0716313,\n" +
                "    longitude: -77.0566500\n" +
                "  },\n" +
                "  {\n" +
                "    latitude: -12.0716323,\n" +
                "    longitude: -77.0566010\n" +
                "  },\n" +
                "  {\n" +
                "    latitude: -12.0716330,\n" +
                "    longitude: -77.0566020\n" +
                "  }\n" +
                "]\n" +
                "\n" ;

        assertEquals(json, points);
    }
}
