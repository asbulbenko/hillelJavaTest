import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class SafeAdditionUtilTests {
    private SafeAdditionUtil serviceUnderTest
            = new SafeAdditionUtil();

    @Test
    @Parameterized.Parameters
    public static Object[][] data() {
  	return new Object[][] { { 0, 0 }, { 1, 1 }, { 2, 1 }, { 3, 2 }, { 4, 3 }, { 5, 5 }, { 6, 8 } };
    }

    public void testNew(){

    }
}
