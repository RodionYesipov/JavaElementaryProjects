package Exceptions_hometask;

import java.io.FileWriter;
import java.io.IOException;
//3) должен присутствовать блок finally

public class task3 {
    public static void main(String[] args) {
        try {
            FileWriter fileWriter = new FileWriter("out.txt");
            fileWriter.close();
            fileWriter.write("Hello World");
        } catch (IOException e) {
            System.out.println("ALARM!!! Caught an IOException");
        }
        finally {
            System.out.println("Output to file finished!");
        }
    }
}
