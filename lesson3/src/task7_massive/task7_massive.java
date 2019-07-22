package task7_massive;
/*Задача:
«1» Ввести с клавиатуры массив из 5 элементов, умножить все элементы на 2 и вывести  полученный массив на экран.
*/
import java.util.Random;
import java.util.Scanner;

public class task7_massive {
    public static void main(String[] args) {
        //Random rand = new Random();
        int N = 5;
        int A[] = new int[N];
        int a;
        Scanner s = new Scanner(System.in);

        for(int i = 0; i < N; i++)
        {
            A[i] = s.nextInt()*2;
            System.out.println(A[i] + "");
        }
    }
}
