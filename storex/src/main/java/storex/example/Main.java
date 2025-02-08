package storex.example;

import storex.hashindex.HashIndexStorage;

/**
 * @author neutronest
 */
public class Main {
    public static void main(String[] args) {

        HashIndexStorage storage = new HashIndexStorage("./logdata.bin");
        storage.set("cat", "1");
        storage.set("dog", "2");
        String r1 = storage.get("cat");
        System.out.println(r1);
    }
}