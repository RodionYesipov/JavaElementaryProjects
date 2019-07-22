package schoolTask3;
/*Заполнить массив из 10 элементов случайными числами в интервале [-10..10] и выполнить циклический сдвиг ВПРАВО.

Пример:

Исходный массив:

4 -5 3 10 -4 -6 8 -10 1 0

Результат:

0 4 -5 3 10 -4 -6 8 -10 1
*/
import java.util.Random;

public class schoolTask3 {
    public static void main(String[] args) {

        Random rand = new Random();
        final int N = 10;
        int mass[] = new int[N];
        int temp;

        for (int i = 0; i < N; i++) {
            mass[i] = rand.nextInt(10*2+1)-10;
        }
        //generated massive
        System.out.println("Genetated massive:");
        for (int i = 0; i < N; i++) {
            System.out.print(mass[i] + " ");
        }
        //////////////////
        temp = mass[N-1];
        for (int j = N-1; j > 0; j--) {
            mass[j] = mass[j-1];
        }

        mass[0] = temp;
        //reversed massive
        System.out.println("\n\nMoved massive:");
        for (int i = 0; i < N; i++) {
            System.out.print(mass[i] + " ");
        }

    }
}
