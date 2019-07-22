package hometask2_loop;
/*
«2»: Ввести целое число и определить, верно ли, что в его записи есть две одинаковые цифры.
Пример:

Введите целое число: Введите целое число:

1234                     1224

Нет.                     Да.

 */

import java.util.Scanner;

public class hometask2_loop {
    public static void main(String[] args) {
        int n,n_copy, num_length, single_digit, inner_n, compare_digit, compare_FL,compare_FL_itog;

        num_length = 0;
        compare_FL = 0;
        compare_FL_itog = 0;

        Scanner s = new Scanner(System.in);
        System.out.println("Введите целое число:\n");
        n = s.nextInt();

        n_copy = n;

        //нахожу кол-во цифр в числе
        while (n != 0) {
            n = n / 10;
            num_length++;
        }

        // во внешнем цикле по очереди перебираю каждую цифру числа
        for (int i = 10; i <= Math.pow(10,num_length); i = i*10)
        {
            single_digit = (n_copy % i)/(i/10);
            inner_n = n_copy;

            while(inner_n != 0)
            {
                compare_digit = inner_n%10;
                inner_n = inner_n/10;

                if(compare_digit == single_digit)
                {
                    compare_FL++;
                }
                //т.к внутренний цикл проходит по всем цифрам,значение будет минимум 1,цифра встречает сама себя
                if(compare_FL > 1)
                {
                    compare_FL_itog++;
                }
            }
            compare_FL = 0;
        }

        if(compare_FL_itog > 0)
        {
            System.out.println("Да");
        }
        else {
            System.out.println("Нет");
        }
        }
    }

