package hometask1_mass;
/*Задача:
«1» Ввести с клавиатуры массив из 5 элементов, умножить все элементы на 2 и вывести  полученный массив на экран.
*/
import java.util.Scanner;

public class hometask1_mass {
    public static void main(String[] args) {
        //Random rand = new Random();
        int N = 5;
        int mass[] = new int[N];

        Scanner s = new Scanner(System.in);

        System.out.println("Enter " + mass.length + " numbers:\n");
        for(int i = 0; i < N; i++)
        {
            mass[i] = s.nextInt()*2;
            System.out.println(mass[i] + "");
        }
    }
}
