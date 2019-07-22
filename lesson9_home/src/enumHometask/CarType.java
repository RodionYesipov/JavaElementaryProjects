package enumHometask;

public enum CarType {
    SEDAN(
            new String[]{"Lada Granta", "Volvo V60", "Renault Logan", "Lifan Solano", "Mazda 3"},
            new double[]{1.5, 2.0, 1.4, 1.1, 1.5}
    ),
    LIMOUSINE(
            new String[]{"ЗИЛ-41047", "Mercedes-Benz W100", "Lincoln Town Car","Chrysler Limo Absolute","Hummer H3 Limo"},
            new double[]{2.5, 2.0, 2.4, 2.1, 2.7}
    ),
    SPORTCAR(
            new String[]{"Mazda MX-5", "Mclaren 570GT", "Bugatti Vision Gran Turismo", "Acura NSX","BMW M8"},
            new double[]{2.0, 5.2, 7.2, 4.0, 5.5}
    ),
    CROSSOVER(
            new String[]{"Renault Duster", "Chevrolet Niva", "Nissan Terrano","Mazda CX-5","Honda CR-V"},
            new double[]{1.5, 1.4, 2.4, 2.5, 2.4}
    ),
    HATCHBACK(
            new String[]{"Skoda Fabia", "KIA Ceed", "Renault Sandero","Renault Clio","Audi A3"},
            new double[]{1.2, 1.4, 1.4, 1.0, 2.0}
    );

    String []carBrand = new String[5];
    double[] engineVolume = new double[5];

    CarType(String[] carBrand, double[] engineVolume){
        this.carBrand = carBrand;
        this.engineVolume = engineVolume;
    }

    //получение всех марок авто
    String[] getAllCarBrand(String carType){
        return CarType.valueOf(carType).carBrand;
    }

    // макс объем двигателя
    double maxEngineVolume(String carType){
        double maxVolume;
        maxVolume = -1.0;

        for(int i = 0; i < CarType.valueOf(carType).carBrand.length; i++){
            if(CarType.valueOf(carType).engineVolume[i] > maxVolume){
                maxVolume = CarType.valueOf(carType).engineVolume[i];
            }
        }
        return maxVolume;
    }

    // мин объем двигателя
    double minEngineVolume(String carType){
        double minVolume;
        minVolume = 9999.0;

        for(int i = 0; i < CarType.valueOf(carType).carBrand.length; i++){
            if(CarType.valueOf(carType).engineVolume[i] < minVolume){
                minVolume = CarType.valueOf(carType).engineVolume[i];
            }
        }
        return minVolume;
    }
}
