import java.util.ArrayList;
import java.util.List;

public class FocusPointsFetcher {

    public List<Point> fetchPoints() {


        List<Point> pointList = new ArrayList<>();

        pointList.add(new Point(2.0, 1.0));
        pointList.add(new Point(1.0, 4.0));
        pointList.add(new Point(5.0, 3.0));

        return pointList;
    }
}
