package String_hometask;

import java.util.Scanner;

//2) Дан String. Нужно вернуть  true, если она заканчивается на -  "ly".
public class task2 {
    static boolean stringChecker(String inputString){
        boolean result = false;
        String last2_symb = inputString.substring(inputString.length() - 2);

        if(last2_symb.equals("ly")) {
            return true;
        }
        else return false;
    }

    public static void main(String args[]) {

        Scanner s = new Scanner(System.in);

        System.out.println("Введите строку:");
        String inputString = s.nextLine();
        System.out.println("Строка заканчивается на ly?");

        if (stringChecker(inputString)) {
            System.out.println("Да");
        } else {
            System.out.println("Нет");
        }
    }
}
