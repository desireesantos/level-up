import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CSVReader {
    public List<String> readFileContent() throws CSVFileDoesNotExist {
        try {
            Files.readAllLines(Paths.get("src/main/resources/public/csv/lat_long_address.csv"), StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new CSVFileDoesNotExist();
        }
        return new ArrayList<String>();
    }
}
