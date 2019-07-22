package extraTask2_mass;
/*Создайте массив из всех нечётных чисел от 1 до 99, выведите его на экран в строку,
а затем этот же массив выведите на экран тоже в строку,
но в обратном порядке (99 97 95 93 … 7 5 3 1).*/
public class extraTask2_mass {
    public static void main(String[] args) {

        int range_start = 1;
        int range_end = 99;
        int elem_num = 0;

        //считаю кол-во нечетных чисел в диапазоне
        for(int i = range_start; i <= range_end; i++)
        {
            if(i%2 != 0)
            {
                elem_num++;
            }
        }
        /////////////////////
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

        System.out.print("\n");

        for(int j = mass.length - 1; j >= 0; j--)
        {
            System.out.print(mass[j] + " ");
        }
    }
}
