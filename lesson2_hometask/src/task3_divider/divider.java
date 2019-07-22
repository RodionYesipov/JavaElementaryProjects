package task3_divider;

import java.util.Scanner;
/*
«3»: Определить является ли число a делителем числа b и c одновременно (делится без остатка).
*/
public class divider {

    public static void main(String[] args)
    {
        int a;
        int b;
        int c;

        Scanner s = new Scanner(System.in);

        System.out.println("Введите число a:\n");
        a = s.nextInt();

        System.out.println("Введите число b:\n");
        b = s.nextInt();

        System.out.println("Введите число c:\n");
        c = s.nextInt();

        if(b%a == 0 && c%a == 0)
        {
            System.out.println("a является делителем для чисел b и c одновременно!");
        }
        else if(b%a == 0 && c%a != 0)
        {
            System.out.println("a является делителем только для числа b!");
        }
        else if(b%a != 0 && c%a == 0)
        {
            System.out.println("a является делителем только для числа c!");
        }
        else
        {
            System.out.println("a не является делителем ни для одного из чисел!");
        }


    }

}
