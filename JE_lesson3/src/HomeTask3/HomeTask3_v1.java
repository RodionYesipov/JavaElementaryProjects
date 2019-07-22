package HomeTask3;

import java.util.Arrays;
import java.util.Scanner;

/**
3*. Дана строк состоящая из любых символов. Не используя стандартный метод String.toLowerCase()
 перевести все большие латинские буквы в маленькие.

Пример:
Input: "#1AmC"
Output: "#1amc"
**/

public class HomeTask3_v1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);


        System.out.println("Enter some characters:");
        String scannedRow = scan.nextLine();
        char oldChar = scannedRow.charAt(0);
        char newChar = scannedRow.charAt(0);

        char[] scannedRowToArray = scannedRow.toCharArray();

        for (int i = 0; i < scannedRowToArray.length; i++) {

            oldChar = scannedRow.charAt(i);
            newChar = scannedRow.charAt(i);

            if (oldChar >= 'A' && oldChar <= 'Z') {
                newChar = (char) (oldChar + 32);
                scannedRow = scannedRow.replace(String.valueOf(oldChar),String.valueOf(newChar));
            }
        }
        System.out.println("Modified array:");
        System.out.println(scannedRow);
    }
}