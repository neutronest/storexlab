package storex.hashindex;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.HashMap;

public class AppendLogManager {


    private static volatile  AppendLogManager instance;

    private String filePath;

    private static String kvDelimiter = ":";
    private static String dataDelimiter = "\n";


    public static AppendLogManager getInstance(String filePath) {
        AppendLogManager result = instance;
        if (result != null) {
            return instance;
        }

        synchronized (AppendLogManager.class) {
            if (instance == null) {
                instance = new AppendLogManager(filePath);
            }
            return instance;
        }
    }

    public AppendLogManager(String filePath)  {
        try {
            this.filePath = filePath;
            File yourFile = new File( this.filePath);
            yourFile.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public AppendLogOffsetInfo AppendData(String key, String value) {
        try {
            String record = String.format("%s%s%s%s", key, kvDelimiter, value, dataDelimiter);
            long startPosition = this.getFileByteLength();
            int offset = record.getBytes(StandardCharsets.UTF_8).length;
            Files.write(Paths.get(filePath), record.getBytes(), StandardOpenOption.APPEND);
            return new AppendLogOffsetInfo(startPosition, offset);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public long getFileByteLength() {
        try {
            return Files.size(Paths.get(filePath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public byte[] seekBytes(AppendLogOffsetInfo appendLogOffsetInfo) {
        try (RandomAccessFile f = new RandomAccessFile(filePath,"r")){
            byte[] buffer = new byte[appendLogOffsetInfo.getOffset()];
            f.seek(appendLogOffsetInfo.getStartPosition());
            f.readFully(buffer);
            return buffer;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
