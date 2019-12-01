package removeDuplicate;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

public class removeDuplicateTest {
    Collection<Object> checkS = new ArrayList<>(Arrays.asList("lion","tiger","puma","cat"));
    Collection<Object> checkI = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
    RemoveDuplicate rd = new RemoveDuplicate();

    @Test
    public void checkMethod() {
        ArrayList<String> stringArrayList = new ArrayList<>(Arrays.asList("lion","tiger","puma","cat", "lion", "cat"));
        System.out.println("Before " + stringArrayList);
        Collection<Object> newStringArrayList = rd.removeDuplicateInCollection(stringArrayList);
        System.out.println("After " + newStringArrayList);
        assertEquals(checkS, newStringArrayList);
    }

    @Test
    public void checkMethod2() {
        ArrayList<Integer> numberArrayList = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,4,4,1,2));
        System.out.println("Before " + numberArrayList);
        Collection<Object> newNumberList = rd.removeDuplicateInCollection(numberArrayList);
        System.out.println("After " + newNumberList);
        assertEquals(checkI, newNumberList);
    }

}
