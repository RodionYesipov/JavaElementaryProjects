package homeTask8;
//Написать программу с функциями для просчета суммы квадратов двух чисел
//для различных типов данных(int,float)
import java.util.Random;

public class homeTask8 {
    //для целых чисел
    public static int squareOf2Numbers(int num1,int num2) {
        int result;

        result = num1*num1 + num2*num2;

        return result;
    }

    //для вещественных чисел
    public static float squareOf2Numbers(float num1,float num2) {
        float result;

        result = num1*num1 + num2*num2;

        return result;
    }
    ////////////////////
    public static void main(String[] agrs) {

        Random rand = new Random();

        int num1_int, num2_int;
        float num1_float, num2_float;

        num1_int = rand.nextInt(11);
        num2_int = rand.nextInt(11);
        num1_float = rand.nextFloat()*10;
        num2_float = rand.nextFloat()*10;

        System.out.println("Первая пара чисел: " + num1_int + " и " + num2_int);
        System.out.println("Сумма их квадратов: " + squareOf2Numbers(num1_int,num2_int));

        System.out.println("\nВторая пара чисел: " + num1_float + " и " + num2_float);
        System.out.println("Сумма их квадратов: " + squareOf2Numbers(num1_float,num2_float));
    }
}
