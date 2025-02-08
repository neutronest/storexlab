package storex.memtable;

import java.util.List;
import storex.exceptions.NotImplementedException;
import storex.hashindex.IKey;
import storex.hashindex.IValue;

public class MemTable implements IMemtable {
    /**
     *
     */
    @Override
    public void init() {
        throw new NotImplementedException();
    }

    /**
     * @param key An absract Key type
     * @return
     */
    @Override
    public IValue get(IKey key) {
        throw new NotImplementedException();
    }

    /**
     * @param keyFrom
     * @param keyTo
     * @return
     */
    @Override
    public List<IValue> getRange(IKey keyFrom, IKey keyTo) {
        throw new NotImplementedException();
    }

    /**
     * @param key
     * @param value
     * @return
     */
    @Override
    public boolean insert(IKey key, IValue value) {
        throw new NotImplementedException();
    }

    /**
     * @param key
     * @return
     */
    @Override
    public boolean delete(IKey key) {
        throw new NotImplementedException();
    }
}
