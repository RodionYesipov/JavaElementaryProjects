package service;

import bd.mapper.RtdmHistoryDAOHiber;
import bd.model.RtdmHistoryModel;

import java.util.Date;
import java.util.List;

public class RtdmHistoryService {




    public static List<RtdmHistoryModel> findByts_add (Date date){return RtdmHistoryDAOHiber.findObjectByDate(date);}

    public static List<RtdmHistoryModel> findByref (String ref){return RtdmHistoryDAOHiber.findObjectByRef(ref);}

    public static int countByDate(Date date){return RtdmHistoryDAOHiber.findCountTaskFromDate(date);}


}
