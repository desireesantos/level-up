import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class FocusPointsFetcherTest {

    private FocusPointsFetcher fetcher;
    private List<Point> points;

    public static final Double LONGITUDE = 1.0D;
    public static final Double LATITUDE = 2.0D;
    public static final Double LATITUDE_1 = 1.0D;
    public static final Double LONGITUDE_1 = 4.0D;
    public static final Double LATITUDE_2 = 5.0D;
    public static final Double LONGITUDE_2 = 3.0D;

    @Before
    public void setUp() throws Exception {
        fetcher = new FocusPointsFetcher();
        points = fetcher.fetchPoints();
    }

    @Test
    public void fetches3Points() throws Exception {
        assertEquals(3, points.size());
    }


    @Test
    public void fetchesPointsWithLatitudeAndLongitude() throws Exception {
        assertEquals(LATITUDE, points.get(0).getLatitude());
        assertEquals(LONGITUDE, points.get(0).getLongitude());
        assertEquals(LATITUDE_1, points.get(1).getLatitude());
        assertEquals(LONGITUDE_1, points.get(1).getLongitude());
        assertEquals(LATITUDE_2, points.get(2).getLatitude());
        assertEquals(LONGITUDE_2, points.get(2).getLongitude());
    }
}
