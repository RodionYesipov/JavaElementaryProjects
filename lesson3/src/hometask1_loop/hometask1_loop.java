package hometask1_loop;

import java.util.Scanner;
/*
«1»: Ввести целое число и найти сумму его цифр.
Пример:

Введите целое число:

1234

Сумма цифр числа 1234 равна 10.
*/

public class hometask1_loop {
    public static void main(String[] args) {
        int n,summa;
        summa = 0;

        Scanner s = new Scanner(System.in);
        System.out.println("Введите целое число:\n");
        n = s.nextInt();

        while(n != 0)
        {
            summa += n%10;
            n = n/10;
        }
        System.out.println("Сумма цифр = " + summa);
    }
}
