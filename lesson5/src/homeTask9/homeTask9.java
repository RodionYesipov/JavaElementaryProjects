package homeTask9;
//Заполнить массив из 10 элементов случайными не повторяющимися значениями
import java.util.Random;

public class homeTask9 {
    //для целых чисел
    public static void uniqueRandom(int arraySize, int array[]) {
        Random rand = new Random();

        boolean repeat_fl = false;

        do{
            repeat_fl = false;
            array[arraySize-1] = rand.nextInt(30);

            //повторяем генерацию числа, пока не сгенерится уникальное
            for(int i = (arraySize-1)+1; i < array.length; i++){
                if(array[arraySize-1] == array[i]){
                    repeat_fl = true;
                }
            }
        }
        while (repeat_fl);

        //рекурсивно перемещаемся по массиву справа налево
        if (arraySize > 1) {
            uniqueRandom(arraySize - 1, array);
        }
    }

    ////////////////////
    public static void main(String[] agrs) {

        int arrayIn[] = new int[10];

        uniqueRandom(arrayIn.length,arrayIn);

        for(int i = 0; i < arrayIn.length; i++){
            System.out.print(arrayIn[i] + " ");
        }
    }
}
