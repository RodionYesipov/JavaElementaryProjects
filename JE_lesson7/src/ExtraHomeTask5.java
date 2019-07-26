import java.util.ArrayList;
import java.util.List;

/**
 Напишите программу которая определяет, является ли введенное число простым,
 и если нет то выводит его в виде произведения простых множителей: 12 = 2*2*3.
* */

public class ExtraHomeTask5 {
    private static boolean isPlainNumber(int givenNumber){
        List delimList = new ArrayList();

        for (int i =2; i < givenNumber; i++) {
            if (givenNumber > 1) {
                if (givenNumber % i == 0) {
                    delimList = delimList(givenNumber);
                    break;
                }
            }
        }

        if(delimList.isEmpty()){
            return true;
        }
        System.out.println(delimList);
        return false;
    }
    /////////
    private static List delimList(int inNumber){
        List outList = new ArrayList();

        for (int i = 2; i <= inNumber ; i++) {
            if(inNumber % i == 0) {
                inNumber /= i;
                outList.add(i);
                i = 1;
            }
        }
        return outList;
    }

    public static void main(String[] args) {
        int givenNumber = 26;
        System.out.println("Is the number " + givenNumber + " prime?");
        System.out.println(isPlainNumber(givenNumber));

    }
}
