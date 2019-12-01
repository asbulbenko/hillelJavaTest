package iterator;

public class Main {
    public static void main(String[] args) {
        String[] arrayS = new String[]{"lion","tiger","puma","cat"};
        Integer[] numberI = new Integer[]{1, 2, 3, 4, 5};
        ArrayIterator myList = new ArrayIterator(arrayS);
        ArrayIterator numberList = new ArrayIterator(numberI);

        for(Object s : myList){
            System.out.println(s);
        }

        System.out.println("======");

        for(Object n : numberList){
            System.out.println(n);
        }
    }
}
