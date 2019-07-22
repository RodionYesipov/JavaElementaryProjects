package homeTask1;

import java.util.Scanner;

/*Составить функцию, которая определяет сумму всех чисел от 1 до N
Пример
Введите число:
100
сумма чисел от 1 до 100 = 5050
* */
public class homeTask1 {
    public static int sumToN(int N){
        int sum = 0;
        for(int i = N; i >= 1; i--){
            sum += i;
        }

        return sum;
    }
    ////////////////////
    public static void main(String[] agrs){
        Scanner s = new Scanner(System.in);
        int scan_number;

        System.out.println("Enter a number:");
        scan_number = s.nextInt();

        System.out.println("The sum of numbers from 1 to " + scan_number + " = " + sumToN(scan_number));
    }
}
