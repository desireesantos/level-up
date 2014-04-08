import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CSVReader {

    public ArrayList<Point> readLatitudeLongitudeFromFile(String path) throws IOException {
        List<String> lines = readFile(path);


        return new ArrayList<Point>();
    }

    protected List<String> readFile(String path) throws IOException {
        return Files.readAllLines(Paths.get("src/main/resources/public/csv/lat_long_address.csv"), StandardCharsets.UTF_8);
    }
}
