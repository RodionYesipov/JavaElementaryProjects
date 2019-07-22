package extraTask1_mass;
/*Создайте массив из всех чётных чисел от 2 до 20 и выведите элементы массива на экран сначала в строку,
отделяя один элемент от другого пробелом, а затем в столбик (отделяя один элемент от другого началом новой строки).
Перед созданием массива подумайте, какого он будет размера.*/
public class extraTask1_mass {
    public static void main(String[] args) {

        int range_start = 2;
        int range_end = 20;
        int elem_num = (range_end-range_start)/2 + 1; //кол-во элементов, которое будет в массиве(включая границы)
        int mass[] = new int[elem_num];

        for(int i = 0; i < elem_num; i++)
        {
           mass[i] = range_start;
           range_start += 2;
        }
        ///////////////////
        for(int j = 0; j < mass.length; j++)
        {
            System.out.print(mass[j] + " ");
        }

        for(int j = 0; j < mass.length; j++)
        {
            System.out.print("\n" + mass[j]);
        }
    }
}
