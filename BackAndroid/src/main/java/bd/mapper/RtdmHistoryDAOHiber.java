package bd.mapper;


import bd.factoryhibernate.HibernateSessionFactory;
import bd.model.RtdmHistoryModel;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import java.util.Date;
import java.util.List;

public class RtdmHistoryDAOHiber {



    public static List<RtdmHistoryModel> findObjectByDate(Date date ) {
        List<RtdmHistoryModel> query  =  (List<RtdmHistoryModel>) HibernateSessionFactory.getSessionFactory().openSession().createSQLQuery("select  * from rtdm_main.RTDM_HISTORY where  date(ts_add) = '"+date+"'").addEntity(RtdmHistoryModel.class).list();
        return query;
    }

    public static List<RtdmHistoryModel> findObjectByRef(String ref ) {
        List<RtdmHistoryModel> query  =  (List<RtdmHistoryModel>)HibernateSessionFactory.getSessionFactory().openSession().createSQLQuery("SELECT * from rtdm_main.RTDM_HISTORY where ref='"+ref+"';").addEntity(RtdmHistoryModel.class).list();
        return query;
    }

    public  static int findCountTaskFromDate(Date date){
        Query count  =  HibernateSessionFactory.getSessionFactory().openSession().createSQLQuery("SELECT count (*) from rtdm_main.RTDM_HISTORY where date(ts_add)>='2019-05-10';").addEntity(RtdmHistoryModel.class);
        Integer i = Integer.valueOf(count.toString());

        return i;
    }




}
