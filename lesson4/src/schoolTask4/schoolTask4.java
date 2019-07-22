package schoolTask4;

import java.util.Random;

public class schoolTask4 {
    public static void main(String[] args) {

        Random rand = new Random();
        final int N = 10;
        int count = 0;
        int mass1[] = new int[N];
        int mass2[] = new int[N];

        for (int i = 0; i < N; i++) {
            mass1[i] = rand.nextInt(10*2+1)-10;
        }
        //generated massive
        System.out.println("Genetated massive:");
        for (int i = 0; i < N; i++) {
            System.out.print(mass1[i] + " ");
        }
        //////////////////

        for(int i = 0; i < N; i++){
            if(mass1[i] < 0){
                mass2[count] = mass1[i];
                count++;
            }
        }

        System.out.println("\n\nMassive 2:");
        for (int i = 0; i < N; i++) {
            System.out.print(mass2[i] + " ");
        }
    }
}
