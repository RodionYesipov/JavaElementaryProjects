package HomeTask1;

import java.util.Arrays;
import java.util.Scanner;

/**
* 1. Написать метод numJewelsInStones который принимает 2 параметра:
- String jewels: строка, каждый символ который символизирует драгоценный камень, символы уникальны
- String stones: строка, каждый символ который символизирует камень.

Строки могут состоять только из символов a..zA..Z
Метод должне вернуть количество другоценных камней в строке stones.

Пример:
jewels = "aAb"
stones = "caсAcA"
Output: 3

Explanation: в строке stones есть 3 драг. камня: a,A,A
* */
public class HomeTask1 {

    private static boolean uniqueJewelsCheck(String jewels) {
        char[] jewelsArray = jewels.toCharArray();
        boolean uniqueCheck = true;

        for (int i = 0; i < jewelsArray.length - 1; i++) {
            for (int j = i + 1; j < jewelsArray.length; j++) {
                if (jewelsArray[i] == jewelsArray[j]) {
                    uniqueCheck = false;
                    break;
                }
            }
            if (!uniqueCheck) {
                break;
            }
        }
        return uniqueCheck;
    }


    private static boolean digitsChecker(String rowToCheck) {
        char[] rowToCheckArray = rowToCheck.toCharArray();
        boolean digitsCheck = true;

        for (int i = 0; i < rowToCheckArray.length; i++) {
            if (!Character.isLetter(rowToCheckArray[i])) {
                digitsCheck = false;
                break;
            }
            if (!digitsCheck) {
                break;
            }
        }
        return digitsCheck;
    }


    private static int numJewelsInStones(String jewels, String stones) {

        char[] sortedJewels = jewels.toCharArray();
        char[] sortedStones = stones.toCharArray();
        int jewelsNumber = 0;

        Arrays.sort(sortedJewels);
        Arrays.sort(sortedStones);

        for (int i = 0; i < sortedJewels.length; i++) {
            for (int j = 0; j < sortedStones.length; j++) {
                if (sortedJewels[i] == sortedStones[j]) {
                    jewelsNumber++;
                }
            }
        }
        return jewelsNumber;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter jewels:");
        String jewels = scan.nextLine();

        do {
            if (!uniqueJewelsCheck(jewels)) {
                System.out.println("Enter unique characters for jewels!");
                jewels = scan.nextLine();

            } else if (!digitsChecker(jewels)) {
                System.out.println("Enter only letters a-z, A-Z!");
                jewels = scan.nextLine();
            } else {
                break;
            }
        }
        while (!uniqueJewelsCheck(jewels) || !digitsChecker(jewels));

        System.out.println("Enter stones:");
        String stones = scan.nextLine();

        do {
            if (!digitsChecker(stones)) {
                System.out.println("Enter only letters a-z, A-Z!");
                stones = scan.nextLine();
            } else {
                break;
            }
        }
        while (!digitsChecker(stones));

        System.out.print("The numer of jewel stones = ");
        System.out.print(numJewelsInStones(jewels, stones));
    }

}
