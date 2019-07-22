package hometask2_mass;
/*«2» Ввести c клавиатуры массив из 5 элементов, найти среднее арифметическое всех элементов массива.

Пример:

Введите пять чисел:

4 15 3 10 14

среднее арифметическое 9.200
*/
import java.util.Scanner;

public class hometask2_mass {
    public static void main(String[] args) {
        //Random rand = new Random();
        int mass[] = new int[5];
        int summa = 0;

        Scanner s = new Scanner(System.in);

        System.out.println("Enter " + mass.length + " elements of massive:");
        for(int i = 0; i < mass.length; i++)
        {
            mass[i] = s.nextInt();
            summa += mass[i];
        }

        System.out.println("Average = "+ 1.0*summa/mass.length);
    }
}
