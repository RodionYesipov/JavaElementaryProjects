package bd.model;



import javax.persistence.*;
import java.io.Serializable;

@Entity
public class DataTasks implements Serializable {

    @Id
    String y0;
    String y1;
    int kub_pre_accept;
    int kub_pre_decline;
    int kub_pre_all;
    int pct_kub_pre_decline;
    int kub_pre_decline_precalc;
    int kub_pre_accept_precalc;
    int kub_pre_all_precalc;
    int pct_kub_pre_precalc_decline;

    public String getY0() {
        return y0;
    }

    public void setY0(String y0) {
        this.y0 = y0;
    }

    public String getY1() {
        return y1;
    }

    public void setY1(String y1) {
        this.y1 = y1;
    }

    public int getKub_pre_accept() {
        return kub_pre_accept;
    }

    public void setKub_pre_accept(int kub_pre_accept) {
        this.kub_pre_accept = kub_pre_accept;
    }

    public int getKub_pre_decline() {
        return kub_pre_decline;
    }

    public void setKub_pre_decline(int kub_pre_decline) {
        this.kub_pre_decline = kub_pre_decline;
    }

    public int getKub_pre_all() {
        return kub_pre_all;
    }

    public void setKub_pre_all(int kub_pre_all) {
        this.kub_pre_all = kub_pre_all;
    }

    public int getPct_kub_pre_decline() {
        return pct_kub_pre_decline;
    }

    public void setPct_kub_pre_decline(int pct_kub_pre_decline) {
        this.pct_kub_pre_decline = pct_kub_pre_decline;
    }

    public int getKub_pre_decline_precalc() {
        return kub_pre_decline_precalc;
    }

    public void setKub_pre_decline_precalc(int kub_pre_decline_precalc) {
        this.kub_pre_decline_precalc = kub_pre_decline_precalc;
    }

    public int getKub_pre_accept_precalc() {
        return kub_pre_accept_precalc;
    }

    public void setKub_pre_accept_precalc(int kub_pre_accept_precalc) {
        this.kub_pre_accept_precalc = kub_pre_accept_precalc;
    }

    public int getKub_pre_all_precalc() {
        return kub_pre_all_precalc;
    }

    public void setKub_pre_all_precalc(int kub_pre_all_precalc) {
        this.kub_pre_all_precalc = kub_pre_all_precalc;
    }

    public int getPct_kub_pre_precalc_decline() {
        return pct_kub_pre_precalc_decline;
    }

    public void setPct_kub_pre_precalc_decline(int pct_kub_pre_precalc_decline) {
        this.pct_kub_pre_precalc_decline = pct_kub_pre_precalc_decline;
    }
}
