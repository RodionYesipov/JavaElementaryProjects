package homeTask6;
//Составить функцию, которая определяет, верно ли, что в числе все цифры стоят по возрастанию
import java.util.Scanner;

public class homeTask6 {
    public static boolean increaseOfDigits(int number) {
        int count = 0;
        int number_copy = number;

        //считаю кол-во знаков числа
        while(number != 0){
            count++;
            number /= 10;
        }

        //заношу цифры числа в массив
        int mass_digits[] = new int[count];
        for(int i = 0; i < count; i++){
            mass_digits[count-i-1] = number_copy%10;
            number_copy /= 10;
        }

        //последовательность цифр возрастающая?
        //предполжим что да
        boolean increase_fl = true;

        for (int i = 0; i < mass_digits.length - 1; i++){
            if(mass_digits[i] >=  mass_digits[i+1]){
                increase_fl = false;
                break;
            }
        }


        return increase_fl;
    }

    ////////////////////
    public static void main(String[] agrs) {
        Scanner s = new Scanner(System.in);
        int num;

        System.out.println("Введите число:");
        num = s.nextInt();

        if(increaseOfDigits(num)) {
            System.out.println("Цифры стоят строго по возрастанию");
        }
        else {
            System.out.println("Цифры не стоят строго по возрастанию");
        }
    }
}
