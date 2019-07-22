package homeTask7;
//написать программу с функциями для просчета среднего арифметического массива для различных типов данных
import java.util.Random;

public class homeTask7 {
    //для целочисленного массива
    public static double averageOfArray(int array[]) {
        int sum = 0;

        //считаю сумму элементов массива
        for(int i = 0; i < array.length; i++){
            sum += array[i];
        }

        double result = 1.00*sum/(1.00*array.length);

        return result;
    }

    //для массива вещественных чисел
    public static float averageOfArray(float array[]) {
        float sum = 0;

        //считаю сумму элементов массива
        for(int i = 0; i < array.length; i++){
            sum += array[i];
        }

        return sum/array.length;
    }
    ////////////////////
    public static void main(String[] agrs) {
        Random rand = new Random();
        int array1[] = new int[10];
        float array2[] = new float[10];

        for(int i = 0; i < 10; i++){
            array1[i] = rand.nextInt(11);
            array2[i] = rand.nextFloat()*10;
        }

        System.out.println("Первый массив");
        //Первый массив
        for(int i = 0; i < array1.length; i++){
            System.out.print(array1[i] + " ");
        }

        System.out.println("\nСреднее арифметическое = " + averageOfArray(array1));

        System.out.println("\n\nВторой массив");
        //Второй массив
        for(int i = 0; i < array2.length; i++){
            System.out.print(array2[i] + " ");
        }

        System.out.println("\nСреднее арифметическое = " + averageOfArray(array2));
    }
}
