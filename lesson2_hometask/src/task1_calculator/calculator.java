package task1_calculator;
import java.util.Scanner;

/*
«1»: Создать калькулятор: Пользователь вводит 1-ое число, потом 2-ое число,
а потом операцию, которую хочет выполнить (+ - * / ).
Калькулятор выдает результат.
*/
public class calculator {

        public static void main(String[] args)
        {
            int first_num;
            int second_num;
            char oper_type;
            //double result_num;

            Scanner s = new Scanner(System.in);
            System.out.println("Введите первое число\n");
            first_num = s.nextInt();

            System.out.println("Введите второе число\n");
            second_num = s.nextInt();

            System.out.println("Введите операцию, которую хотите выполнить(+,-,/,*):\n");
            oper_type = s.next().charAt(0);
            //Если пользователь ввел некорректный тип операции, вывожу сообщение об этом
            if  (
                    oper_type != '+'
                            &&
                            oper_type != '-'
                            &&
                            oper_type != '/'
                            &&
                            oper_type != '*'
            )
            {
                System.out.println("Некорректный тип операции! Введите оперцию из списка: +,-,/,*");
            }
            else    {
                switch(oper_type)
                {
                    case '+':
                        System.out.println("Результат:\n"+(first_num + second_num));
                        break;

                    case '-':
                        System.out.println("Результат:\n"+(first_num - second_num));
                        break;

                    case '/':
                        System.out.println("Результат:\n"+(1.0*first_num/(1.0*second_num))); //сделал неявное преобразование
                                                                                            //чтобы не отсекалась дробная часть
                        break;

                    case '*':
                        System.out.println("Результат:\n"+(first_num*second_num));
                        break;
                }
            }
        }

}
