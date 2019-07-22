import java.util.*;

/**
 написать метод который принимает 2 строки - a, b. Метод должне вернуть количество символов которые у них различаются.
 Если строки разной длины то вернуть -1.
 Примеры:

 a="asdf", b="qwerty" => -1
 a="abb", b="bba" => 0
 a="abc", b="dca" => 1
 a="aaa", b="fga" => 2
 a="abc", b="dfg" => 3
* */
public class ExtraTask {

    private static int differentSymbNumber(String a, String b) {
        if (a.length() == b.length()) {
            Set setString1 = new HashSet();
            Set setString2 = new HashSet();

            for (int i = 0; i < a.length(); i++) {
                setString1.add(a.charAt(i));
                setString2.add(b.charAt(i));
            }
            List strList1 = new ArrayList();
            strList1.addAll(setString1);

            for (int i = 0; i < strList1.size(); i++) {
                if (setString2.contains(strList1.get(i))) {
                    setString2.remove(strList1.get(i));
                    strList1.remove(i);
                    i--;
                }
            }

            return Math.max(strList1.size(), setString2.size());
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(differentSymbNumber("abc","dfg"));
    }
}
