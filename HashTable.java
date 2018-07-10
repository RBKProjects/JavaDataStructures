import java.util.LinkedList;

public class HashTable {
    public static final int ARR_SIZE = 8;
    public LinkedList<Bucket>[] arr = new LinkedList[ARR_SIZE];
    //hash function
    public int getIndexBelowMaxForKey(String str, int max) {

        int hash = 0;
        for (int i = 0; i < str.length(); i++) {
            hash = (hash << 5) + hash + str.charAt(i);
            hash = hash & hash; // Convert to 32bit integer
            hash = Math.abs(hash);
        }
        return hash % max;
    }

    public static class Bucket {
        public String key;
        public String value;
    }

    public void insert (String key, String value) {
        int index = getIndexBelowMaxForKey(key, ARR_SIZE);
        LinkedList<Bucket> items = arr[index];

        if(items == null) {
            items = new LinkedList<Bucket>();

            Bucket item = new Bucket();
            item.key = key;
            item.value = value;

            items.add(item);

            arr[index] = items;
        }
        else {
            for(Bucket item : items) {
                if(item.key.equals(key)) {
                    item.value = value;
                    return;
                }
            }

            Bucket item = new Bucket();
            item.key = key;
            item.value = value;

            items.add(item);
        }
    }
    private String retrieve(String key) {
        if(key == null)
            return null;

        int index = getIndexBelowMaxForKey(key, ARR_SIZE);
        LinkedList<Bucket> items = arr[index];

        if(items == null)
            return null;

        for(Bucket item : items) {
            if(item.key.equals(key))
                return item.value;
        }

        return null;
    }

    public void remove (String key) {
        int index = getIndexBelowMaxForKey(key, ARR_SIZE);
        LinkedList<Bucket> items = arr[index];

        if(items == null)
            return;

        for(Bucket item : items) {
            if (item.key.equals(key)) {
                items.remove(item);
                return;
            }
        }
    }


    public static void main(String[] args) {
        HashTable hashTable = new HashTable();
        // Put some key values.

        hashTable.insert("cat","1");
        hashTable.insert("cat","2");
        hashTable.insert("dog","3");
        hashTable.remove("cat");
        System.out.println(hashTable.retrieve("dog"));

    }

}