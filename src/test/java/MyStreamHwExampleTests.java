//import com.sun.tools.javac.util.Pair;
//import com.sun.tools.javac.util.Pair;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class MyStreamHwExampleTests {
    private List<Integer> list;
    private List<String> listString = Arrays.asList("Bulldog", "pug", "corgi", "Labrador", "AKITA", "samoyed", "dane", "chin");

    @Test
    public void shouldReturnAverageFromIntegerCollection() {
        list = new MyStreamHwExample().addingRandomNumbers();
        assertEquals("List of Integers should be size of 50", 50, list.size());
        System.out.println("Here is input list - " + list);
        list.stream()
                .mapToInt(i -> i)
                .average()
                .ifPresent(avg -> System.out.println("Average arithmetic mean number = " + avg));
    }

    @Test
    public void shouldReturnUpperCaseForPairStringCollection() {
        assertFalse("Input string should not be empty",  listString.isEmpty());
//        List<Pair> pairs = listString.stream()
//                .map(str -> str.toUpperCase())
//                .map(i -> new Pair(i, null))
//                .collect(Collectors.toList());
//        System.out.println(pairs);
    }


    @Test
    public void shouldFilterAllLowerCaseAndLessThanFourLength() {
        assertFalse("Input string should not be empty",  listString.isEmpty());
        System.out.println("Only those strings that equals 4");
        listString.stream()
                .filter(str -> str.contains(str.toLowerCase()))
                .filter(str -> str.length() == 4)
                .forEach(x -> System.out.print(x + " "));
    }
}
