import java.util.Scanner;

public class Main {

    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);

        System.out.println("Введите сумму:");
        int a = s.nextInt();

        System.out.println("Ваша скидка в %:");
        float b = s.nextInt();

        int c ;
        c = Math.round(a*(1-b/100));
        System.out.println("К оплате:\n " + c);
    }
}
