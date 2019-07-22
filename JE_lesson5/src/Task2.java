import java.util.ArrayList;
import java.util.List;

/**
2. Написать метод который проверяет число простое или нет. Если нет вывести все его делители.
* */

public class Task2 {
    private static void primeNumerChecker(int number){
        int deviderCount = 0;
        List deviderList = new ArrayList();
        for (int i = 2; i <= number; i++) {
            if(number % i == 0){
                deviderCount++;
                deviderList.add(i);
            }
        }

        if(deviderCount > 1){
            System.out.println("The number is not prime, deviders list:\n" + deviderList.toString());
        } else {
            System.out.println("The number is prime!");
        }
    }

    public static void main(String[] args) {
        primeNumerChecker(10);
    }
}
