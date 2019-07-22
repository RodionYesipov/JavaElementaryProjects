package homeTask3_sort;
/*заполнить массив из 10 элементов случайными числами в интервале [0;100]
* и отсортиовать его по последней цифре
* */
import java.util.Random;

public class homeTask3_sort {
    public static void main(String[] args) {

        Random rand = new Random();
        final int N = 10;
        int mass[] = new int[N];
        boolean flag;
        int temp;

        for (int i = 0; i < N; i++) {
            mass[i] = rand.nextInt(100+1);
        }
        //generated massive
        System.out.println("Genetated massive:");
        for (int i = 0; i < N; i++) {
            System.out.print(mass[i] + " ");
        }
        /////////////////
        do{
            flag = false;
            for(int i = N-2; i >= 0; i--){
                if(mass[i]%10 > mass[i+1]%10){
                    temp = mass[i];
                    mass[i] = mass[i+1];
                    mass[i+1] = temp;
                    flag = true;
                }
            }

        }
        while (flag);
        ////
        System.out.println("\n\nSorted elements:");
        for (int i = 0; i < N; i++) {
                System.out.print(mass[i] + " ");
        }
    }
}
