import java.util.Arrays;

public class IntLinkedList implements IntList, IntQueue, IntStack {

    private static class Entry {
        int value;
        Entry previous;
        Entry next;

        public Entry(int value) {
            this.value = value;
        }
    }

    private int size = 0;
    private Entry first = null;
    private Entry last = null;

    //check index if it's in array range
    private void indexRangeChecker(int indexCheck, int rangeCheck) {
        if (indexCheck >= rangeCheck && indexCheck > 0) {
            throw new IndexOutOfBoundsException("Your index = " + indexCheck + " is more than the array size = " + rangeCheck);
        } else if (indexCheck < 0) {
            throw new IndexOutOfBoundsException("Your index < 0");
        }
    }

    @Override
    public void add(int element) {
        Entry newEntry = new Entry(element);
        if (size == 0) {
            first = newEntry;
            last = newEntry;
        } else {
            last.next = newEntry;
            newEntry.previous = last;
            last = newEntry;
        }
        size++;
    }

    @Override
    public int remove() {
        int removedElement;
        if(size == 0) {
            throw new IndexOutOfBoundsException("Array is empty!");
        } else if(size == 1){
            removedElement = first.value;
            first = null;
            last = null;
            size--;
        } else {
            removedElement = first.value;
            first = first.next;
            first.previous = null;
            size--;
        }
        return removedElement;
    }

    @Override
    public int element() {
        return first.value;
    }

    @Override
    public boolean add(int index, int element) {
        Entry newEntry = new Entry(element);
        Entry tmp = first;

        indexRangeChecker(index,size);
        if (index == size) {
            add(element);
        } else if (index == 0) {
            newEntry.next = tmp;
            tmp.previous = newEntry;
            first = newEntry;
            size++;
        } else if (index < size) {
            for (int i = 0; i <= index; i++) {
                if (i == index) {
                    newEntry.next = tmp;
                    tmp = tmp.previous;
                    newEntry.previous = tmp;
                    tmp.next = newEntry;
                    tmp.next.previous = newEntry;
                    size++;
                }
                tmp = tmp.next;
            }
        }
        return false;
    }

    @Override
    public void clear() {
        first = null;
        last = null;
        size = 0;
    }

    @Override
    public int get(int index) {
        indexRangeChecker(index, size);
        Entry tmp = first;
        for (int i = 0; i < index; i++) {
            tmp = tmp.next;
        }
        return tmp.value;
    }

    @Override
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean remove(int index) {
        indexRangeChecker(index, size);
        Entry tmp = first;
        int removedElement;
        for (int i = 0; i <= index; i++) {
            if (index == 0) {
                remove();
            } else if (i == index) {
                if (index == size - 1) {
                    last = last.previous;
                    last.next = null;
                    size--;
                } else {
                    removedElement = tmp.value;
                    tmp.previous.next = tmp.next;
                    tmp.next.previous = tmp.previous;
                    size--;
                }
            }
            tmp = tmp.next;
        }
        return true;
    }

    @Override
    public boolean removeByValue(int value) {
        Entry tmp = first;
        for (int i = 0; i <= size; i++) {
            if (tmp.value == value) {
                remove(i);
                break;
            } else if (i < size) {
                tmp = tmp.next;
            }
        }
        return false;
    }

    @Override
    public boolean set(int index, int element) {
        indexRangeChecker(index, element);
        Entry tmp = first;
        for (int i = 0; i < index; i++) {
            tmp = tmp.next;
        }
        tmp.value = element;
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public IntList subList(int fromIndex, int toIndex) {
        indexRangeChecker(fromIndex,size);
        indexRangeChecker(toIndex,size);

        IntLinkedList sublistResult = new IntLinkedList();
        Entry tmp = first;

        for (int i = 0; i < fromIndex; i++) {
            tmp = tmp.next;
        }

        for (int i = 0; i <= (toIndex - fromIndex); i++) {
            sublistResult.add(tmp.value);
            tmp = tmp.next;
        }

        return sublistResult;
    }

    @Override
    public int[] toArray() {
        int[] result = new int[size];
        Entry tmp = first;
        for (int i = 0; i < size; i++) {
            result[i] = tmp.value;
            tmp = tmp.next;
        }
        return result;
    }

    @Override
    public boolean push(int value) {
        add(0,value);
        return false;
    }

    @Override
    public int pop() {
        int result = get(0);
        remove();
        return result;
    }

    @Override
    public int peek() {
        return get(0);
    }

    @Override
    public String toString() {
        return Arrays.toString(toArray());
    }
}