package HomeTask2;

import java.util.Comparator;

public class Entry implements Comparator<String> {
    String value;
    String key;
    Entry left;
    Entry right;

    @Override
    public String toString() {
        return "{" +
                "value='" + value + '\'' +
                ", key='" + key + '\'' +
                ", left=" + left +
                ", right=" + right +
                '}';
    }

    @Override
    public int compare(String o1, String o2) {
        if (o1.equals(o2)) {
            return 0;
        } else if (o1 == null) {
            return -1;
        } else if (o2 == null) {
            return 1;
        }
        return o1.compareTo(o2);
    }
}