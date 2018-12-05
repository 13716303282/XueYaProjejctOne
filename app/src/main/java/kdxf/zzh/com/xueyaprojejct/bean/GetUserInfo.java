package kdxf.zzh.com.xueyaprojejct.bean;

import java.util.List;

/**
 * Created by ASUS on 2018/11/11.
 */

public class GetUserInfo {

    /**
     * state : 200
     * email :
     * pushable : 1
     * avatar : http://xs3.op.xywy.com/api.iu1.xywy.com/ucenter/20181109/82b599e4059118fa688f8fd708e0948d13336.jpg
     * accounts : [{"accountid":0,"accountstr":"含笑有白露啊","test":"女","height":"","birthday":"0000-00-00"}]
     */

    private int state;
    private String email;
    private int pushable;
    private String avatar;
    private List<Accountsuser> accounts;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPushable() {
        return pushable;
    }

    public void setPushable(int pushable) {
        this.pushable = pushable;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public List<Accountsuser> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Accountsuser> accounts) {
        this.accounts = accounts;
    }

    public static class Accountsuser {
        /**
         * accountid : 0
         * accountstr : 含笑有白露啊
         * test : 女
         * height :
         * birthday : 0000-00-00
         */

        private int accountid;
        private String accountstr;
        private String sex;
        private String height;
        private String birthday;

        public int getAccountid() {
            return accountid;
        }

        public void setAccountid(int accountid) {
            this.accountid = accountid;
        }

        public String getAccountstr() {
            return accountstr;
        }

        public void setAccountstr(String accountstr) {
            this.accountstr = accountstr;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public String getHeight() {
            return height;
        }

        public void setHeight(String height) {
            this.height = height;
        }

        public String getBirthday() {
            return birthday;
        }

        public void setBirthday(String birthday) {
            this.birthday = birthday;
        }
    }
}
