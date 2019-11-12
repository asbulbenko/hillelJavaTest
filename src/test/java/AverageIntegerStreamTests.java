import org.junit.Test;

import java.util.List;

public class AverageIntegerStreamTests {
    private List<Integer> list;

    @Test
    public void shouldReturnAverageFromIntegerCollection() {
        list = new AverageIntegerStream().addingRandomNumbers();
        System.out.println(list);
        list.stream()
                .mapToInt(i -> i)
                .average()
                .ifPresent(avg -> System.out.println("Average found is " + avg));
    }
}
