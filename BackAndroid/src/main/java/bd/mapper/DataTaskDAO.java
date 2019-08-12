package bd.mapper;

import bd.factoryhibernate.HibernateSessionFactory;
import bd.model.DataTasks;


import java.util.List;

public class DataTaskDAO {

    public static List<DataTasks>getData(String dateStart, String dateEnd,String char_type){

        List<DataTasks> data  =  (List<DataTasks>) HibernateSessionFactory.getSessionFactory().openSession().createSQLQuery(
                "select  dateformat(y,'yyyy-mm-dd') as y0,dateformat(web.tkub_fordash.y,'dd.mm') as y1,sum (case when Decision= 'ACCEPT'    then 1 else 0 end) as kub_pre_accept,sum (case when Decision= 'DECLINE'   then 1 else 0 end) as kub_pre_decline,case when kub_pre_accept + kub_pre_decline !=0 then kub_pre_accept + kub_pre_decline else 1 end as kub_pre_all, cast(round(cast (kub_pre_decline as numeric(8,1))*100/kub_pre_all,0) as int) as pct_kub_pre_decline,sum (case when Decision= 'DECLINE'and PreCalc='Y' then 1 else 0 end) as kub_pre_decline_precalc,sum (case when Decision= 'ACCEPT'and PreCalc='Y' then 1 else 0 end) as kub_pre_accept_precalc,kub_pre_decline_precalc+kub_pre_accept_precalc as kub_pre_all_precalc,case when kub_pre_decline_precalc = 0 then 0 else cast(round(cast (kub_pre_decline_precalc as numeric(8,1))*100/kub_pre_all_precalc,0) as int) end as pct_kub_pre_precalc_decline from web.tkub_fordash where char_type = '"+char_type+"' and dateformat(y,'yyyy-mm-dd') between dateformat('"+dateStart+"','yyyy-mm-dd') and dateformat('"+dateEnd+"','yyyy-mm-dd') group by  y1,y0 order by  y0;commit;"
        ).addEntity(DataTasks.class).list();

        return data;
    }
}
