import java.util.Scanner;

/**
 4. Написать программу которая вычисляет значения корня квадратного без использования
 библиотечных методов типа Math.sqrt(). Например методом половинного деления.
* */
public class ExtraHomeTask4 {
    private static double mySqrt(int givenNumber){ // by Newton algorithm
        double approach = givenNumber/2;
        double temp;
        do{
            temp = approach;
            approach = 0.5*(temp + (givenNumber/temp));
           // System.out.println(approach);
        } while(temp - approach != 0);
        return approach;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter integer number:");
        int givenNumber = scan.nextInt();
        System.out.println("sqrt = " + Math.round(mySqrt(givenNumber)));
    }
}