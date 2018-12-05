package kdxf.zzh.com.xueyaprojejct.bean;

/**
 * Created by ASUS on 2018/11/9.
 */

public class GetForgetSms extends SerObject{

    /**
     * id : aqe0cct6m5p0e6uhv2oe3ri3b3
     * code : 10000
     * error :
     */

    private String id;
    private int code;
    private String error;
    private String phone;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
