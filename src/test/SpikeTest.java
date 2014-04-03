import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: fmartins
 * Date: 03/04/14
 * Time: 19:08
 * To change this template use File | Settings | File Templates.
 */
@PrepareForTest(Spike.class)
@RunWith(PowerMockRunner.class)
public class SpikeTest {

    @Test
    public void test() {
        PowerMockito.mockStatic(Spike.class);
        Mockito.when(Spike.foo()).thenReturn("oi");

        assertEquals("oi", Spike.foo());
    }

    @Test(expected = MyException.class)
    public void testException() throws Exception {
        PowerMockito.mockStatic(Spike.class);
        Mockito.when(Spike.bar()).thenThrow(MyException.class);

        Spike.bar();

    }
}
