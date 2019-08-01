package HomeTask2;

import java.util.ArrayList;
import java.util.List;

public class MyTreeMap implements MyMap {
    private Entry root;
    private int size = 0;

    @Override
    public void clear() {

    }

    @Override
    public boolean add(int value) {
        Entry entry = new Entry();
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
        if (entry.value < root.value) {
            if (root.left == null) {
                root.left = entry;
                size++;
            } else {
                addToTree(root.left, entry);
            }
        } else if (entry.value > root.value) {
            if (root.right == null) {
                root.right = entry;
            } else {
                addToTree(root.right, entry);
            }
        } else {
            addToTree(root.right, entry);
        }
    }

    @Override
    public boolean containsKey(String key) {
        return false;
    }

    @Override
    public String get(String key) {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public String remove(String key) {
        return null;
    }

    @Override
    public String put(String key, String value) {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public Entry[] toArray() {
        return new Entry[0];
    }

    private List<Integer> createList() {
        List<Integer> list = new ArrayList<>();
        addToList(root, list);
        return list;
    }

    private void addToList(Entry root, List<Integer> list) {
        if (root == null) {
            return;
        }
        addToList(root.left, list);
        list.add(root.value);
        addToList(root.right, list);
    }

    @Override
    public String toString() {
        return "MyTreeMap{" +
                "root=" + root +
                '}';
    }
}
