import java.util.ArrayList;
import java.util.List;

public class MyStreamHwExample {

    public List<Integer> addingRandomNumbers(){
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            list.add((int) (Math.random()*i*10));
        }
        return list;
    }
}
