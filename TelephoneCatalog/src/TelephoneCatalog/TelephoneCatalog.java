package TelephoneCatalog;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TelephoneCatalog {

    //вывод первых записей из базы
    public void showFirstRecords(List<List<String>> inputRecord){
        ////////////////////
        for(int i = 0; i <= 10; i++){
            int recordLength = 0;

            for(int j =0; j < inputRecord.get(i).size(); j++){
                //нахожу макс длину ячейки в столбце
                int cellMaxLength = 0;

                for(int n = 0; n <= 10; n++){
                    if(inputRecord.get(n).get(j).length() > cellMaxLength){
                        cellMaxLength = inputRecord.get(n).get(j).length();
                    }
                }

                System.out.print(inputRecord.get(i).get(j));
                //добавляю пробелы где длина ячейки меньше максимальной по столбцу
                for(int m = 0; m <= cellMaxLength - inputRecord.get(i).get(j).length(); m++){
                    System.out.print(' ');
                }

                System.out.print("||");
                recordLength += inputRecord.get(i).get(j).length() + (cellMaxLength - inputRecord.get(i).get(j).length()) + 2;
            }
            System.out.print("\n");
            for (int k = 0; k < recordLength; k++) {
                System.out.print("-");
            }
            System.out.print("\n");
        }
    }
}
