import junit.framework.TestCase;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static junit.framework.TestCase.assertNotNull;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.spy;

@RunWith(MockitoJUnitRunner.class)
public class CSVReaderTest {

    public static final String PATH_TO_FILE = "pathToFile";

    @Test(expected = IOException.class)
    public void doNotHandleIOException() throws Exception {

        CSVReader csvReader = spy(new CSVReader());

        doThrow(IOException.class).when(csvReader).readFile(PATH_TO_FILE);

        csvReader.readLatitudeLongitudeFromFile(PATH_TO_FILE);
    }

   @Test
   @Ignore
   public void parsesLatitudeAndLongitudeFromCSVFile() throws IOException {

       CSVReader csvReader = spy(new CSVReader());

       List<String> lines = new ArrayList<String>();
       lines.add("-69.19239,-10.70599,69932000,Brazil");

       doReturn(lines).when(csvReader).readFile(PATH_TO_FILE);

       List<Point> points = csvReader.readLatitudeLongitudeFromFile(PATH_TO_FILE);

       assertEquals(-69.19239, points.get(0).getLatitude());
       assertEquals(-10.70599, points.get(0).getLongitude());
   }


}
