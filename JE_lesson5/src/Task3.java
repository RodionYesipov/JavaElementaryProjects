import java.util.Arrays;

/**
3*. Написать метод. Входящие параметры: отсортированный массив и число.
Метод должен вернуть true если это число есть в массиве, используя бинарный поиск.
* */
public class Task3 {
    private static boolean findElementInArray(int[] sortedArray, int elementToCheck){
        int indexElementToCheck = -1;
        int halfLength;
        int left = 0;
        int right = sortedArray.length - 1;
        while (right >= left) {
            halfLength = (right + left) / 2;
            if (elementToCheck == sortedArray[halfLength]) {
                indexElementToCheck = halfLength;
                break;
            }
            if (elementToCheck < sortedArray[halfLength]) {
                right = halfLength - 1;
            } else {
                left = halfLength + 1;
            }
        }

        if(indexElementToCheck >= 0) {
            return true;
        } else {
            return false;
        }
    }
    public static void main(String[] args) {
        int[] sortedArray = new int[10];
        int elementToCheck = 5;
        for (int i = 0; i < sortedArray.length; i++) {
            sortedArray[i] = i;
        }
        System.out.println("Our array:\n" + Arrays.toString(sortedArray));
        System.out.println("Is there element " + elementToCheck + " in our array?\n" + findElementInArray(sortedArray,elementToCheck));
    }
}
