package homeTask4_sort;

/*заполнить массив из 10 элементов случайными числами в интервале [0;100]
 * и отсортиовать первую половину по возрастанию, а вторую по убыванию
 * */
import java.util.Random;

public class homeTask4_sort {
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
        //первую половину по возрастанию
        do{
            flag = false;
            for(int i = N/2-1; i >= 0; i--){
                if(mass[i] > mass[i+1]){
                    temp = mass[i];
                    mass[i] = mass[i+1];
                    mass[i+1] = temp;
                    flag = true;
                }
            }

        }
        while (flag);

        //вторую половину по убыванию
        do{
            flag = false;
            for(int i = N/2; i < N-1; i++){
                if(mass[i] < mass[i+1]){
                    temp = mass[i+1];
                    mass[i+1] = mass[i];
                    mass[i] = temp;
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
