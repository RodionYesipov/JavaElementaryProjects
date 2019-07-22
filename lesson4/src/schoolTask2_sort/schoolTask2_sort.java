package schoolTask2_sort;

import java.util.Random;

public class schoolTask2_sort {
    public static void main(String[] args) {

        Random rand = new Random();
        final int N = 10;
        int temp = 0;
        int mass1[] = new int[N];

        for (int i = 0; i < N; i++) {
            mass1[i] = rand.nextInt(10*2+1)-10;
        }
        //generated massive
        System.out.println("Genetated massive:");
        for (int i = 0; i < N; i++) {
            System.out.print(mass1[i] + " ");
        }
        //////////////////
        for (int i = 0; i < N - 1; i++) {
            for (int j = N - 2; j >= i; j--) {

                if (mass1[j] > mass1[j+1]) {
                    temp = mass1[j];
                    mass1[j] = mass1[j+1];
                    mass1[j+1] = temp;
                }
            }
        }

        System.out.println("\n\nSorted massive:");
        for (int i = 0; i < N; i++) {
            System.out.print(mass1[i] + " ");
        }
    }
}
