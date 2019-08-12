package service;

import bd.mapper.DataTaskDAO;
import bd.model.DataTasks;

import java.util.List;

public class DataTasksService {

    public static List< DataTasks> getdata (String dateStart, String dateEnd,String char_type){
        return DataTaskDAO.getData(dateStart,dateEnd,char_type);
    }
}
