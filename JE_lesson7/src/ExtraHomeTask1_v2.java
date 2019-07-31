import java.io.BufferedReader;
import java.io.FileReader;
import java.util.regex.Pattern;

/**
 1. Не используя методы String - contains, indexOf, 	lastIndexOf определить входит ли подстрока в строку.
 1.1. Найти все вхождения подстроки в строку.
 Подумать как оптимизировать код для того чтобы он быстро выполнялся для больших строк(книга).
 **/
public class ExtraHomeTask1_v2 {

    private static boolean findSubstring(String inStr, String subStr) {
        boolean findFL = false;
        char[] substrToFind = subStr.toCharArray();
        for (int i = 0; i < inStr.length(); i++) {
            if (inStr.charAt(i) == substrToFind[0]) {
                findFL = true;
                for (int j = 1; j < substrToFind.length; j++) {
                    if (inStr.charAt(i + j) != substrToFind[j]) {
                        findFL = false;
                        break;
                    }
                }
            }
            //found word
            if (findFL) {
                break;
            }
        }
        return findFL;
    }

    public static void main(String[] args) {
        String filePath = "C:/Users/Rodion/IdeaProjects/JE_lesson7/src/book.txt";
        StringBuilder fileToStr = new StringBuilder();
        try {
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            try {
                String getLine;
                while ((getLine = br.readLine()) != null) {
                    fileToStr.append(getLine).append("\n");
                }
            } finally {
                br.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        ////
        String needSubStr = "Камрит";
        System.out.println(findSubstring(fileToStr.toString(), needSubStr));
    }
}
