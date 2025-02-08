package storex.example;

import storex.hashindex.IKey;

/**
 * @author neutr
 */
public class MemoryKey implements IKey {

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String name;
}
