import java.util.ArrayList;
import java.util.List;

public class FocusPointsFetcher {

    public List<Point> fetchPoints() {


        List<Point> pointList = new ArrayList<>();

        pointList.add(new Point(1.0,2.0));
        pointList.add(new Point(4.0,1.0));
        pointList.add(new Point(3.0,5.0));

        return pointList;
    }
}
