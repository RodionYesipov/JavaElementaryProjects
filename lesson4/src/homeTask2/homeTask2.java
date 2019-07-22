package homeTask2;
/*Заполнить массив случайными числами и выделить в другой массив все числа, которые встречаются более одного раза.

Пример:

Исходный массив:

4   1   2   1   11   2   34

Результат:

1   2
*/
import java.util.Random;

public class homeTask2 {
    public static void main(String[] args) {

        Random rand = new Random();
        final int N = 10;
        int count = 0,compare_fl = 0;
        int last_rep_elem = -100; //последний записанный повторяющийся елемент
        int mass[] = new int[N];
        int repeat_mass[] = new int[N];

        for (int i = 0; i < N; i++) {
            mass[i] = rand.nextInt(10*2+1)-10;
            repeat_mass[i] = -100; //заполнил массив значениями, которых не будет в диапазоне [-10;10]
                                    //т.к. дефолтные значения в незаполненом массиве 0, и если будет повтор нулей,
                                    //то не будет понятно, ноль мы записали или он там был дефолтно
        }
        //generated massive
        System.out.println("Genetated massive:");
        for (int i = 0; i < N; i++) {
            System.out.print(mass[i] + " ");
        }
        /////////////////
        for(int i = 0; i < mass.length-1; i++) {
            for (int j = i+1; j < mass.length; j++) {
                if (mass[j] == mass[i]) {
                    for(int k = 0; k < repeat_mass.length; k++) {
                        if (mass[j] == repeat_mass[k]) {
                            compare_fl++;
                        }
                    }

                    if(compare_fl == 0){
                        repeat_mass[count] = mass[j];
                        count++;
                    }
                    compare_fl = 0;
                }
            }
        }
        ////
        System.out.println("\n\nRepeated elements:");
        for (int i = 0; i < N; i++) {
            if (repeat_mass[i] == -100){
                break;
            }
            else {
                System.out.print(repeat_mass[i] + " ");
            }
        }
    }
}
