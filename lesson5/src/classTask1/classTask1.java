package classTask1;

import java.util.Scanner;

public class classTask1 {
    //***********
    static int Max(int a, int b){
        if(a > b){
            return a;
        }
        else {
            return b;
        }
    }
    //***********

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.println("Введите 1е число");
        int a = s.nextInt();

        System.out.println("Введите 2е число");
        int b = s.nextInt();

        int result = Max(a,b);

        System.out.println("Большее число "+ result);

    }
}
