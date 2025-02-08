package storex.memtable;

import org.junit.Test;
import storex.memtable.NaiveSkipList;
import static org.junit.Assert.*;

public class NaiveSkipListTest {

    @Test
    public void testPutAndGetSuccessfully() {
        NaiveSkipList skipList = new NaiveSkipList();
        skipList.put("key1", "value1");

        assertTrue(skipList.containsKey("key1"));
        assertEquals(skipList.get("key1"), "value1");
    }

    @Test
    public void testDeleteSuccessfully() {
        NaiveSkipList skipList = new NaiveSkipList();
        skipList.put("key1", "value1");
        skipList.put("key2", "value2");

        skipList.delete("key1");
        assertFalse(skipList.containsKey("key1"));
    }

    @Test
    public void testGetListSizeSucessfully()
    {
        NaiveSkipList skipList = new NaiveSkipList();
        skipList.put("key1", "value1");
        skipList.put("key2", "value2");
        skipList.put("key3", "value3");
        skipList.delete("key2");
        assertEquals(skipList.size(), 2);
    }
}
