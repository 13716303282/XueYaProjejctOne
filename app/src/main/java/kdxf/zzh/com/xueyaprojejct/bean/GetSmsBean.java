package kdxf.zzh.com.xueyaprojejct.bean;

/**
 * Created by ASUS on 2018/11/8.
 */

public class GetSmsBean extends SerObject{

    /**
     * id : a31uhlvgn6quje3o1jl5mubsb3
     * code : 10000
     * error :
     */

    private String id;
    private int code;
    private String error;
    private String name;
    private String phone;
    private String pass;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
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
