package extraTask3_mass;

import java.util.Random;

/*Создайте массив из 15 случайных целых чисел из отрезка [0;9]. Выведите массив на экран.
Подсчитайте сколько в массиве чётных элементов и выведете это количество на экран на отдельной строке.*/
public class extraTask3_mass {
    public static void main(String[] args) {
        Random rand = new Random();
        int bound_num = 9; // диапазон случайных чисел [0;9]
        int mass[] = new int[15];
        int cardinal_num = 0; // кол-во четных элементов

        for(int i = 0; i < mass.length; i++)
        {
            mass[i] = rand.nextInt(bound_num+1);
        }
        //////////////////////////////////////

        System.out.println("Generated massive:\n");

        for(int i = 0; i < mass.length; i++)
        {
            if(mass[i]%2 == 0)
            {
                cardinal_num++;
            }

            System.out.print(mass[i]+"  ");
        }

        System.out.print("\n" + "Кол-во четных элементов массива = " + cardinal_num);
    }
}
