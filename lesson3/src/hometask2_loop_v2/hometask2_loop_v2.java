package hometask2_loop_v2;
/*
«2»: Ввести целое число и определить, верно ли, что в его записи есть две одинаковые цифры.
Пример:

Введите целое число: Введите целое число:

1234                     1224

Нет.                     Да.

 */

import java.util.Scanner;

public class hometask2_loop_v2 {
    public static void main(String[] args) {
        int n,n_copy, num_length,compare_fl;
        int j = 0,k = 1;

        num_length = 0;
        compare_fl = 0;

        Scanner s = new Scanner(System.in);
        System.out.println("Введите целое число:\n");
        n = s.nextInt();

        n_copy = n;

        //нахожу кол-во цифр в числе
        while (n != 0) {
            n = n / 10;
            num_length++;
        }
        //System.out.println("Кол-во цифр = " + num_length);

        int digits_mass[] = new int[num_length];

        //записал каждую цифру в массив
        for(int i = num_length-1; i >= 0; i--)
        {
            digits_mass[i] = n_copy%10;
            n_copy = n_copy/10;
        }

        //-2 потому что последнюю цифру нет смысла сравнивать саму с собой
        for(j = 0; j <= num_length - 2; j++)
        {
            for(k = j+1; k <= num_length - 1; k++)
            {
                if(digits_mass[j] == digits_mass[k])
                {
                    compare_fl++;
                }
            }
        }

        if(compare_fl > 0)
        {
            System.out.println("Yes!");
        }
        else {
            System.out.println("No!");
        }
    }
}
