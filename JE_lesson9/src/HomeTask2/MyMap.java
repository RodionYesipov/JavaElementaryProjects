package HomeTask2;

public interface MyMap {

    void clear();

    boolean add(String key, String value); // Returns true if this set did not already contain the specified element

    boolean containsKey(String key);

    String get(String key);

    boolean isEmpty();

    String remove(String key); // Returns the value to which this map previously associated the key, or null

    int size();

    Entry[] toArray();
}
