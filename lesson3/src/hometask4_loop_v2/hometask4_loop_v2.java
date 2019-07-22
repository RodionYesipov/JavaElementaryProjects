package hometask4_loop_v2;
/*
«2»: Ввести натуральное число и определить, какие цифры встречаются несколько раз.
Пример:

Введите число >= 0:                             Введите число >= 0:
2323                                         1234

Повторяются: 2, 3                             Нет повторов.
*/

import java.util.Scanner;

public class hometask4_loop_v2 {
    public static void main(String[] args) {
        int n, n_copy, num_length, compare_fl;
        int j = 0, k = 1;

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

        int digits_mass[] = new int[num_length];        //массив цифр введенного с консоли числа
        int repeat_digits_mass[] = new int[num_length]; //массив, в который буду записывать повторяющиеся цифры

        //записал каждую цифру в массив
        for (int i = num_length - 1; i >= 0; i--)
        {
            digits_mass[i] = n_copy % 10;
            n_copy = n_copy / 10;

            //массив, в который буду записывать повторяющиеся цифры, заполняю отрицательными значениями,
            //чтобы потом вывести только положительные
            repeat_digits_mass[i] = -1;
        }

        //-2 потому что последнюю цифру нет смысла сравнивать саму с собой
        for (j = 0; j <= num_length - 2; j++)
        {
            for (k = j + 1; k <= num_length - 1; k++)
            {

                if (digits_mass[j] == digits_mass[k])
                {
                    ////////////////////////////////////////
                    //записываю в массив повторяющихся цифр только в случае, если нет таких ранее записанных цифр
                    for(int i = 0; i <= num_length - 1; i++)
                    {
                        if(repeat_digits_mass[i] == digits_mass[j])
                        {
                            compare_fl++;
                        }
                    }
                    /////////////////////////////////////////

                    if(compare_fl == 0) {
                        repeat_digits_mass[j] = digits_mass[j];
                    }
                }

                compare_fl = 0;
            }
        }
///////////////////////////////////////////////////////////////////////////
        /*for (j = 0; j <= num_length - 1; j++)
        {
            System.out.println(repeat_digits_mass[j]);
        }*/
    //вывод на экран
    //нахожу макс индекс положительного элемента в массиве с повторяющимися цифрами
    //чтобы после последнего элемента при выводе в консоль не ставить запятую
        int last_rep_digit = -1;

        for(int i = 0; i <= num_length - 1; i++)
        {
            if(repeat_digits_mass[i] >= 0)
            {
                last_rep_digit = i;
            }
        }

        if(last_rep_digit >= 0)
        {
            System.out.print("Повторяющиеся числа: ");
            for (j = 0; j <= last_rep_digit; j++)
            {
                if (repeat_digits_mass[j] >= 0 && j == last_rep_digit)
                {
                    System.out.print(repeat_digits_mass[j]);
                }
                else if(repeat_digits_mass[j] >= 0 && j != last_rep_digit)
                {
                    System.out.print(repeat_digits_mass[j] + ",");
                }
            }
            //System.out.println("last_rep_digit = "+last_rep_digit);
        }
        else {
            System.out.println("Нет повторов!");
        }
    }
}
