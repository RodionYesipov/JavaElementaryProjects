import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
* 2. Задан текстовый файл. Вывести сколько в нём: a) строк b) слов c) символов
* */

public class HomeTask2 {
    private static int wordsCounter(String str){
        int wordCounter = 0;
        if (str.length() != 0) {
            wordCounter++;
            for (int i = 0; i < str.length(); i++) {
                if(str.charAt(i) == ' '){
                    wordCounter++;
                }
            }
        }

        return wordCounter;
    }
    /////////////
    public static void main(String[] args) {
        String filePath = "D:/test1.txt";
        StringBuilder fileToStr = new StringBuilder();
        int rowCount = 0;
        int symbolsNum = 0;
        int wordsNum = 0;
        try {
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            try {
                String getLine;
                while ((getLine = br.readLine()) != null) {
                    fileToStr.append(getLine);
                    symbolsNum += getLine.length();
                    wordsNum += wordsCounter(getLine.toString());
                    rowCount++;
                }
            } finally {
                br.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("rowCount = " + rowCount);
        System.out.println("symbols number = " + symbolsNum);
        System.out.println("words number = " + wordsNum);

    }


}





