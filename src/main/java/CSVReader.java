import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CSVReader {

    public List<Point> readLatitudeLongitudeFromFile(String path) throws IOException {
        List<String> lines = readFile(path);
        List<Point> points = new ArrayList<Point>();

        for (String line : lines) {
            Point point = extractPoint(line);
            points.add(point);
        }

        return points;
    }

    private Point extractPoint(String line) {
        String location[] = line.split(",");
        Double latitude = Double.parseDouble(location[0]);
        Double longitude = Double.parseDouble(location[1]);
        return new Point(latitude, longitude);
    }

    protected List<String> readFile(String path) throws IOException {
        return Files.readAllLines(Paths.get("src/main/resources/public/csv/lat_long_address.csv"), StandardCharsets.UTF_8);
    }
}
