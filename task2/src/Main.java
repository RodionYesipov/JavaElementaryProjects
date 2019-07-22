import java.util.Scanner;

public class Main {

    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        int i,x;
        System.out.println("Enter x\n");

        x = s.nextInt();

        System.out.println("Ok\n"); // Вывод сигнального сообщения
        i = 10;
        if(i < x)
        {
            System.out.println(i + "\n");
        }
        System.out.println("Ok\n"); // сигн сообщение

        System.out.println("Bye!");
    }
}
