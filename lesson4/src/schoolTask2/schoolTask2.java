package schoolTask2;

import java.util.Random;

public class schoolTask2 {
    public static void main(String[] args) {

        Random rand = new Random();
        final int N = 10;
        int mass[] = new int[N];
        int temp;

        for (int i = 0; i < N; i++) {
            mass[i] = rand.nextInt(100);
        }
        //generated massive
        System.out.println("Genetated massive:");
        for (int i = 0; i < N; i++) {
            System.out.print(mass[i] + " ");
        }
        //////////////////
        temp = mass[0];
        for (int j = 0; j < N -1; j++) {
            mass[j] = mass[j+1];
        }

        mass[N-1] = temp;
        //reversed massive
        System.out.println("\n\nMoved massive:");
        for (int i = 0; i < N; i++) {
            System.out.print(mass[i] + " ");
        }

    }
}
