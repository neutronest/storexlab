package storex.memtable;

import storex.exceptions.NotImplementedException;

import java.util.concurrent.ConcurrentSkipListMap;

public class NaiveSkipList implements ISkipList {

    private final ConcurrentSkipListMap<String, String> skipListMap = new ConcurrentSkipListMap<>();
    /**
     * @param key
     * @param value
     */
    @Override
    public void put(String key, String value) {
        skipListMap.put(key, value);
    }

    /**
     * @param key
     * @return
     */
    @Override
    public String get(String key) {
        return skipListMap.get(key);
    }

    /**
     * @param key
     */
    @Override
    public void delete(String key) {
        skipListMap.remove(key);
    }

    /**
     * @param key
     * @return
     */
    @Override
    public boolean containsKey(String key) {
        return skipListMap.containsKey(key);
    }

    /**
     * @return
     */
    @Override
    public int size() {
        return skipListMap.size();
    }
}
