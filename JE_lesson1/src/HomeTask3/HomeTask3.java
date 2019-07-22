package HomeTask3;

import java.util.Random;

/*
3) Заполнить массив из 10 элементов случайными целыми числами
от 10(включительно) до 20(включительно). Вывести среднее арифметическое.
* */
public class HomeTask3 {
    public static void main(String[] args) {

        int elementsNum = 10; //number of elements at massive
        int mass[] = new int[elementsNum];
        int elementsSum = 0;
        int minBound = 10;
        int maxBound = 20;
        Random rand = new Random();

        System.out.println("Generated massive:");
        for (int i = 0; i < elementsNum; i++) {
            mass[i] = rand.nextInt(maxBound - minBound + 1) + minBound;
            elementsSum += mass[i];
            System.out.print(mass[i] + " ");
        }

        System.out.println("\nAverage = " + 1.0*elementsSum/elementsNum);
    }
}
