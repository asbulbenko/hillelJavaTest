import org.junit.Test;

import static org.junit.Assert.*;

public class CollectionTests {

    @Test
    public void testCreatedCollectionSize() {
        Collection collection = new Collection();
        assertEquals("Collection size should be 0 after creation", 0, collection.size());
    }

    @Test
    public void testAbleAddToCollection() {
        Collection collection = new Collection();
        assertTrue("Adding to collection should be true", collection.add("Amazon"));
        assertEquals("Size should be 1 after adding one element to collection",1, collection.size());
    }

    @Test
    public void testContentInCollection() {
        Collection collection = new Collection();
        collection.add("eBay");
        assertTrue(collection.contains("eBay"));
        assertNotEquals("ebay", collection.get(0));
        assertNotEquals("EBAY", collection.get(0));
        assertEquals("Elements in collection are case sensitive", "eBay", collection.get(0));

        collection.add(String.valueOf(23));
        assertNotEquals(23, collection.get(1));
        assertEquals("23", collection.get(1));
    }

    @Test
    public void testAppendAllElementsToCollection() {
        // Adding 6 elements to collection
        String [] merchantArray = {"Amazon", "eBay", "Target", "Walmart", "BestBuy", "Costco"};
        Collection collection = new Collection();
        assertTrue("Able to add array to collection", collection.addAll(merchantArray));
        assertEquals("Collection should contain all 6 elements from array", 6, collection.size());
    }

    @Test
    public void testAppendAllElementsToEndOfCollection() {
        Collection collection = new Collection();
        collection.add("Amazon");
        collection.add("eBay");
        collection.add("Bolt");
        String [] merchantArray = {"BestBuy", "Costco", "DrugStore", "BBB"};

        // array should be added to collection starting from index 2
        collection.addAll(merchantArray);

        assertEquals("BestBuy", collection.get(3));
        assertEquals("DrugStore", collection.get(5));
        assertEquals(7, collection.size());
    }

    @Test
    public void testCompareCollection() {
        Collection collection = new Collection();
        Collection collection1 = new Collection();
        String [] merchantArray = {"BestBuy", "Costco", "DrugStore"};
        collection.addAll(merchantArray);
        collection1.addAll(merchantArray);

        assertTrue("Collections compared by elements", collection.compare(collection1));
        assertNotSame("Collections referring to diff memory cell", collection, collection1);
    }

    @Test
    public void testCollectionGotEmpty() {
        Collection collection = new Collection();
        collection.add("Ikea");
        assertEquals(1, collection.size());
        collection.clear();
        assertEquals(0, collection.size());
    }

    @Test
    public void testDeleteIndexFromCollection() {
        Collection collection = new Collection();
        collection.add("Ikea");
        assertEquals(1, collection.size());
        assertFalse("Unable to delete out of scope", collection.delete(6));
        assertTrue("Able to delete element from collection by index", collection.delete(0));
        assertEquals(0, collection.size());
    }

    @Test
    public void testDeleteByElementFromCollection() {
        String [] merchantArray = {"Amazon", "eBay", "Target", "Walmart", "BestBuy", "Costco"};
        Collection collection = new Collection();
        collection.addAll(merchantArray);
        assertEquals(6, collection.size());
        assertTrue("Element 'Target' exists in collection", collection.contains("Target"));
        assertTrue("Element 'Target' successfully deleted from collection", collection.delete("Target"));
        assertFalse(collection.contains("Target"));
        assertEquals(5, collection.size());
    }

    @Test
    public void testCollectionTrimmed() {
        Collection collection = new Collection();
        String [] merchantArray = {"Amazon", "eBay", "Target", "Walmart", "BestBuy", "Costco"};
        collection.addAll(merchantArray);
        assertFalse("Nothing in collection to trim", collection.trim());
        collection.add("BBB");
        assertTrue("Interesting", collection.trim());
    }

}
