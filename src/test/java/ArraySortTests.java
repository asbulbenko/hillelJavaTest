import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class ArraySortTests {
    @Test
    public void testArrayIsNotEmpty(){
        int[] array = createRandomArray();
        assertTrue("Array should be populated", array.length>0);
    }

    @Test
    public void testArraySortByInsert() {
        int[] array = createRandomArray();
        print(array); // Print array that should be sorted

        int temp, j;
        for (int i = 0; i < array.length; i++) {
                temp = array[i]; // take/save value of element
                // check elements in the left side of array
                for (j=i-1; j >= 0; j--) {
                    if(temp < array[j]) { // shift elements to the right
                        array[j + 1] = array[j];
                    } else
                        break;
                }
                // insert value from temp into 'empty' cell
                array[j+1] = temp;
        }
        System.out.println();
        System.out.println(" After sort ");
        print(array); // Print array after sort
    }

    private static int[] createRandomArray(){
        int[] arr = new int[(int)(Math.random() * 100)];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 20);
        }
        return arr;
    }

    private void print(int[] array) {
        for (int s: array) {
            System.out.print(s + " ");
        }
    }

}
