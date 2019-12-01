package iterator;

import java.util.Iterator;

public class ArrayIterator implements Iterable {
    private Object[] arrayList;
    private int currentSize;

    public ArrayIterator(Object[] newArray) {
        this.arrayList = newArray;
        this.currentSize = arrayList.length;
    }

    @Override
    public Iterator<Object> iterator() {
        Iterator<Object> iterator = new Iterator<Object>() {

            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < currentSize && arrayList[currentIndex] != null;
            }

            @Override
            public Object next() {
                return arrayList[currentIndex++];
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
        return iterator;
    }
}
