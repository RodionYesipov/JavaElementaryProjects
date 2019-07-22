

package task2_leap_year;

import java.util.Scanner;
/*
«2»: Дано натуральное число n.  Определить, является ли год с таким номером високосным.
(Год является високосным в двух случаях: либо он кратен 4, но при этом не кратен 100, либо кратен 400.
Год не является високосным, если он не кратен 4, либо он кратен 100, но при этом не кратен 400).

*/

public class leap_year {

    public static void main(String[] args)
    {
        double year_num;

        Scanner s = new Scanner(System.in);
        System.out.println("Введите год:\n");
        year_num = s.nextInt();

        if  (
                (
                    (year_num%4 == 0)&&(year_num%100 != 0)
                )
            ||
                (year_num%400 == 0)
            )
        {
            System.out.println("Високосный год!");
        }
        else {
            System.out.println("Не високосный год!");
        }
    }

}
