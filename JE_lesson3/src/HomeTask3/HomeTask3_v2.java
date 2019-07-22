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

public class HomeTask3_v2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);


        System.out.println("Enter some characters:");
        String scannedRow = scan.nextLine();
        char scannedRowCharacter = scannedRow.charAt(0);

        char[] scannedRowToArray = scannedRow.toCharArray();

        for (int i = 0; i < scannedRowToArray.length; i++) {

            scannedRowCharacter = scannedRow.charAt(i);

            if (scannedRowCharacter >= 'A' && scannedRowCharacter <= 'Z') {
                scannedRowCharacter += 32;
                scannedRowToArray[i] = scannedRowCharacter;
            }
        }

        System.out.println("Modified array:");
        System.out.println(Arrays.toString(scannedRowToArray));
    }
}