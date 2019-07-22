import java.util.Arrays;

public class IntArrayList implements IntList {

    private int[] arr = new int[10];
    private int size = 0;

    //function to extend our massive
    private void extendedArray() {
        if (size >= arr.length) {
            int newSize = arr.length * 3 / 2 + 1;
            int[] newArr = new int[newSize];
            System.arraycopy(arr, 0, newArr, 0, size);
            arr = newArr;
        }
    }

    //check index if it's in array range
    private void indexRangeChecker(int indexCheck, int rangeCheck) {
        if (indexCheck >= rangeCheck) {
            throw new IndexOutOfBoundsException("Your index = " + indexCheck + " is more than the array size = " + rangeCheck);
        } else if (indexCheck < 0) {
            throw new IndexOutOfBoundsException("Your index < 0");
        }
    }

    //check index if it's in array range
    private void subListChecker(int fromIndex, int toIndex) {
        if (fromIndex > toIndex) {
            throw new IndexOutOfBoundsException("Your fromIndex = " + fromIndex + " is more than toIndex = " + toIndex);
        }
    }

    @Override
    public void add(int element) {
        if (size >= arr.length) {
            extendedArray();
        }
        arr[size] = element;
        size++;
    }

    @Override
    public boolean add(int index, int element) {
        indexRangeChecker(index, size);

        if (size + 1 >= arr.length) {
            extendedArray();
        }
        System.arraycopy(arr, index, arr, index + 1, arr.length - index - 1);
        arr[index] = element;
        size++;
        return true;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            arr[i] = 0;
        }
        size = 0;
    }

    @Override
    public int get(int index) {
        indexRangeChecker(index, size);

        return arr[index];
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
        System.arraycopy(arr, index + 1, arr, index, size - index - 1);
        size--;
        return true;
    }

    @Override
    public boolean removeByValue(int value) {
        for (int i = 0; i < size; i++) {
            if (value == arr[i]) {
                System.arraycopy(arr, i + 1, arr, i, size - i - 1);
                size--;
                i--; //without decrement if there are more than one number of the same values at the end of array,
                //we will miss the last value
                //for example [0, 1, 2, 3, 4, 5, 6, 7, 9, 9, 9]
                //Remove element with value 9
                //[0, 1, 2, 3, 4, 5, 6, 7, 9]

            }
        }
        return true;
    }

    @Override
    public boolean set(int index, int element) {
        indexRangeChecker(index, size);
        arr[index] = element;
        return true;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public IntList subList(int fromIndex, int toIndex) {
        indexRangeChecker(fromIndex, size);
        indexRangeChecker(toIndex, size);
        subListChecker(fromIndex, toIndex);
        IntArrayList subListArray = new IntArrayList();
        subListArray.size = toIndex - fromIndex + 1;
        System.arraycopy(arr, fromIndex, subListArray.arr, 0, toIndex - fromIndex + 1);
        return subListArray;
    }

    @Override
    public int[] toArray() {
        int[] result = new int[size];
        for (int i = 0; i < size; i++) {
            result[i] = arr[i];
        }
        return result;
    }

    public String toString() {
        return Arrays.toString(toArray());
    }
}