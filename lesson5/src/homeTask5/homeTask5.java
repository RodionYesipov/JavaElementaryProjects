package homeTask5;
//Составить функцию, которая определяет, верно ли, что сумма его цифр - четное число
import java.util.Scanner;

public class homeTask5 {
    public static void evenSumOfDigits(int number) {
        int digits_sum = 0;
        while(number != 0){
            digits_sum += number%10;
            number /= 10;
        }

        boolean result = false;

        if(digits_sum%2 == 0){
            result = true;
        }

        if(result) {
            System.out.println("Сумма цифр четная");
        }
        else {
            System.out.println("Сумма цифр не четная");
        }
    }

    ////////////////////
    public static void main(String[] agrs) {
        Scanner s = new Scanner(System.in);
        int num;

        System.out.println("Введите число:");
        num = s.nextInt();

        evenSumOfDigits(num);

    }
}
