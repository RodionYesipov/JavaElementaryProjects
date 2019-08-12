package bd.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Entity
public class RtdmHistoryModel implements Serializable {

    @Id
    private String ref ;
    private String strategy_id;
    private String prod_char_type;
    private int cust_id;
    @Id
    private String param_name;
    private String param_value;
    private Date ts_add;

    public RtdmHistoryModel() {}



    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public String getStrategy_id() {
        return strategy_id;
    }

    public void setStrategy_id(String strategy_id) {
        this.strategy_id = strategy_id;
    }

    public String getProd_char_type() {
        return prod_char_type;
    }

    public void setProd_char_type(String prod_char_type) {
        this.prod_char_type = prod_char_type;
    }

    public int getCust_id() {
        return cust_id;
    }

    public void setCust_id(int cust_id) {
        this.cust_id = cust_id;
    }

    public String getParam_name() {
        return param_name;
    }

    public void setParam_name(String param_name) {
        this.param_name = param_name;
    }

    public String getParam_value() {
        return param_value;
    }

    public void setParam_value(String param_value) {
        this.param_value = param_value;
    }

    public Date getTs_add() {
        return ts_add;
    }

    public void setTs_add(Date ts_add) {
        this.ts_add = ts_add;
    }






}
