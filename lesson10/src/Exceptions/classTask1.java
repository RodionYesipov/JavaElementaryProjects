package Exceptions;

public class classTask1 {
    public  static void main(String[] args){
        try {
            int c = 2;
            int a = 0;
            int b = c / a;
        } catch (ArithmeticException e){
            System.out.println("caught an exception");
            System.out.println(e.getMessage());
            System.out.println("after exception");
        }

        System.out.println("method still working");
    }
}
