package task4;

import java.util.Scanner;

public class task4 {
    public static void main(String[] args) {
        int n,count;
        Scanner s = new Scanner(System.in);
        System.out.println("Введите целое число\n");
        n = s.nextInt();

        count = 0;

        while(n != 0)
        {
            n = n/10;
            count++;
        }
        System.out.println("В числе " + count + " цифр");
    }
}
