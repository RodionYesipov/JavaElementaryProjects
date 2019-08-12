package bd.model;


import javax.persistence.*;
import java.io.Serializable;
@Entity
public class Reason_KC implements Serializable{
    @Id
    String CODE_KC_1;
    String count_code;
    String sum_all_code;
    String procent_code;
    String new_task_KC;
    String finich_task;
    String input_new_task;
    String procent_avto_decison;

    public Reason_KC() { }


    public String getCODE_KC_1() {
        return CODE_KC_1;
    }

    public void setCODE_KC_1(String CODE_KC_1) {
        this.CODE_KC_1 = CODE_KC_1;
    }

    public String getCount_code() {
        return count_code;
    }

    public void setCount_code(String count_code) {
        this.count_code = count_code;
    }

    public String getSum_all_code() {
        return sum_all_code;
    }

    public void setSum_all_code(String sum_all_code) {
        this.sum_all_code = sum_all_code;
    }

    public String getProcent_code() {
        return procent_code;
    }

    public void setProcent_code(String procent_code) {
        this.procent_code = procent_code;
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
