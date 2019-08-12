package service;

import bd.mapper.DeclinePercentDAO;
import bd.mapper.MainpieChartDAO;
import bd.model.DeclinePercent;
import bd.model.MainpieChart;

import java.util.List;

public class MainpieChartService {
    public static List<MainpieChart> getdata(){
        return MainpieChartDAO.getData();
    }
}
