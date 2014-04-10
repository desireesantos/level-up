import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PointTest {

    public static final Double LONGITUDE = 0.0;
    public static final Double LATITUDE = 1.0;

    @Test
    public void itIsConstructedWithTwoDoubles() throws Exception {
        Point point = new Point(LATITUDE, LONGITUDE);
        assertEquals(LONGITUDE, point.getLongitude());
        assertEquals(LATITUDE, point.getLatitude());
    }
}
