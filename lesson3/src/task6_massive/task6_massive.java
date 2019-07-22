package task6_massive;

import java.util.Random;

public class task6_massive {
    public static void main(String[] args) {
        Random rand = new Random();
        int bound_num = 10; // диапазон случайных чисел [10;10]
        int mass[] = new int[10];
        int max_element, min_element,max_elem_index,min_elem_index;

        for(int i = 0; i < mass.length; i++)
        {
            mass[i] = rand.nextInt(bound_num*2 + 1) - bound_num;
        }
        //////////////////////////////////////
        //нахожу макс и мин элементы
        //присвоил значение первого элемента , в цикле уже сравниваю
        max_element = mass[0];
        min_element = mass[0];
        min_elem_index = 0;
        max_elem_index = 0;

        System.out.println("Generated massive:\n");

        for (int i = 0; i < mass.length; i++)
        {
            System.out.print(mass[i]+"  ");
            //max element
            if(mass[i] > max_element)
            {
                max_element = mass[i];
                max_elem_index = i;
            }
            //min element
            if(mass[i] < min_element)
            {
                min_element = mass[i];
                min_elem_index = i;
            }
        }

        System.out.println("\nMax element mass[" + (max_elem_index+1) + "] = "+max_element);
        System.out.println("Min element mass[" + (min_elem_index+1) + "] = "+min_element);
    }
}
