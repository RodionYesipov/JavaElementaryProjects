import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 2. Заданы строка с выражением состоящая из чисел и знаков плюс/минус разделенным пробелом, например "123 + 7 - 52".
 Вычислить значение выражения.
 2.1. Также в выражении могут присутстовать знаки умножить и разделить.
 Вычислить значение строки с учетом приоритета операторов.
* */
public class ExtraHomeTask2 {
    private static double mathOper(List inStr, int index, String priorOper){
        double num1 = Double.parseDouble(inStr.get(index - 1).toString());
        double num2 = Double.parseDouble(inStr.get(index + 1).toString());
        int result;

        switch (priorOper){
            case "*": return num1 * num2;
            case "/": return num1 * num2;
            case "+": return num1 + num2;
            case "-": return num1 - num2;
        }

        return 0;
    }

    private static double calsExpression(String givenExpression){
        List splitedStr = new ArrayList(Arrays.asList(givenExpression.split(" ")));
        List priorOperations = new ArrayList(Arrays.asList(new String("*,/,+,-").split(",")));

        double tmp;
        int index;
        String priorOper;

        for (int i = 0; i < priorOperations.size(); i++) {
            priorOper = priorOperations.get(i).toString();
            index = splitedStr.indexOf(priorOper);

            while (index != -1) {
                tmp = mathOper(splitedStr, index, priorOper);

                splitedStr.remove(index);
                splitedStr.remove(index);
                splitedStr.set(index - 1, tmp);
                index = splitedStr.indexOf(priorOper);
            }
        }
        return Double.parseDouble(splitedStr.get(0).toString());
    }


    public static void main(String[] args) {
        String givenExp = "123 + 7 * 52 + 3 / 5";

        System.out.println(givenExp + " = " + calsExpression(givenExp));

    }
}
