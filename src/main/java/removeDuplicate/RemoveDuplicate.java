package removeDuplicate;

import java.util.ArrayList;
import java.util.Collection;

public class RemoveDuplicate {

    public Collection<Object> removeDuplicateInCollection(Collection collection) {
        Collection<Object> newCollection = new ArrayList<>();

        for (Object element: collection) {
            if(!newCollection.contains(element)){
                newCollection.add(element);
            }
        }
        return newCollection;
    }
}
