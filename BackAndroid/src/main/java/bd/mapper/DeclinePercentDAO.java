package bd.mapper;

import bd.factoryhibernate.HibernateSessionFactory;
import bd.model.DeclinePercent;
import bd.model.RtdmHistoryModel;

import java.util.List;

public class DeclinePercentDAO {

    public static List<DeclinePercent> getData(String dateStart,String dateEnd){
        List<DeclinePercent> query  =  (List<DeclinePercent>) HibernateSessionFactory.getSessionFactory().openSession().createSQLQuery(


                "Select KubCode,t5.comm ,NameAll='Все', isnull(kub_cnt_why,0) as kub_cnt_why, isnull(kub_cnt_period,0) as kub_cnt_period, dateformat('"+dateStart+"', 'yyyy-mm-dd') + ' - '+ dateformat('"+dateEnd+"', 'yyyy-mm-dd') as y , case when  kub_cnt_period !=0 then cast (round(cast (kub_cnt_why*100 as numeric(15,2))/kub_cnt_period,1) as numeric(15,1))else 0 end as kub_pct_why, NamePrecalc='С предрасчетом', isnull(kub_prec_cnt_why,0) as kub_prec_cnt_why, isnull(kub_prec_cnt_period,0) as kub_prec_cnt_period, case when  kub_prec_cnt_period != 0 then cast (round(cast (kub_prec_cnt_why*100 as numeric(15,2))/kub_prec_cnt_period,1) as numeric(15,1))else 0 end as kub_precalc_pct_why from (Select Code as KubCode, count(*) as kub_cnt_why from web.tkub_fordash where dateformat(y,'yyyy-mm-dd') between dateformat('"+dateStart+"', 'yyyy-mm-dd') and dateformat('"+dateEnd+"', 'yyyy-mm-dd') and Decision='DECLINE' and char_type = 'KUB_PRE' group by KubCode) as t1 full join (Select Code as KubPrecCode, count(*) as kub_prec_cnt_why from web.tkub_fordash where dateformat(y,'yyyy-mm-dd') between dateformat('"+dateStart+"', 'yyyy-mm-dd') and dateformat('"+dateEnd+"', 'yyyy-mm-dd') and Decision='DECLINE' and char_type = 'KUB_PRE' and PreCalc = 'Y' and PreCalc = 'Y' group by KubPrecCode) as t2 on t1.KubCode=t2.KubPrecCode cross join (Select count(*) as kub_cnt_period from web.tkub_fordash where dateformat(y,'yyyy-mm-dd') between dateformat('"+dateStart+"', 'yyyy-mm-dd') and dateformat('"+dateEnd+"', 'yyyy-mm-dd') and Decision='DECLINE' and char_type = 'KUB_PRE') as t3 cross join (Select count(*) as kub_prec_cnt_period from web.tkub_fordash where dateformat(y,'yyyy-mm-dd') between dateformat('"+dateStart+"', 'yyyy-mm-dd') and dateformat('"+dateEnd+"', 'yyyy-mm-dd') and Decision='DECLINE' and char_type = 'KUB_PRE' and PreCalc = 'Y') as t4 left join msb.tKubCommentSystem as t5 on t1.KubCode=t5.Code Order by kub_pct_why desc;"


        ).addEntity(DeclinePercent.class).list();
        return query;
    }
}
