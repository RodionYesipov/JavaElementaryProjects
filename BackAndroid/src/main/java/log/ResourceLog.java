package log;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author noname
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 *
 * @author Ася
 */
public class ResourceLog {

    //////////////////////////////////////////////////////////////////////////////////////////////////
    private static ResourceLog instance = null;
    private final Map<String, Logger> loggers = new HashMap<String, Logger>();
    private static Map<String, ResourceLog> resources = new HashMap<String, ResourceLog>();
    private String home, homeini;
    private static ConsoleHandler consoleHandler = new ConsoleHandler();


    public ResourceLog() {
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////
    ResourceLog(String homelog, String homeini) {
        home = homelog;
        this.homeini = homeini;
        try {
            File homedir = new File(homelog);
            if (!homedir.isDirectory()) {
                homedir.mkdirs();
            }
            File homeIniDir = new File(homeini);
            if (!homeIniDir.isDirectory()) {
                homeIniDir.mkdirs();
            }

        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }


    //////////////////////////////////////////////////////////////////////////////////////////////////
    public synchronized static ResourceLog getInstance(String projectName, String instanceName) {
        String pathHome = instanceName + "/" + projectName;
        if (!resources.containsKey(pathHome)) {
            String logdir = System.getProperty("logdir");
            String etcdir = System.getProperty("etcdir");
            resources.put(pathHome, new ResourceLog(
                    (logdir != null ? logdir : "/sybase/log/") + pathHome,
                    (etcdir != null ? etcdir : "/sybase/etc/") + instanceName + "/"));
        }
        return resources.get(pathHome);
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////
    public Logger initLog(String class_name, String log_name, String log_level, int log_maxsize, int maxCountOfLogFiles, boolean append) throws IOException {
        return initLog("/log", class_name, log_name, log_level, log_maxsize, maxCountOfLogFiles, append);
    }

    public Logger initLog(String relativePath, String class_name, String log_name, String log_level, int log_maxsize, int maxCountOfLogFiles, boolean append) throws IOException {
        String log_file = String.format("%s%s/%s.log", home, relativePath, log_name);
        File logdir = new File(log_file).getParentFile();
        if (!logdir.isDirectory()) {
            logdir.mkdirs();
        }
        FileHandler handler = new FileHandler(log_file, log_maxsize, maxCountOfLogFiles, append);
        handler.setFormatter(new SimpleFormatter());
        Logger logger = Logger.getLogger(class_name);
        logger.setLevel(Level.parse(log_level));
        if (System.getProperty("isTestUnit")!=null) {
            logger.addHandler(consoleHandler);
        } else {
            logger.addHandler(handler);
        }
        logger.setUseParentHandlers(false);
        loggers.put(class_name, logger);
        return logger;
    }

    public Logger initLog(String class_name, String log_name, String log_level, int log_maxsize, int maxCountOfLogFiles) throws IOException {
        return initLog(class_name, log_name, log_level, log_maxsize, maxCountOfLogFiles, false);
    }

    public Logger initLog(String class_name, String log_name, String log_level, int log_maxsize) throws IOException{
        return initLog(class_name, log_name, log_level, log_maxsize, 2);
    }

    public Logger initLog(String log_name, String log_level, int log_maxsize) throws IOException {
        return initLog(log_name, log_name, log_level, log_maxsize);
    }

    public Logger initLog(Class clazz, String log_level, int log_maxsize) throws IOException {
        return initLog(clazz.getName(), clazz.getSimpleName(), log_level, log_maxsize);
    }

    public Logger getLogger(String log_name) {
        Logger logger = loggers.get(log_name);
        if (logger == null) {
            try {
                logger = initLog(log_name, "ALL", 10240000);
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }
        return logger;
    }

    /////////////////////////////////////////////////////////////////////////
    public Properties getIniParam(String log_name) throws IOException {

        Properties prs = new Properties();
        File ini = new File(homeini + log_name);
        if (ini.isFile()) {
            InputStream in = new FileInputStream(ini);
            prs.load(in);
            in.close();
        }
        return prs;

    }

    /////////////////////////////////////////////////////////////////////////////////////////////////
    public String getHome() {
        return home;
    }

    public String getHomeini() {
        return homeini;
    }
}
