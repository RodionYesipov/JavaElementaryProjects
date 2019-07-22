package hometask4_loop;
/*
«2»: Ввести натуральное число и определить, какие цифры встречаются несколько раз.
Пример:

Введите число >= 0:                             Введите число >= 0:
2323                                         1234

Повторяются: 2, 3                             Нет повторов.
*/
import java.util.Scanner;

public class hometask4_loop {
    public static void main(String[] args) {
        int n,n_copy, num_length, single_digit, inner_n, compare_digit, compare_FL,compare_FL_itog,repeated_digits;

        num_length = 0;
        compare_FL = 0;
        compare_FL_itog = 0;
        repeated_digits = 0;

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
        //////////////////////////////////////////////////////////

        // во внешнем цикле по очереди перебираю каждую цифру числа
        for (int i = 10; i <= Math.pow(10,num_length); )
        {
            single_digit = (n_copy % i)/(i/10);
            inner_n = n_copy;

            //System.out.println(single_digit);
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
                    repeated_digits += single_digit*i;
                    System.out.println(repeated_digits);
                    break;
                }
            //compare_FL = 0;
            }

            i = i*10;
            compare_FL = 0;
        }
        System.out.println("repeated_digits = " + repeated_digits);
    }
}
