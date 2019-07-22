package String_hometask;
//1) Даны строки разной длины, необходимо вернуть их первую половину.
//        Пример введения:
//        firstHalf("WooHoo") → "Woo"
//        firstHalf("HelloThere") → "Hello"
//        firstHalf("abcdef") → "abc"


import java.util.Scanner;

public class task1 {
    public static void main(String args[]) {

        Scanner s = new Scanner(System.in);

        System.out.println("Введите строку:");
        String inputString = s.nextLine();
        System.out.println("Результат:");
        System.out.println(inputString.substring(0,inputString.length()/2));
    }
}
