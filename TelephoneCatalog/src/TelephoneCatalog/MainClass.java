package TelephoneCatalog;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MainClass {

    public static void main(String[] args) throws IOException{
        //загрузка файла

            List<List<String>> records = new ArrayList<List<String>>();
            String filePath = "c:/Users/Rodion/Downloads/data-20170202-structure-20150209.csv";
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            String line;

            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                records.add(Arrays.asList(values));
            }
            //отчет об успешной загрузке файла
            System.out.println("База загружена из директории " + filePath);
            System.out.println(records.size() + " - кол-во загруженных записей!");

        //перемещение по меню
        TelephoneCatalog telCat = new TelephoneCatalog();
        Scanner scan = new Scanner(System.in);
        int choice;

        System.out.println("Введите 1 для отображения первых 10 записей справочника:");
        choice = scan.nextInt();
        telCat.showFirstRecords(records);


    }
}
