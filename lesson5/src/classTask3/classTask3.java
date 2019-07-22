package classTask3;

import java.util.Scanner;

public class classTask3 {
    public static int Factor(int chislo) {
        if (chislo == 1 || chislo == 0) return 1;
        else return chislo * Factor(chislo - 1);
    }

    public static void main(String[] args) {
        int f;

        Scanner s = new Scanner(System.in);

        System.out.println("Enter a number");
        f = s.nextInt();
        System.out.println("Factorial = " + Factor(f));

    }
}
