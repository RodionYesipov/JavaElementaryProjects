package extraTask5_mass;
/*Создайте 2 массива из 5 случайных целых чисел из отрезка [0;5] каждый,
выведите массивы на экран в двух отдельных строках.
Посчитайте среднее арифметическое элементов каждого массива и сообщите,
для какого из массивов это значение оказалось больше (либо сообщите, что их средние арифметические равны).*/
import java.util.Random;

public class extraTask5_mass {
    public static void main(String[] args) {
        Random rand = new Random();
        int bound_num = 5; // диапазон случайных чисел [0;5]
        int mass1[] = new int[5];
        int mass2[] = new int[5];
        double average1 = 0.00, average2 = 0.00;

        for(int i = 0; i < mass1.length; i++)
        {
            mass1[i] = rand.nextInt(bound_num+1);
            mass2[i] = rand.nextInt(bound_num+1);
        }
        //////////////////////////////////////
        System.out.println("Generated massives:\n");

        for(int i = 0; i < mass1.length; i++)
        {

            System.out.print(mass1[i]+"  ");
        }
        ///////////////
        System.out.print("\n");

        for(int i = 0; i < mass2.length; i++)
        {
            System.out.print(mass2[i]+"  ");
        }
        //average

        for(int i = 0; i < mass1.length; i++)
        {
            average1 += mass1[i];
            average2 += mass2[i];
        }
        //т.к. размеры массивов равны, знаменатели при расчете среднего арифм равны,
        //поэтому можно считать что ср арифм больше у того массива, у которого сумма элементов больше
        if(average1 > average2){
            System.out.println("\nСредн. арифм. первого массива больше");
        }
        else if(average2 > average1){
            System.out.println("\nСредн. арифм. второго массива больше");
        }
        else {
            System.out.println("\nСредн. арифм. массивов равны");
        }
    }
}
