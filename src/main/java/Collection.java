public class Collection implements CustomCollection {
    // counter of not null elements in collection
    int count = 0;
    private String[] arr = {};

    public Collection() {
    }

    // add string to array
    // in case there is not enough space increase capacity of array
    @Override
    public boolean add(String str) {
        if (count < arr.length - 1) {
            arr[count] = str;
            count++;
            return true;
        } else {
//            System.out.println("Not enough space in array");
            arr = returnIncreasedArray(arr);
            arr[count] = str;
            count++;
            return true;
        }
    }

    @Override
    public boolean addAll(String[] strArr) {
        // create new array that can contain both old and new collections
        String[] sumArray = new String[arr.length + strArr.length];
        // copy old array first
        if (arr.length > 0) {
            for (int i = 0; i < arr.length; i++) {
                sumArray[i] = arr[i];
            }
            // count number of added elements in collection
            count = indexOfLastElementInArray(sumArray);
        }
        // copy array that came in parameter
        int index = indexOfLastElementInArray(sumArray);
        for (int i = 0; i < strArr.length; i++) {
            sumArray[index + i] = strArr[i];
        }
        count = indexOfLastElementInArray(sumArray);
        arr = sumArray;
        return true;
    }

    @Override
    public boolean addAll(CustomCollection strColl) {
        this.addAll(strColl.getArray());
        return true;
    }

    @Override
    public boolean delete(int index) {
        if (index > arr.length) {
//            System.out.println("Delete index is out of bounce. Please use index less than " + arr.length);
            return false;
        } else {
//            System.out.println("Index " + index + " was deleted from collection");
            setToEmptyStringAndShiftValues(index);
            return true;
        }
    }

    @Override
    public boolean delete(String str) {
        if (contains(str)) {
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] == str) {
                    // iterate from deleted element and copy all elements from right to left (shift)
                    setToEmptyStringAndShiftValues(i);
                }
            }

            return true;
        } else {
            System.out.println("There is no such element in collection");
            return false;
        }
    }

    @Override
    public String get(int index) {
        if (index > arr.length) {
            System.out.println("Searched index is out of bounce. Please use index less than " + arr.length);
            return null;
        } else {
            return arr[index];
        }
    }

    @Override
    public boolean contains(String str) {
        if (str == null) {
            return false;
        }
        for (String element : arr)
            if (element == str)
                return true;

        return false;
    }

    @Override
    public boolean clear() {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = "";
        }
        System.out.println("Collection was set to empty values");
        return true;
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public boolean trim() {
        // method will delete all empty elements from collection
        if (count < arr.length) {
            arr = returnTrimmedArray(arr);
            return true;
        } else {
            System.out.println("Nothing to trim.");
            return false;
        }
    }

    private String[] returnTrimmedArray(String[] arr) {
        String[] arrayNew = new String[count];
        for (int i = 0; i < count; i++) {
            arrayNew[i] = arr[i];
        }
        return arrayNew;
    }

    @Override
    public boolean compare(CustomCollection coll) {
        String[] array = this.getArray();
        String[] array1 = coll.getArray();
        if (array == null || array1 == null) {
            return false;
        }
        if (array.length != array1.length) {
            return false;
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i] != array1[i]) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String[] getArray() {
        return this.arr;
    }

    private int indexOfLastElementInArray(String[] arr) {
        int indexOfLastElement = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]==null) {
                indexOfLastElement = i;
                return indexOfLastElement;
            }
        }
        return arr.length;
    }

    private String[] returnIncreasedArray(String[] arr) {
        // increasing size of array to ~60%
        int round = Math.round(arr.length + (arr.length * 2 / 3));
        int sizeOfNewArray = round > 0 ? round : 2;
//        System.out.println("New array was created!");
        String[] arrayNew = new String[sizeOfNewArray];
        for (int i = 0; i < arr.length; i++) {
            arrayNew[i] = arr[i];
        }
        return arrayNew;
    }

    private void setToEmptyStringAndShiftValues(int index) {
        // when we delete element we set it to null and decrease count of non-empty elements
        count--;
        // iterate from deleted element and copy all elements from right to left (shift)
        for (int i = index; i < arr.length - 1; i++) {
            arr[i] = arr[i + 1];
        }
    }
}

