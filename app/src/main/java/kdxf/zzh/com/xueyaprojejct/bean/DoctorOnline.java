package kdxf.zzh.com.xueyaprojejct.bean;

import java.util.List;

/**
 * Created by ASUS on 2018/11/14.
 */

public class DoctorOnline {
    private  int code;
    private  List <Doctordetail>  data;
    private  String msg;
    private  int  total;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<Doctordetail> getData() {
        return data;
    }

    public void setData(List<Doctordetail> data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
