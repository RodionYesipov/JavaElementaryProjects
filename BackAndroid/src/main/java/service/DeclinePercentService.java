package service;

import bd.mapper.DeclinePercentDAO;
import bd.model.DeclinePercent;

import java.util.List;

public class DeclinePercentService {

    public static List<DeclinePercent> getdata(String dateStart, String dateEnd){
        return DeclinePercentDAO.getData(dateStart,dateEnd);
    }
}
