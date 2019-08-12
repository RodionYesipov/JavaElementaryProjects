package service;

import bd.mapper.DataTaskDAO;
import bd.mapper.Portfel_EX_Avtodecision_DAO;
import bd.model.DataTasks;
import bd.model.Portfel_EX_Avtodecision;

import java.util.List;

public class Portfel_EX_Avtodecision_Service {

    public static List<Portfel_EX_Avtodecision> getdata (){
        return Portfel_EX_Avtodecision_DAO.getData();
    }
}
