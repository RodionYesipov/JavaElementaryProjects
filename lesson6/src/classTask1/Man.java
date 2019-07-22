package classTask1;

public class Man {
   static int a = 3;
    static int b;
    static void doit(int x){
        System.out.println("x = " + x);
        System.out.println("a = " + a);
        System.out.println("b = " + b);
    }
    {
        System.out.println("block initialized");
    }

    static {
        System.out.println("static block initialized");
        b = a*4;
    }

    public static void main(String args[]){
        doit(42);
        Man s = new Man();
    }
}
