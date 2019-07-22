package homeTask10;
/*
заполнить матрицу из 8 строк и 5 столбцов случайными числами в интервале
[-10,10] и вывести ее на экран

1. Найти минимальный и максимальный элементы в матрице и их номера
2. Вывести на экран  строку, сумма элементов которой максимальна
 */
import java.util.Random;

public class homeTask10 {
    ////////////////////
    public static void main(String[] agrs) {
        int max_elem_value = -10000;
        int max_elem_X = -1;
        int max_elem_Y = -1;
        //
        int min_elem_value = 10000;
        int min_elem_X = -1;
        int min_elem_Y = -1;
        //
        int max_sum_string = -10000;
        int max_sum_string_num = -1;
        int curr_sum_string = 0;
        int hight = 5, width = 8;
        int matrix[][] = new int[hight][width];
        Random rand = new Random();

        for (int i = 0; i < hight; i++){
            for (int j = 0; j < width; j++){

                matrix[i][j] = rand.nextInt(10*2+1) - 10;
                //макс элемент в матрице
                if(matrix[i][j] > max_elem_value){
                    max_elem_value = matrix[i][j];
                    max_elem_X = i;
                    max_elem_Y = j;
                }
                //мин элемент в матрице
                if(matrix[i][j] < min_elem_value){
                    min_elem_value = matrix[i][j];
                    min_elem_X = i;
                    min_elem_Y = j;
                }
                //сумма элментов текущей строки
                curr_sum_string += matrix[i][j];
            }
            //проверяю, больше ли посчитанное значение суммы, которая уже есть в переменной
            if(curr_sum_string > max_sum_string){
                max_sum_string = curr_sum_string;
                max_sum_string_num = i;
            }
            //возвращаю сумму элементов текущей строки к дефолтному значению, для расчета суммы по след строке
            curr_sum_string = 0;
        }

        System.out.println("Сформированная матрица:");
        for (int i = 0; i < hight; i++){
            for (int j = 0; j < width; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println("\n");
        }

        //1. Найти минимальный и максимальный элементы в матрице и их номера
        System.out.println("Максимальный элемент: matrix[" + max_elem_X + "][" + max_elem_Y + "] = " + max_elem_value);
        System.out.println("Минимальный элемент: matrix[" + min_elem_X + "][" + min_elem_Y + "] = " + min_elem_value);

        //2. Вывести на экран  строку, сумма элементов которой максимальна
        System.out.println("Сумма элементов в строке " + max_sum_string_num + " максимальная и равна: " + max_sum_string);
        System.out.println("Элементы строки:");
        for (int j = 0; j < width; j++){
            System.out.print(matrix[max_sum_string_num][j] + " ");
        }
    }
}
