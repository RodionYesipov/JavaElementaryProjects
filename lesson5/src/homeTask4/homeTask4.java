package homeTask4;
//Составить функцию которая определяет наибольший общий делитель двух чисел
import java.util.Scanner;

public class homeTask4 {
    public static int NOD(int first_num, int second_num) {
        int temp = 0;
        if (first_num < second_num) {
            temp = first_num;
            first_num = second_num;
            second_num = temp;
        }
        while (first_num % second_num != 0) {
            if (first_num % second_num > 0) {
                temp = first_num;
                first_num = second_num;
                second_num = temp % second_num;
            }
        }

        return second_num;
    }

    ////////////////////
    public static void main(String[] agrs) {
        Scanner s = new Scanner(System.in);
        int f_num;
        int s_num;

        System.out.println("Enter a first number:");
        f_num = s.nextInt();

        System.out.println("Enter a second number:");
        s_num = s.nextInt();

        System.out.println("The NOD = " + NOD(f_num, s_num));

    }
}
