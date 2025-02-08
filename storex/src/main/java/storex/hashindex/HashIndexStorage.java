package storex.hashindex;

import org.codehaus.plexus.util.StringUtils;
import storex.common.StatusCode;

import java.nio.charset.StandardCharsets;

/**
 * @author neutr
 */
public class HashIndexStorage {

    private static volatile HashIndexStorage instance;
    private MemTableService memTableService;
    private String LogFilePath;
    private AppendLogManager appendLogManager;


    public static HashIndexStorage getInstance(String logFilePath) {
        HashIndexStorage result = instance;
        if (result != null) {
            return instance;
        }

        synchronized (HashIndexStorage.class) {
            if (instance == null) {
                instance = new HashIndexStorage(logFilePath);
            }
            return instance;
        }
    }

    public HashIndexStorage(String logFilePath) {
        memTableService = MemTableService.getInstance();

        this.LogFilePath = logFilePath;
        appendLogManager = AppendLogManager.getInstance(this.LogFilePath);
    }

    public String get(String key) {
        AppendLogOffsetInfo logOffsetInfo = memTableService.getIndex(key);
        byte[] data = appendLogManager.seekBytes(logOffsetInfo);
        return new String(data, StandardCharsets.UTF_8);
    }

    public StatusCode set(String key, String value) {
        try {
            AppendLogOffsetInfo logOffsetInfo = this.appendLogManager.AppendData(key, value);
            this.memTableService.setIndex(key, logOffsetInfo);
            return StatusCode.OK;
        } catch(Exception ex) {
            return StatusCode.Error;
        }
    }
}
