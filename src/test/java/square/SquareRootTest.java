package square;

import org.junit.Test;
import static org.junit.Assert.*;

public class SquareRootTest {
    SquareRoot sr = new SquareRoot();

    @Test
    public void discriminatorIsLessThanZero() {
        assertFalse("There should not be any roots", sr.findRoots(10,0, 5));
    }

    @Test
    public void divideByZeroError() {
        try {
            sr.findRoots(0,0,-8);
        } catch (ArithmeticException e) {
            System.err.println(" Divide by zero error, coefficient A cannot be zero");
        }
    }

    @Test
    public void discriminatorIsEqualZero() {
        assertTrue("One root x with value -2 found", sr.findRoots(1, 4, 4));
    }

    @Test
    public void discriminatorGreaterThanZero () {
        assertTrue(sr.findRoots(5, 10, 3));
    }

}
