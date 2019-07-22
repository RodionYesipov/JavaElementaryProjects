package enumHometask;

import java.util.Arrays;
import java.util.Scanner;

public class enumResult {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);

        System.out.print("Введите тип авто:");
        System.out.println(Arrays.toString(CarType.values()));

        String carTypeFromConsole = s.nextLine();

        System.out.println("Макс. объем двигателя для этого типа: " + CarType.valueOf(carTypeFromConsole).maxEngineVolume(carTypeFromConsole));
        System.out.println("Мин. объем двигателя для этого типа: " + CarType.valueOf(carTypeFromConsole).minEngineVolume(carTypeFromConsole));

        //вывод всех марок по типу авто
        String []carBrandMass = new String[CarType.valueOf(carTypeFromConsole).carBrand.length];

        carBrandMass = CarType.valueOf(carTypeFromConsole).getAllCarBrand(carTypeFromConsole);

        System.out.println("\nСписок всех марок типа авто " + carTypeFromConsole + ":");

        for(int i = 0; i < CarType.valueOf(carTypeFromConsole).carBrand.length; i++){
            System.out.println(carBrandMass[i]);
        }

        //Вывести все модели, всех типов
        CarType []allCarType = CarType.values();
        String []allCarTypeStr = new String[CarType.values().length];

        for(int i = 0; i < CarType.values().length; i++){
            allCarTypeStr[i] = allCarType[i].toString();
        }
       // System.out.println(CarType.values());

        System.out.println("\nВывод всех моделей всех типов:");
        for(int i = 0; i < CarType.values().length; i++){
            System.out.println("\n" + allCarTypeStr[i]);

            for(int j = 0; j < CarType.valueOf(allCarTypeStr[i]).carBrand.length; j++){
                System.out.println(CarType.valueOf(allCarTypeStr[i]).carBrand[j]
                        + "|Engine volume " + CarType.valueOf(allCarTypeStr[i]).engineVolume[j]);
            }
        }
    }
}