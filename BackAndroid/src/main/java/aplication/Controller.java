package aplication;

import bd.model.*;
import log.ResourceLog;
import org.json.JSONObject;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;
import service.*;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.logging.Logger;

@RestController
public class Controller {

    static Logger logger  = ResourceLog.getInstance("BackAndroid",System.getProperty("name")).getLogger("Controller");

    @GetMapping("Hi")
    public String heloo() throws IOException, TimeoutException {


       return "BackAndroid 1.0";
}





    @RequestMapping(value = "/findAll",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public List<DeclinePercent> postfindAll(@RequestBody String req) {

        JSONObject jsob = new JSONObject(req);
        List<DeclinePercent> declinePercents  = DeclinePercentService.getdata(jsob.getString("dateStart"),jsob.getString("dateEnd"));

        return declinePercents;
    }


    @RequestMapping( value = "/getDataTasks",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public List<DataTasks> postgetDataTasks(@RequestBody String req) {
        JSONObject jsob = new JSONObject(req);
        List<DataTasks> dataTasks  = DataTasksService.getdata( jsob.getString("dateStart"),jsob.getString("dateEnd"), jsob.getString("char_type"));

        return dataTasks;
    }

    @RequestMapping( value = "/getReason_kc",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Reason_KC> Reason_KC(@RequestBody String req) {
        JSONObject jsob = new JSONObject(req);
        List<Reason_KC> dataTasks  = Reason_KC_Service.getdata( jsob.getString("dateStart"),jsob.getString("dateEnd"));
        return dataTasks;
    }

    @RequestMapping( value = "/portexavtdec",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Portfel_EX_Avtodecision> PortfelRisk(@RequestBody String req) {
        JSONObject jsob = new JSONObject(req);
        List<Portfel_EX_Avtodecision> dataTasks  = Portfel_EX_Avtodecision_Service.getdata( );
        return dataTasks;
    }


    @RequestMapping( value = "/mainpiechart",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public MainpieChart Mainpiechart(@RequestBody String req) {

        MainpieChart dataTasks  = MainpieChartService.getdata( ).get(0);
        return dataTasks;
    }

    @RequestMapping( value = "/sheetsmain",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public String setsheetsmain(){
        ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();

        scheduler.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                MainpieChart dataTasks = MainpieChartService.getdata().get(0);
                String str = SheetsAndJava.UpdateData(dataTasks.toString());
            }
        },0,1, TimeUnit.MINUTES);

        return "Metod launched";
    }
}
