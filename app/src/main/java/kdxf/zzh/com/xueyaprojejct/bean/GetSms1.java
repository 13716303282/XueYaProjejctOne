package kdxf.zzh.com.xueyaprojejct.bean;

/**
 * Created by ASUS on 2018/11/9.
 */

public class GetSms1 extends SerObject{
    private int   code;
    private String error;
    private DateDetil data;
    private  String SMScode;

    public String getSMScode() {
        return SMScode;
    }

    public void setSMScode(String SMScode) {
        this.SMScode = SMScode;
    }

    public int   getCode() {
        return code;
    }

    public void setCode(int  code) {
        this.code = code;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public DateDetil getData() {
        return data;
    }

    public void setData(DateDetil data) {
        this.data = data;
    }
}