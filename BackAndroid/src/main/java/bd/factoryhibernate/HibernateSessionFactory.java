package bd.factoryhibernate;

import bd.model.*;
import log.ResourceLog;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.util.logging.Level;
import java.util.logging.Logger;


public class HibernateSessionFactory {

    static Logger logger  = ResourceLog.getInstance("BackAndroid",System.getProperty("name")).getLogger("Controller");
    private static SessionFactory sessionFactory;

    private HibernateSessionFactory() {}

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration().configure();
                configuration.addAnnotatedClass(RtdmHistoryModel.class);
                configuration.addAnnotatedClass(DeclinePercent.class);
                configuration.addAnnotatedClass(DataTasks.class);
                configuration.addAnnotatedClass(Reason_KC.class);
                configuration.addAnnotatedClass(Portfel_EX_Avtodecision.class);
                configuration.addAnnotatedClass(MainpieChart.class);

                StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
                sessionFactory = configuration.buildSessionFactory(builder.build());

            } catch (Exception e) {


                System.out.println("Исключение!" + e);
                String s = e.getMessage();
                logger.log(Level.SEVERE,s,e);
            }
        }
        return sessionFactory;
    }
}
