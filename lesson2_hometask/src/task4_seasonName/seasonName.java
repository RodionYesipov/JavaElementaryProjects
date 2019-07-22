package task4_seasonName;

import java.util.Scanner;

/*
«1»: Ввести номер месяца и вывести название времени года.
*/
public class seasonName
    {

        public static void main(String[] args)
        {
            int month_num;

            Scanner s = new Scanner(System.in);

            System.out.println("Введите месяц:\n");
            month_num = s.nextInt();

            if(month_num >= 1 && month_num <= 12)
            {
                switch (month_num) {
                    case 12:
                    case 1:
                    case 2:
                        System.out.println("Зима");
                        break;
                    case 3:
                    case 4:
                    case 5:
                        System.out.println("Весна");
                        break;
                    case 6:
                    case 7:
                    case 8:
                        System.out.println("Лето");
                        break;
                    case 9:
                    case 10:
                    case 11:
                        System.out.println("Осень");
                        break;
                }
            }
            else    {
                        System.out.println("Месяц введен некорректно!");
                    }

        }

    }
