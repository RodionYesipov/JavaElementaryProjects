package extraTask4_mass;
/*Создайте массив из 8 случайных целых чисел из отрезка [1;10]. Выведите массив на экран в строку.
Замените каждый элемент с нечетным индексом на ноль. Снова выведете массив на экран на отдельной строке.*/
import java.util.Random;

public class extraTask4_mass {
    public static void main(String[] args) {
        Random rand = new Random();
        int bound_num = 10; // диапазон случайных чисел [1;10]
        int mass[] = new int[8];

        for(int i = 0; i < mass.length; i++)
        {
            mass[i] = rand.nextInt(bound_num)+1;
        }
        //////////////////////////////////////

        System.out.println("Generated massive:\n");

        for(int i = 0; i < mass.length; i++)
        {

            System.out.print(mass[i]+"  ");
        }
        ///////////////
        System.out.print("\n");

        for(int i = 0; i < mass.length; i++)
        {
            if(i%2 != 0)
            {
                mass[i] = 0;
            }
            System.out.print(mass[i]+"  ");
        }
    }
}
