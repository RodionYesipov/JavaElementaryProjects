package service;


import bd.mapper.Reason_KC_DAO;
import bd.model.Reason_KC;
import java.util.List;

public class Reason_KC_Service {

    public static List<Reason_KC> getdata(String dateStart, String dateEnd){
        return Reason_KC_DAO.getData(dateStart,dateEnd);
    }
}
