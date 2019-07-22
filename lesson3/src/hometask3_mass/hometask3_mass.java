package hometask3_mass;
/*«3»: Написать программу, которая выводит содержимое массива наоборот.

Пример:

Введите пять чисел:

4 15 3 10 14

вывод на экран массива «наоборот»

14 10 3 15 4
*/
import java.util.Scanner;

public class hometask3_mass {
    public static void main(String[] args) {
        //Random rand = new Random();
        int mass[] = new int[5];
        int summa = 0;

        Scanner s = new Scanner(System.in);

        System.out.println("Enter " + mass.length + " elements of massive:");
        for(int i = 0; i < mass.length; i++)
        {
            mass[i] = s.nextInt();
        }
//вывод на экран
        System.out.println("Backward massive:\n");
        for(int j = mass.length -1 ; j >= 0; j--)
        {
            System.out.print(mass[j] + "  ");
        }
    }
}
