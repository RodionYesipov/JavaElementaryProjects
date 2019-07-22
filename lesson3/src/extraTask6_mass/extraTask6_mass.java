package extraTask6_mass;
/*Создайте массив из 4 случайных целых чисел из отрезка [10;99], выведите его на экран в строку.
Определить и вывести на экран сообщение о том, является ли массив строго возрастающей последовательностью.*/
import java.util.Random;

public class extraTask6_mass {
    public static void main(String[] args) {
        Random rand = new Random();
        int bound_num = 99; // диапазон случайных чисел [10;99]
        int mass[] = new int[4];
        int up_progr_FL = 0; //флаг возрастающей последовательности

        for(int i = 0; i < mass.length; i++)
        {
            mass[i] = rand.nextInt(bound_num - 10 + 1) + 10;
        }
        //////////////////////////////////////
        System.out.println("Generated massives:\n");

        for(int i = 0; i < mass.length; i++)
        {
            System.out.print(mass[i]+"  ");
        }
        ////////////
        for(int i = 1; i < mass.length; i++)
        {
            if(mass[i] <= mass[i-1])
            {
                up_progr_FL++;
            }
        }
        //
        if(up_progr_FL == 0)
        {
            System.out.println("\nПоследовательность строго возрастает");
        }
        else {
            System.out.println("\nПоследовательность не строго возрастающая");
        }
    }
}
