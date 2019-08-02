package HomeTask2;

import java.util.ArrayList;
import java.util.List;

public class MyTreeMap implements MyMap {
    private Entry root;
    private int size = 0;

    @Override
    public void clear() {
        root = null;
        size = 0;
    }

    @Override
    public boolean add(String key, String value) {
        Entry entry = new Entry();
        entry.key = key;
        entry.value = value;
        if(root == null){
            root = entry;
            size++;
        } else {
            addToTree(root,entry);
        }
        return false;
    }

    private void addToTree(Entry root, Entry entry) {
        if (entry.key.compareTo(root.key) < 0) {
            if (root.left == null) {
                root.left = entry;
                size++;
            } else {
                addToTree(root.left, entry);
            }
        } else if (entry.key.compareTo(root.key) > 0) {
            if (root.right == null) {
                root.right = entry;
                size++;
            } else {
                addToTree(root.right, entry);
            }
        } else {
            addToTree(root.right, entry);
        }
    }

    @Override
    public boolean containsKey(String key) {
        return createList().contains(key);
    }

    @Override
    public String get(String key) {
        if(root == null){
            return  null;
        } else {
            return getByKey(root,key).value;
        }
    }

    private Entry getByKey(Entry entry, String key) {
        if (entry.key.compareTo(key) == 0) {
            return entry;
        } else if (entry.key.compareTo(key) < 0) {
            if (entry.right == null) {
                return null;
            } else {
               return getByKey(entry.right, key);
            }
        } else {
            if (entry.left == null) {
                return null;
            } else {
                return getByKey(entry.left, key);
            }
        }
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String remove(String key) {
        //TODO
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Entry[] toArray() {
        Entry[] entries = new Entry[size];
        addToArray(root,entries);
        return entries;
    }

    private void addToArray(Entry root, Entry[] entries) {
        for (int i = 0; i < size; i++) {
            if (root == null) {
                return;
            }
            addToArray(root.left, entries);
            entries[i] = root;
            addToArray(root.right, entries);

        }
    }

    private List<String> createList() {
        List<String> list = new ArrayList<>();
        addKeyToList(root, list);
        return list;
    }

    private void addKeyToList(Entry root, List<String> list) {
        if (root == null) {
            return;
        }
        addKeyToList(root.left, list);
        list.add(root.key);
        addKeyToList(root.right, list);
    }

    @Override
    public String toString() {
        return "MyTreeMap{" +
                "root=" + root +
                '}';
    }
}
