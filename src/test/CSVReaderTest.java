import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class CSVReaderTest {

    public static final String PATH_TO_FILE = "pathToFile";

    private CSVReader csvReader;

    @Before
    public void setUp() throws Exception {
        csvReader = spy(new CSVReader());
    }

    @Test(expected = IOException.class)
    public void doNotHandleIOException() throws Exception {

        doThrow(IOException.class).when(csvReader).readFile(PATH_TO_FILE);

        csvReader.readLatitudeLongitudeFromFile(PATH_TO_FILE);
    }

    @Test
    public void parsesLatitudeAndLongitudeFromAFileWithTwoLines() throws IOException {

        List<String> lines = new ArrayList<String>();
        lines.add("-69.19239,-10.70599,69932000,Brazil");
        lines.add("-67.80184,-9.97570,69900970,Brazil");

        doReturn(lines).when(csvReader).readFile(PATH_TO_FILE);

        List<Point> points = csvReader.readLatitudeLongitudeFromFile(PATH_TO_FILE);

        assertEquals(-69.19239, points.get(0).getLongitude());
        assertEquals(-10.70599, points.get(0).getLatitude());
        assertEquals(-67.80184, points.get(1).getLongitude());
        assertEquals(-9.97570, points.get(1).getLatitude());
    }

}
