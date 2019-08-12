package bd.mapper;

import bd.factoryhibernate.HibernateSessionFactory;
import bd.model.MainpieChart;
import bd.model.Portfel_EX_Avtodecision;

import java.util.List;

public class MainpieChartDAO {

    public static List<MainpieChart> getData(){
        List<MainpieChart> data  =  (List<MainpieChart>) HibernateSessionFactory.getSessionFactory().openSession().createSQLQuery(
                "select distinct\n" +
                        "\trepdate,\n" +
                        "\tsum(balbody*-1) over()                                                                                as \"portfel\",\n" +
                        "\tsum((case when ExAge >= 90 then balbody else 0 end)*-1) over()                                        as \"exsum90\",\n" +
                        "\t\"exsum90\" / \"portfel\"                                                                               as \"npl\",\n" +
                        "\tt2.\"precent\"                                                                                        as \"precent_decline\",\n" +
                        "\tavg(balstart) over()                                                                                as \"avg_limit\",\n" +
                        "\tcast(t2.\"task_on_decision\" + t7.\"new_task_KC\"-t7.\"finih_task_kc\" as numeric(8,1))                   as \"input_new_task\",\n" +
                        "        case when input_new_task = 0 then 0\n" +
                        "             else cast((100-(t7.new_task_KC/input_new_task*100)) as numeric(8,1)) end                    as \"procent_avto_decison\" \n" +
                        "from rm.tSybridgeCredit  \n" +
                        "\n" +
                        "left join(\n" +
                        "\n" +
                        "     select today()                                                                                      as \"DT\",\n" +
                        "       count()                                                                                           as \"task_on_decision\",\n" +
                        "       sum(case when decision = 'DECLINE' then 1 else 0 end)                                             as \"task_decline\",\n" +
                        "       case when \"task_on_decision\" = 0\n" +
                        "\t     then 0\n" +
                        "\t     else cast(1. * \"task_decline\" / \"task_on_decision\" * 100 as numeric(15,2))\n" +
                        "\t  end \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tas \"precent\"\n" +
                        "     from msb.tkub\n" +
                        "     where date(ts_add) >= today()-7\n" +
                        "     and char_type = 'KUB_FIN'\n" +
                        "     group by \"DT\"\n" +
                        "\n" +
                        ")  as t2 on t2.DT = repdate\n" +
                        "\n" +
                        "left join(\n" +
                        "\n" +
                        "            select \n" +
                        "  \t\t\t    dateadd(day,1, DT)                                                                    as \"DT\",\n" +
                        "  \t\t\t    sum(apps) over( )                                                                     as \"new_task_KC\",\n" +
                        "  \t\t\t    sum(cast(successAllApps as numeric(8,1))+ cast(failedAllApps as numeric(8,1)))over () as \"finih_task_kc\"\n" +
                        "  \t\t  from MSB.tQueueKub \n" +
                        "  \t\t  where date(DT)  >= today()-7\n" +
                        "  \t\t  \n" +
                        ")as t7 on t7.DT = repdate\n" +
                        "\n" +
                        "where EOB_DLP = 'KUB'\n" +
                        "and bos_pr_s = 'A'\n" +
                        "\n" +
                        "\n" +
                        "\n" +
                        "\n"
        ).addEntity(MainpieChart.class).list();
        return data;
    }
}
