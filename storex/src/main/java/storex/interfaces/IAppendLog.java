package storex.interfaces;

import storex.hashindex.IKey;
import storex.hashindex.IValue;

public interface IAppendLog {
    public void Append(IKey key, IValue value);
}
