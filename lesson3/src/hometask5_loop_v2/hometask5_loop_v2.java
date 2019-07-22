package hometask5_loop_v2;
/*
«1»: Пользователь с клавиатуры последовательно вводит целые числа. Как только пользователь

ввел 0, необходимо показать на экран сумму всех введенных чисел.
*/
import java.util.Scanner;

public class hometask5_loop_v2 {
        public static void main(String[] args) {
            int n,summa;
            summa = 0;

            Scanner s = new Scanner(System.in);
            System.out.println("Введите целое число:\n");
            for(int i = 0;;i++)
            {
                n = s.nextInt();
                summa += n;

                if(n == 0){
                    break;
                }
            }

            System.out.println("Сумма цифр = " + summa);
        }
}
