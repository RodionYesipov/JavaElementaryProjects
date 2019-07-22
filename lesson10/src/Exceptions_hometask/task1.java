package Exceptions_hometask;

import java.io.FileWriter;
import java.io.IOException;

//1) в программе должны перебрасываться через метод без обработки - для checked

public class task1 {
    public static void main(String[] args) throws IOException {

        FileWriter fileWriter = new FileWriter("out.txt");
        fileWriter.close();
        fileWriter.write("Hello World");

        System.out.println("Программа работает успешно!");
    }
}
