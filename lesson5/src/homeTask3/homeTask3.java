package homeTask3;

import java.util.Scanner;
//Составить функцию которая спросит число и степень в которую необходимо возвести это число
public class homeTask3 {
        public static int toPower(int number,int power){
            int result = 1;
            for(int i = 0; i < power; i++){
                result *= number;
            }

            return result;
        }
        ////////////////////
        public static void main(String[] agrs){
            Scanner s = new Scanner(System.in);
            int scan_number;
            int powerNum;

            System.out.println("Enter a number:");
            scan_number = s.nextInt();

            System.out.println("Enter a power:");
            powerNum = s.nextInt();

            System.out.println("The result of function = " + toPower(scan_number,powerNum));

        }
}
