package bd.mapper;

import bd.factoryhibernate.HibernateSessionFactory;
import bd.model.Reason_KC;

import java.util.List;

public class Reason_KC_DAO {

    public static List<Reason_KC> getData(String dateStart, String dateEnd){
        List<Reason_KC> query  = (List<Reason_KC>) HibernateSessionFactory.getSessionFactory().openSession().createSQLQuery(


                "select \t \n" +
                        " case when CODE_KC like '%C001%' then 'C001'\n" +
                        "            when CODE_KC like '%C002%' then 'C002'\n" +
                        "            when CODE_KC like '%C003%' then 'C003'\n" +
                        "            when CODE_KC like '%C004%' then 'C004'\n" +
                        "            when CODE_KC like '%C005%' then 'C005'\n" +
                        "            when CODE_KC like '%C006%' then 'C006'\n" +
                        "            when CODE_KC like '%C007%' then 'C007'\n" +
                        "            when CODE_KC like '%C008%' then 'C008'\n" +
                        "            when CODE_KC like '%C009%' then 'C009'\n" +
                        "            when CODE_KC like '%C010%' then 'C010'\n" +
                        "            when CODE_KC like '%C011%' then 'C011'\n" +
                        "            when CODE_KC like '%C012%' then 'C012'\n" +
                        "            when CODE_KC like '%C013%' then 'C013'\n" +
                        "            when CODE_KC like '%C014%' then 'C014'\n" +
                        "            when CODE_KC like '%C015%' then 'C015'\n" +
                        "            when CODE_KC like '%C016%' then 'C016'\n" +
                        "            when CODE_KC like '%C017%' then 'C017'\n" +
                        "            when CODE_KC like '%C018%' then 'C018'\n" +
                        "            when CODE_KC like '%C019%' then 'C019'\n" +
                        "            when CODE_KC like '%C020%' then 'C020'\n" +
                        "            when CODE_KC like '%C021%' then 'C021'\n" +
                        "            when CODE_KC like '%C022%' then 'C022'\n" +
                        "            when CODE_KC like '%C023%' then 'C023'\n" +
                        "            when CODE_KC like '%C024%' then 'C024'\n" +
                        "            when CODE_KC like '%C025%' then 'C025'\n" +
                        "            when CODE_KC like '%C026%' then 'C026'\n" +
                        "            when CODE_KC is null then '777'\n" +
                        "        end as \"CODE_KC_1\",\n" +
                        "        cast(count() as numeric(8,1)) as \"count_code\",\n" +
                        "        sum(count_code) over () as \"sum_all_code\",\n" +
                        "        case when sum_all_code = 0 then 0\n" +
                        "             else round(count_code /sum_all_code *100,2) end as \"procent_code\",\n" +
                        "          \n" +
                        "            cast(t7.apps as numeric(8,1)) as \"new_task_KC\",\n" +
                        "          \n" +
                        "            cast(t8.processed_task as numeric(8,1)) as \"finich_task\",\n" +
                        "          \n" +
                        "            cast((t8.processed_task + new_task_KC - t7.finih_task_kc) as numeric(8,1)) as \"input_new_task\",\n" +
                        "          \n" +
                        "            case when input_new_task = 0 then 0\n" +
                        "             else cast((100-(new_task_KC/input_new_task*100)) as numeric(8,1)) end as \"procent_avto_decison\"\n" +
                        "       \n" +
                        "        from msb.tkub as t6\n" +
                        "        \n" +
                        "  left join(select \n" +
                        "  \t\t\t    DT as \"DT\",\n" +
                        "  \t\t\t    sum(apps) over() as \"apps\",\n" +
                        "  \t\t\t    sum(cast(successAllApps as numeric(8,1))+ cast(failedAllApps as numeric(8,1))) over() as \"finih_task_kc\"\n" +
                        "  \t\t  from MSB.tQueueKub \n" +
                        "  \t\t  where date(DT) between '"+dateStart+"' and '"+dateEnd+"'  )as t7 on t7.DT = date(t6.ts_add)\n" +
                        "  \t\t  \n" +
                        "  left join(select date(ts_add) as \"DT\",\n" +
                        "  \t\t         sum(count(*)) over() as \"processed_task\"\n" +
                        "  \t\t  from msb.tkub \n" +
                        "  \t\t  where date(ts_add)  between '"+dateStart+"' and '"+dateEnd+"' \n" +
                        "  \t\t  and char_type = 'KUB_FIN'\n" +
                        "  \t\t  group by \"DT\") as t8 on t8.DT = date(t6.ts_add)\n" +
                        "  \t\t  \n" +
                        "        \n" +
                        "       \twhere char_type = 'KUB_FIN' \n" +
                        "       \tand date(ts_add) between '"+dateStart+"' and '"+dateEnd+"' \n" +
                        "       \tand typedec = 'KC'\n" +
                        "        group by code_kc_1, t7.apps,t8.processed_task,t7.finih_task_kc;"


        ).addEntity(Reason_KC.class).list();
        return query;
    }
}
