package Hometask2;

import java.util.Arrays;
import java.util.Scanner;

/**
 2. Написать метод.

Входящий параметр: отсортированный массив типа int который содержит отрицательные и положительные значения.
Вернуть отсортированный массив который состоит из квадратов значений.
Не использовать при этом стандартный метод sort.

Пример:
Input: [-4,-1,0,3,10]
Output: [0,1,9,16,100]
**/

public class HomeTask2 {
    private static int[] sortedArrayOfSquares(int[] arrayOfNumbers) {
        int[] arrayOfSquares = new int[arrayOfNumbers.length];
        boolean sortFlag;

        for (int i = 0; i < arrayOfSquares.length; i++) {
            arrayOfSquares[i] = arrayOfNumbers[i] * arrayOfNumbers[i];
        }

        do {
            sortFlag = false;
            int variableForReplace;
            for (int i = arrayOfSquares.length - 2; i >= 0; i--) {
                if (arrayOfSquares[i] > arrayOfSquares[i + 1]) {
                    variableForReplace = arrayOfSquares[i];
                    arrayOfSquares[i] = arrayOfSquares[i + 1];
                    arrayOfSquares[i + 1] = variableForReplace;
                    sortFlag = true;
                }

            }
        }
        while (sortFlag);

        return arrayOfSquares;
    }

    public static void main(String[] args) {
        int size = 5;
        int[] inputArray = new int[size];
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter sorted array of " + size + " integer numbers:");
        for (int i = 0; i < inputArray.length; i++) {
            inputArray[i] = scan.nextInt();
        }

        System.out.println("The squares of numbers:");
        System.out.println(Arrays.toString(sortedArrayOfSquares(inputArray)));
    }
}
