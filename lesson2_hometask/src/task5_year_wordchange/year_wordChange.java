package task5_year_wordchange;

import java.util.Scanner;
/*
«2»: Ввести возраст человека (от 1 до 150 лет) и вывести его вместе с последующим словом «год», «года» или «лет».
Пример:

Введите возраст: 24
Вам 24 года

Введите возраст: 57
Вам 57 лет
*/
public class year_wordChange {

    public static void main(String[] args)
    {
        int age;

        Scanner s = new Scanner(System.in);

        System.out.println("Введите возраст:\n");
        age = s.nextInt();

        if(age >= 1 && age <= 150)
        {
            //для возраста 11-14, 111-114 - проставляем "лет"
            if(age%100 >= 11 && age%100 <= 14)
            {
                System.out.println(age + " лет");
            }
            else
            {
                switch (age % 10) {
                    case 0:
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                    case 9: System.out.println(age + " лет");break;
                    case 1: System.out.println(age + " год");break;
                    case 2:
                    case 3:
                    case 4:System.out.println(age + " года");break;
                }
            }
        }
        else    {
            System.out.println("Введите корректный возраст!");
        }

    }

}