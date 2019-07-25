import java.util.*;

/**
1. Создать 2мерный массив (матрица) M*N и заполнить его случайными числами.
Отсортировать числа по возрастанию, чтобы с левом верхнем углу было самое маленькое число,
справа от него следующее по значению, итд, в правом нижнем углу самое большое.
* */

public class HomeTask1 {

    public static void main(String[] args) {
        Random rand = new Random();
        int M = 4;
        int N = 4;
        int[][] arr = new int[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                arr[i][j] = rand.nextInt(15);
                System.out.print(" " + arr[i][j]);
            }
            System.out.print("\n");
        }

        //sort
        int[] plainArr = new int[M*N];
        int newIndex = 0;

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                plainArr[newIndex] = arr[i][j];
                newIndex++;
            }
        }
        Arrays.sort(plainArr);

        newIndex = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                arr[i][j] = plainArr[newIndex];
                newIndex++;
            }
        }

        System.out.println("Sorted matrix:\n");
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(" " + arr[i][j]);
            }
            System.out.print("\n");
        }

    }
}