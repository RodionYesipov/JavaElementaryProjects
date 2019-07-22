package hometask5_loop;
/*
«1»: Пользователь с клавиатуры последовательно вводит целые числа. Как только пользователь

ввел 0, необходимо показать на экран сумму всех введенных чисел.
*/
import java.util.Scanner;

public class hometask5_loop {
    public static void main(String[] args) {
        int n,summa;
        summa = 0;

        Scanner s = new Scanner(System.in);
        System.out.println("Введите целое число:\n");

        do  {
                n = s.nextInt();
                summa += n;
            }
        while(n != 0);

        System.out.println("Сумма цифр = " + summa);
    }
}
