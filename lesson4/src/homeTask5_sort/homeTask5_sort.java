package homeTask5_sort;
/*«1»: Написать программу, которая сортирует массив ПО УБЫВАНИЮ и ищет в нем элемент,
равный X (это число вводится с клавиатуры). */
import java.util.Random;
import java.util.Scanner;

public class homeTask5_sort {
    public static void main(String[] args) {

        Random rand = new Random();
        Scanner s = new Scanner(System.in);

        final int N = 10;
        int mass[] = new int[N];
        boolean flag;
        int temp;
        int X;
        int L = 0;
        int R = N - 1;
        int middle;
        int nX = -1;

        for (int i = 0; i < N; i++) {
            mass[i] = rand.nextInt(100+1);
        }
        //generated massive
        System.out.println("Genetated massive:");
        for (int i = 0; i < N; i++) {
            System.out.print(mass[i] + " ");
        }
        ////////////////
        //сортировка по убыванию
        do{
            flag = false;
            for(int i = 0; i < N-1; i++){
                if(mass[i] < mass[i+1]){
                    temp = mass[i+1];
                    mass[i+1] = mass[i];
                    mass[i] = temp;
                    flag = true;
                }
            }

        }
        while (flag);
        ///////////////////
        System.out.println("\nEnter a number:");
        X = s.nextInt();
        //поиск элемента
        while (R >= L){
            middle = (R + L)/2;
            if(X == mass[middle]){
                nX = middle;
                break;
            }

            if(X < mass[middle]) L = middle + 1;
            if(X > mass[middle]) R = middle - 1;
        }
        ////
        System.out.println("\nSorted elements:");
        for (int i = 0; i < N; i++) {
            System.out.print(mass[i] + " ");
        }

        if(nX < 0) {
            System.out.println("\nNumber is not found");
        }
        else {
            System.out.println("\nNumber is found at "+nX+" element of massive");
        }
    }
}
