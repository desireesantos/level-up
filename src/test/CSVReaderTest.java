import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static junit.framework.TestCase.assertNotNull;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.powermock.api.mockito.PowerMockito.mockStatic;

@RunWith(PowerMockRunner.class)
@PrepareForTest(Files.class)
public class CSVReaderTest {

    @Test(expected = CSVFileDoesNotExist.class)
    public void verifiesFileExistence() throws Exception {
//        mockStatic(Files.class);
        PowerMockito.spy(Files.class);
        CSVReader csvReader = new CSVReader();
//        Path path = Paths.get("src/main/resources/public/csv/lat_long_address.csv");

//        PowerMockito.when(Files.readAllLines((Path) any(), eq(StandardCharsets.UTF_8))).thenThrow(new IOException());
        Mockito.when(Files.readAllLines((Path) any(), eq(StandardCharsets.UTF_8))).thenThrow(new IOException());

        csvReader.readFileContent();
    }

    @Test
    public void verifiesFileHasContent() throws Exception {
        List<String> content;
        CSVReader csvReader = new CSVReader();
        content = csvReader.readFileContent();

        assertEquals(0, content.size());
    }

    @Test
    @Ignore
    public void returnsFileContent() throws Exception {
        CSVReader csvReader = new CSVReader();
        Path path = Paths.get("../csv") ;
        mockStatic(Files.class);

        List<String> fakeContent = new ArrayList<String>();
        fakeContent.add("fake content first line");
        PowerMockito.when(Files.readAllLines(path, StandardCharsets.UTF_8)).thenReturn(fakeContent);

        List<String> content =  csvReader.readFileContent();

        assertNotNull(content);
        assertEquals(1, content.size());
        assertEquals("fake content first line", content.get(0));
    }

    @Test
    public void extractsLatitudeAndLongitude() throws Exception {


    }


}
