package Exceptions_hometask;

import java.io.FileWriter;
import java.io.IOException;
//4) попробовать написать return в finally и описать результат

public class task4 {
    static String IOtest(){
        try {
            FileWriter fileWriter = new FileWriter("out.txt");
            fileWriter.close();
            fileWriter.write("Hello World");
        } catch (IOException e) {
            System.out.println("ALARM!!! Caught an IOException");
        }
        finally {
            System.out.println("Output to file finished!");
            return "Output is finished";
        }
    }


    public static void main(String[] args) {
        String IOtest_result = IOtest();
        System.out.println("The result of IOtest method - " + IOtest_result);
    }
}
