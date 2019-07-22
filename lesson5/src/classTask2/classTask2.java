package classTask2;

import java.util.Scanner;

public class classTask2 {

    public static long maxElement(int array[ ]) {
        int value = array[0];
        for (int i = 1; i < array.length; i++) {
            value = value > array [i] ? value : array [i] ; // тернарный оператор
        }
        return (long) value; //------> явное приведение типов
    }

    public static double maxElement(double array[ ]) {
        double value = array[0];
        for (int i = 1; i < array.length; i++) {
            value = value > array [i] ? value :array [i] ; // тернарный оператор
        }
        return value;
    }

    public static void main(String[] args) {
        int x[] = {10,20,25,10,5};
        double f[] = {0.25,1.75,0.01,2.24,4.58};

        System.out.println("The biggest element: " +  maxElement(x));
        System.out.println("The biggest element: " +  maxElement(f));

    }
}
