package bd.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class MainpieChart {
    @Id
    String repdate;
    String portfel;
    String exsum90;
    float npl;
    float precent_decline;
    float avg_limit;
    int input_new_task;
    int procent_avto_decison;


    public String getRepdate() {
        return repdate;
    }

    public void setRepdate(String repdate) {
        this.repdate = repdate;
    }

    public String getPortfel() {
        return portfel;
    }

    public void setPortfel(String portfel) {
        this.portfel = portfel;
    }

    public String getExsum90() {
        return  exsum90;
    }

    public void setExsum90(String exsum90) {
        this.exsum90 = exsum90;
    }

    public float getNpl() {
        return npl;
    }

    public void setNpl(float npl) {
        this.npl = npl;
    }

    public float getPrecent_decline() {
        return precent_decline;
    }

    public void setPrecent_decline(float precent_decline) {
        this.precent_decline = precent_decline;
    }

    public float getAvg_limit() {
        return avg_limit;
    }

    public void setAvg_limit(float avg_limit) {
        this.avg_limit = avg_limit;
    }

    public int getInput_new_task() {
        return input_new_task;
    }

    public void setInput_new_task(int input_new_task) {
        this.input_new_task = input_new_task;
    }

    public int getProcent_avto_decison() {
        return procent_avto_decison;
    }

    public void setProcent_avto_decison(int procent_avto_decison) {
        this.procent_avto_decison = procent_avto_decison;
    }

    @Override
    public String toString() {
        return "{" +
                "\"repdate\":\"" + repdate + '\"' +
                ", \"portfel\":\"" + portfel + '\"' +
                ", \"exsum90\":\"" + exsum90 + '\"' +
                ", \"npl\":\"" + npl +"\""+
                ", \"precent_decline\":\"" + precent_decline +"\""+
                ", \"avg_limit\":\"" + avg_limit +"\""+
                ", \"input_new_task\":\"" + input_new_task +"\""+
                ",\"procent_avto_decison\":\"" + procent_avto_decison +"\""+
                "}";
    }
}
