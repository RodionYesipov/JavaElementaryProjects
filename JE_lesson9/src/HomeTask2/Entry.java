package HomeTask2;

public class Entry<Integer extends Comparable<?>> {
    int value;
    Entry<Integer> left;
    Entry<Integer> right;

    @Override
    public String toString() {
        return "{" +
                "value=" + value +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}