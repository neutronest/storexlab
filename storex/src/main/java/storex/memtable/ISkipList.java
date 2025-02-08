package storex.memtable;

import java.util.List;

public interface ISkipList {

    void put(String key, String value);

    String get(String key);

    void delete(String key);

    boolean containsKey(String key);

    int size();
}
