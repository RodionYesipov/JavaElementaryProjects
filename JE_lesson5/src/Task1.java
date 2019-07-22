/**
1. Есть поле из клеток по средине которого находится робот.
Робот умеет выполнять 4 команды: двигаться на 1 клетку в сторону: R (right), L (left), U (up), and D (down).
Задана строка из движений робота например "UUDLDR".
Написать метод который вернет true если робот вернется в ту же клетку с которой начал.
Input: "UD"
Output: true

Input: "LL"
Output: false
**/
public class Task1 {
    private static boolean isRobotReturnedTheSameCell(String path) {
        char[] robotSteps = path.toCharArray();
        int verticalMove = 0;
        int horizontalMove = 0;
        for (int i = 0; i < robotSteps.length; i++) {
            switch (robotSteps[i]) {
                case 'U':
                    verticalMove++;
                    break;
                case 'D':
                    verticalMove--;
                    break;
                case 'L':
                    horizontalMove++;
                    break;
                case 'R':
                    horizontalMove--;
                    break;
                default:
                    break;
            }
        }
        if (verticalMove == 0 && horizontalMove == 0) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(isRobotReturnedTheSameCell("UUDLDR"));
    }
}
