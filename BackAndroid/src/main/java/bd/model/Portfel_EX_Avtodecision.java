package bd.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Portfel_EX_Avtodecision implements Serializable {

    @Id
    String y;
    String CNT_Saldo;
    String CNT_Ex;
    String Saldos;
    String Saldo_Ex;
    String new_task_KC;
    String finich_task;
    String input_new_task;
    String procent_avto_decison;
    String procent_decline;
    int avg_lim;

    public String getY() {
        return y;
    }


    public void setY(String y) {
        this.y = y;
    }

    public String getProcent_decline() {
        return procent_decline;
    }

    public void setProcent_decline(String procent_decline) {
        this.procent_decline = procent_decline;
    }

    public int getAvg_lim() {
        return avg_lim;
    }

    public void setAvg_lim(int avg_lim) {
        this.avg_lim = avg_lim;
    }

    public String getCNT_Saldo() {
        return CNT_Saldo;
    }

    public void setCNT_Saldo(String CNT_Saldo) {
        this.CNT_Saldo = CNT_Saldo;
    }

    public String getCNT_Ex() {
        return CNT_Ex;
    }

    public void setCNT_Ex(String CNT_Ex) {
        this.CNT_Ex = CNT_Ex;
    }

    public String getSaldos() {
        return Saldos;
    }

    public void setSaldos(String saldos) {
        Saldos = saldos;
    }

    public String getSaldo_Ex() {
        return Saldo_Ex;
    }

    public void setSaldo_Ex(String saldo_Ex) {
        Saldo_Ex = saldo_Ex;
    }

    public String getNew_task_KC() {
        return new_task_KC;
    }

    public void setNew_task_KC(String new_task_KC) {
        this.new_task_KC = new_task_KC;
    }

    public String getFinich_task() {
        return finich_task;
    }

    public void setFinich_task(String finich_task) {
        this.finich_task = finich_task;
    }

    public String getInput_new_task() {
        return input_new_task;
    }

    public void setInput_new_task(String input_new_task) {
        this.input_new_task = input_new_task;
    }

    public String getProcent_avto_decison() {
        return procent_avto_decison;
    }

    public void setProcent_avto_decison(String procent_avto_decison) {
        this.procent_avto_decison = procent_avto_decison;
    }
}
