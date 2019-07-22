package homeTask1;

import java.util.Random;
/*Заполнить массив из 10 элементов случайными числами в интервале [-10..10]
и выполнить инверсию отдельно для 1-ой и 2-ой половин массива.
Пример:
Исходный массив:
   4 -5 3 10 -4  -6 8 -10 1 0
Результат:
  -4 10 3 -5 4   0 1 -10 8 -6
*/
public class homeTask1 {
    public static void main(String[] args) {

        Random rand = new Random();
        final int N = 10;
        int temp;
        int mass[] = new int[N];
        int repeat_mass[] = new int[N];

        for (int i = 0; i < N; i++) {
            mass[i] = rand.nextInt(10*2+1)-10;
        }
        //generated massive
        System.out.println("Genetated massive:");
        for (int i = 0; i < N; i++) {
            System.out.print(mass[i] + " ");
        }
        /////////////////
        for (int i = 0; i < N/2/2; i++) {
            //1st part of massive
            temp = mass[i];
            mass[i] = mass[N/2-1-i];
            mass[N/2-1-i] = temp;
            //2nd part of massive
            temp = mass[i+N/2];
            mass[i+N/2] = mass[N-1-i];
            mass[N-1-i] = temp;
        }
        ////
        System.out.println("\n\nInversed massive:");
        for (int i = 0; i < N; i++) {
            System.out.print(mass[i] + " ");
        }
    }
}
