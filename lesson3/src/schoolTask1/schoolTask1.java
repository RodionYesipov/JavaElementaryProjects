package schoolTask1;

import java.util.Scanner;
/*
«1»: Ввести a и b и вывести квадраты и кубы чисел от a до b.

Пример:

Введите границы интервала:

4 6

4 16 64

5 25 125

6 36 216

*/

public class schoolTask1 {
    public static void main(String[] args) {
        int a,b,kvadrat,kub;

        Scanner s = new Scanner(System.in);
        System.out.println("Введите число a\n");
        a = s.nextInt();

        System.out.println("Введите число b\n");
        b = s.nextInt();

        for(int i = a; i <= b; i++)
        {
            kvadrat = i * i;
            kub = kvadrat * i;

            System.out.println(i + " kvadrat=" + kvadrat + " kub=" + kub + "\n");
        }
    }
}

/* //Вариант 2
public class schoolTask1 {
    public static void main(String[] args) {
        int a,b,kvadrat,kub;

        Scanner s = new Scanner(System.in);
        System.out.println("Введите число a\n");
        a = s.nextInt();

        System.out.println("Введите число b\n");
        b = s.nextInt();

        for(; a <= b; a++)
        {
            kvadrat = a * a;
            kub = kvadrat * a;

            System.out.println(i + " kvadrat=" + kvadrat + " kub=" + kub + "\n");
        }
    }
}
*/