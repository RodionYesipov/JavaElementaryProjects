package bd.mapper;

import bd.factoryhibernate.HibernateSessionFactory;
import bd.model.DataTasks;
import bd.model.Portfel_EX_Avtodecision;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Portfel_EX_Avtodecision_DAO {

    public static List<Portfel_EX_Avtodecision> getData(){
        Long dat = new Date().getTime()-15811200000L;//5 месяцев

        SimpleDateFormat format = new SimpleDateFormat("yyyy.MM.dd");

        String date = format.format(new Date(dat));


        List<Portfel_EX_Avtodecision> data  =  (List<Portfel_EX_Avtodecision>) HibernateSessionFactory.getSessionFactory().openSession().createSQLQuery(
                "SELECT dateformat(repdate,'yyyy-mm-dd') as y,\n" +
                        "       abs(sum(case when saldo < 0 then 1 else 0 end)) as CNT_Saldo,\n" +
                        "       abs(sum(case when saldo < 0 and ExDay > 90 then 1 else 0 end)) as CNT_Ex,\n" +
                        "       abs(sum(case when saldo < 0 then saldo else 1 end)) as Saldos,\n" +
                        "       abs(sum(case when saldo < 0 and ExDay > 90 then saldo else 0 end)) as Saldo_Ex,\n" +
                        "\n" +
                        "      -------------------------------------------------------------------------------------------------------\n" +
                        "       cast(t7.apps as numeric(8,1)) as \"new_task_KC\",\n" +
                        "       cast(t8.processed_task as numeric(8,1)) as \"finich_task\",\n" +
                        "       cast((t8.processed_task + new_task_KC - t7.finih_task_kc) as numeric(8,1))  as \"input_new_task\",\n" +
                        "        case when input_new_task = 0 then 0\n" +
                        "             else cast((100-(new_task_KC/input_new_task*100)) as numeric(8,1)) end as \"procent_avto_decison\",\n" +
                        "      -------------------------------------------------------------------------------------------------------\n" +
                        "      cast((t8.\"task_decline\" / \"input_new_task\"*100) as numeric(8,1))                      as \"procent_decline\",\n" +
                        "      case when \"avg_lim\" = null then 0 else t8.\"avg_lim\" \tend\t\t\t\t\t\t  as \"avg_lim\"\n" +
                        "from WEB.Kubs_portfel1 \n" +
                        "\n" +
                        "left join(\n" +
                        "select \n" +
                        "  \t\t\t    DT as \"DT\",\n" +
                        "  \t\t\t    sum(apps) over(order by DT rows between current row and 14 following) as \"apps\",\n" +
                        "  \t\t\t    sum(cast(successAllApps as numeric(8,1))+ cast(failedAllApps as numeric(8,1)))over (order by DT rows between current row and 14 following) as \"finih_task_kc\"\n" +
                        "  \t\t  from MSB.tQueueKub \n" +
                        "  \t\t  where date(DT)  > date('2019.01.07'))as t7 on t7.DT = date(y)\n" +
                        "\n" +
                        "left join(                 select date(ts_add)  \t\t\t\t\t\t\t\t\t\t\t\t                                                  as \"DT\",\n" +
                        "  \t\t         sum(count(*)) over(order by DT rows between current row and 14 following)   \t\t\t\t\t\t\t\t\t\t\t\tas \"processed_task\",\n" +
                        "  \t\t         sum(sum(case when decision = 'DECLINE' then 1 else 0 end)) over(order by DT rows between current row and 14 following)   \t\t\tas \"task_decline\",\n" +
                        "  \t\t         (sum(avg(case when decision = 'ACCEPT' then lim else null end)) over(order by DT rows between current row and 14 following))/14\t\tas \"avg_lim\"\n" +
                        "  \t\t  from msb.tkub \n" +
                        "  \t\t  where date(ts_add)  > date('2019.01.07') \n" +
                        "  \t\t  and char_type = 'KUB_FIN'\n" +
                        "  \t\t  group by \"DT\") as t8 on t8.DT = date(y)\n" +
                        "\n" +
                        "where date(y ) > date('2019.01.07')\n" +
                        "group by y,t7.apps,t8.processed_task,t7.finih_task_kc,t8.\"task_decline\",t8.\"avg_lim\"\n" +
                        "order by y\n" +
                        ";"
        ).addEntity(Portfel_EX_Avtodecision.class).list();

        return data;
    }
}
