package storex.hashindex;

import java.util.HashMap;

/**
 * @author neutronest
 */
public class MemTableService {

    private static volatile MemTableService instance;

    public HashMap<String, AppendLogOffsetInfo> memTable;

    public static MemTableService getInstance() {
        MemTableService result = instance;
        if (result != null) {
            return instance;
        }

        synchronized (MemTableService.class) {
            if (instance == null) {
                instance = new MemTableService();
            }
            return instance;
        }
    }

    public MemTableService()
    {
        memTable = new HashMap<String, AppendLogOffsetInfo>();
    }

    public AppendLogOffsetInfo getIndex(String key) {
        return memTable.get(key);
    }

    public AppendLogOffsetInfo setIndex(String key, AppendLogOffsetInfo appendLogOffsetInfo) {
        memTable.put(key, appendLogOffsetInfo);
        return appendLogOffsetInfo;
    }

}
