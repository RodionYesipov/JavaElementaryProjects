package Exceptions_hometask;

import java.io.FileWriter;
import java.io.IOException;
//2) обработка в блоке try с логическим завершением

public class task2 {
    public static void main(String[] args) {
        try {
            FileWriter fileWriter = new FileWriter("out.txt");
            fileWriter.close();
            fileWriter.write("Hello World");
        } catch (IOException e) {
            System.out.println("ALARM!!! Caught an IOException");
        }
    }
}
