package String_hometask;

import java.util.Scanner;

//3)  Ввести n строк с консоли. Упорядочить и вывести строки в порядке возрастания   (убывания) значений их длины.
public class task3 {
    static void stringSort(String[] stringsMass){
        //упорядочивание
        boolean flag;

        do {
            flag = false;
            for (int i = stringsMass.length - 2; i >= 0; i--) {
                if (stringsMass[i + 1].length() < stringsMass[i].length()) {
                    String tempStr = stringsMass[i];
                    stringsMass[i] = stringsMass[i + 1];
                    stringsMass[i + 1] = tempStr;

                    flag = true;
                }
            }
        }
        while (flag);
        //вывод отсортированного массива
        System.out.println("\nВывод строк в порядке возрастания их длины");
        for (int i = 0; i < stringsMass.length; i++){
            System.out.println(stringsMass[i]);
        }
    }
    //
    public static void main(String args[]) {
        String []stringsMass = new String[4];
        Scanner s = new Scanner(System.in);

        System.out.println("Введите " + stringsMass.length + " строк(и) в консоли:");
        for(int i = 0; i < stringsMass.length; i++) {
            String inputString = s.nextLine();
            stringsMass[i] = inputString;
        }

        stringSort(stringsMass);
    }
}
