package storex.memtable;

import storex.hashindex.IKey;
import storex.hashindex.IValue;

import java.util.List;

/**
 * @author neutronest
 */
public interface IMemtable {

    /**
     * initialize memtable service
     */
    public void init();

    /**
     * get value by key
     *
     * @param key An absract Key type
     * @return IValue
     */
    public IValue get(IKey key);

    /**
     * get values by key range
     *
     * @param keyFrom
     * @param keyTo
     * @return
     */
    public List<IValue> getRange(IKey keyFrom, IKey keyTo);

    /**
     *
     * @param key
     * @param value
     * @return
     */
    public boolean insert(IKey key, IValue value);

    /**
     *
     * @param key
     * @return
     */
    public boolean delete(IKey key);
}
