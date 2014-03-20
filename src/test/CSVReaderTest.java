import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static junit.framework.TestCase.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.powermock.api.mockito.PowerMockito.*;

@RunWith(PowerMockRunner.class)
@PrepareForTest(Files.class)
public class CSVReaderTest {

    @Test
    public void verifyFileExistence() throws Exception {
        

    }

    @Test
    public void verifyFileShouldHaveContent() throws Exception {

    }

    @Test
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
