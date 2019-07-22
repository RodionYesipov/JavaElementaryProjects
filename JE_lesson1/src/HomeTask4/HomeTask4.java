package HomeTask4;
/*
4) Написать метод который вернет String
в которой будут в одну строку числа от 1 до 30.
Каждое число при этом взять в круглые скобки ()
 */

public class HomeTask4 {

    public static String output1To30InBrackets(){
        String outputResult;
        outputResult = "";

        for (int i = 1; i <= 30; i++) {
            outputResult += "("+i+")";
        }

        return outputResult;
    }

    public static void main(String[] args){
        System.out.println(output1To30InBrackets());
    }
}
