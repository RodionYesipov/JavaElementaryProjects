/**
* 1. Число Фибоначи
 * написать метод который возвращает N-ное число фибоначи, по правилу:
 * F(0) = 0, F(1) = 1
 * F(N) = F(N - 1) + F(N - 2)
* */

public class HomeTask1 {
    private static int fibonachiCall(int index) {
        if (index <= 0) {
            return 0;
        } else if (index == 1) {
            return 1;
        } else if (index == 2) {
            return 1;
        } else {
            return fibonachiCall(index - 1) + fibonachiCall(index - 2);
        }
    }

    public static void main(String[] args) {
        int endIndex = 10;
        System.out.println("Fibonachi series up to index " + endIndex);
        for (int i = 0; i <= endIndex; i++) {
            System.out.print(fibonachiCall(i) + " ");
        }

    }
}
