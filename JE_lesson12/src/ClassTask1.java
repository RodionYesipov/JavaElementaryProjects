import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
Написать метод `String reverse(String s) {...}`.
Входящий параметр: s - строка которая состоит из слов через пробел
Метод должен вернуть слова в обратном порядке
Пример:
"man has dog" => "dog has man"
**/
public class ClassTask1 {
    private static String reverse(String input) {
        List<String> list = new ArrayList<>(Arrays.asList(input.split(" ")));
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = list.size() - 1; i >= 0; i--) {
            stringBuilder.append(list.get(i));
            if (i > 0) {
                stringBuilder.append(" ");
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        String input = "dog has man";

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter string:");
        input = scanner.nextLine();
        System.out.println("Reversed string:");
        System.out.println(reverse(input));
    }
}
