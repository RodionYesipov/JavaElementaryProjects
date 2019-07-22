import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
* 4*. Написать рекурсивный(!!!) метод который выводит все перестановки строки.
Например для строки abc: abc, acb, bac, bca, cab, cba
* */
public class Task4 {
    static void strCharCombinations(String initialString  , int start ) {
        if(initialString.length() == start) {System.out.println(initialString);}
        char[] initialStrArray = initialString.toCharArray();

        for (int i = start; i < initialStrArray.length; i++) {
            char temp = initialStrArray[i];
            initialStrArray[i] = initialStrArray[start];
            initialStrArray[start] = temp;
            strCharCombinations(new String(initialStrArray),start+1);
        }

    }

    public static void main(String[] args) {
        String str = "abc";
        strCharCombinations(str,0);
    }


}
