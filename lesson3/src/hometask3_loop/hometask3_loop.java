package hometask3_loop;

import java.util.Scanner;

/*
«1»: Ввести натуральное число и определить, верно ли, что сумма его цифр равна 10.
Пример:

Введите число >= 0:                         Введите число >= 0:
-234                                     1233

Нужно положительное число.                           Нет
Введите число >= 0:
1234
Да
*/
public class hometask3_loop {
    public static void main(String[] args) {
        int n,summa;
        summa = 0;

        Scanner s = new Scanner(System.in);
        System.out.println("Введите положительное целое число:\n");
        n = s.nextInt();

        do{

            if(n <= 0) {
                System.out.println("Нужно положительное число!");
                n = s.nextInt();

                if(n == 0){
                    n = -1; //чтобы при вводе нуля несколько раз подряд не выходило из цикла,
                            // а запрашивало положительное число, пока его не введут
                }
            }
            else
            {
                summa += n % 10;
                n = n / 10;
            }
        }
        while(n != 0);

        if (summa == 10)
        {
            System.out.println("Да");
        }
        else {
            System.out.println("Нет");
        }
    }
}
