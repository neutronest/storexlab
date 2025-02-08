package storex;

import storex.memtable.IMemtable;

public class StorexDB {

    public IMemtable mutableMemtable;

    public IMemtable immutableMemtable;

    public StorexDB() {
        mutableMemtable.init();
        immutableMemtable.init();

    }

    public void start() {

    }

    public void stop() {

    }

    public IMemtable getMutableMemtable() {
        return mutableMemtable;
    }

    public void setMutableMemtable(IMemtable mutableMemtable) {
        this.mutableMemtable = mutableMemtable;
    }

    public IMemtable getImmutableMemtable() {
        return immutableMemtable;
    }

    public void setImmutableMemtable(IMemtable immutableMemtable) {
        this.immutableMemtable = immutableMemtable;
    }

}
