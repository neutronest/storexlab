package storex.memtable;

import storex.exceptions.NotImplementedException;

public class NaiveSkipList implements ISkipList {

    // private final ConcurrentSkipListMap<String, String> map = new ConcurrentSkipListMap<>();
    /**
     * @param key
     * @param value
     */
    @Override
    public void put(String key, String value) {
        throw new NotImplementedException();
    }

    /**
     * @param key
     * @return
     */
    @Override
    public String get(String key) {
        throw new NotImplementedException();
    }

    /**
     * @param key
     */
    @Override
    public void delete(String key) {
        throw new NotImplementedException();
    }

    /**
     * @param key
     * @return
     */
    @Override
    public boolean containsKey(String key) {
        throw new NotImplementedException();
    }

    /**
     * @return
     */
    @Override
    public int size() {
        throw new NotImplementedException();
    }
}
