package bd.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class DeclinePercent implements Serializable {

    @Id
    String KubCode;
    String comm;
    String NameAll;
    int kub_cnt_why;
    int kub_cnt_period;
    String y;
    float kub_pct_why;
    String NamePrecalc;
    int kub_prec_cnt_why;
    int kub_prec_cnt_period;
    float kub_precalc_pct_why;

    public DeclinePercent() {}

    public String getKubCode() {
        return KubCode;
    }

    public void setKubCode(String kubCode) {
        KubCode = kubCode;
    }

    public String getComm() {
        return comm;
    }

    public void setComm(String comm) {
        this.comm = comm;
    }

    public String getNameAll() {
        return NameAll;
    }

    public void setNameAll(String nameAll) {
        NameAll = nameAll;
    }

    public int getKub_cnt_why() {
        return kub_cnt_why;
    }

    public void setKub_cnt_why(int kub_cnt_why) {
        this.kub_cnt_why = kub_cnt_why;
    }

    public int getKub_cnt_period() {
        return kub_cnt_period;
    }

    public void setKub_cnt_period(int kub_cnt_period) {
        this.kub_cnt_period = kub_cnt_period;
    }

    public String getY() {
        return y;
    }

    public void setY(String y) {
        this.y = y;
    }

    public float getKub_pct_why() {
        return kub_pct_why;
    }

    public void setKub_pct_why(float kub_pct_why) {
        this.kub_pct_why = kub_pct_why;
    }

    public String getNamePrecalc() {
        return NamePrecalc;
    }

    public void setNamePrecalc(String namePrecalc) {
        NamePrecalc = namePrecalc;
    }

    public int getKub_prec_cnt_why() {
        return kub_prec_cnt_why;
    }

    public void setKub_prec_cnt_why(int kub_prec_cnt_why) {
        this.kub_prec_cnt_why = kub_prec_cnt_why;
    }

    public int getKub_prec_cnt_period() {
        return kub_prec_cnt_period;
    }

    public void setKub_prec_cnt_period(int kub_prec_cnt_period) {
        this.kub_prec_cnt_period = kub_prec_cnt_period;
    }

    public float getKub_precalc_pct_why() {
        return kub_precalc_pct_why;
    }

    public void setKub_precalc_pct_why(float kub_precalc_pct_why) {
        this.kub_precalc_pct_why = kub_precalc_pct_why;
    }
}
