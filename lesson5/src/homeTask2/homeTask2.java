package homeTask2;

import java.util.Scanner;
/*Составить функцию которая рисует линию из символа symb, длиной count
* */
/*
public class homeTask2 {
        public static void printCountSymb(int count,char symb){
            for(int i = 0; i < count; i++){
                System.out.print(symb);
            }
        }
        ////////////////////
        public static void main(String[] agrs){
            Scanner s = new Scanner(System.in);
            int scan_number;
            char symb;

            System.out.println("Enter a number:");
            scan_number = s.nextInt();

            System.out.println("Enter a symbol:");
            symb = s.next().charAt(0);

            System.out.println("The result of function:\n");
            printCountSymb(scan_number,symb);
        }
}
*/

public class homeTask2 {
    public static String printCountSymb(int count,char symb){
        String result = new String();

        for(int i = 0; i < count; i++){
            result = result+symb;
        }
        return result;
    }
    ////////////////////
    public static void main(String[] agrs){
        Scanner s = new Scanner(System.in);
        int scan_number;
        char symb;

        System.out.println("Enter a number:");
        scan_number = s.nextInt();

        System.out.println("Enter a symbol:");
        symb = s.next().charAt(0);

        System.out.println("The result of function:\n");
        System.out.println(printCountSymb(scan_number,symb));
    }
}