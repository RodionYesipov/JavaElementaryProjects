package schoolTask1;
import java.util.Random;
public class schoolTask1 {
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

        for (int j = 0; j < N / 2; j++) {
            temp = mass[j];
            mass[j] = mass[N - 1 - j];
            mass[N - 1 - j] = temp;
        }
        //reversed massive
        System.out.println("\n\nReversed massive:");
        for (int i = 0; i < N; i++) {
            System.out.print(mass[i] + " ");
        }

    }
}
