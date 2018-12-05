package kdxf.zzh.com.xueyaprojejct.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.EditText;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import kdxf.zzh.com.xueyaprojejct.bean.User;

/**
 * Created by ASUS on 2018/11/7.
 */

public class Config {
    public static String tag = "BloodAndroid";
    public static String Sign = "KHy69gsk8%#@kl$";
    public static String url = "http://api.wws.xywy.com/index.php?";
    private static SharedPreferences sp;

    public static final String NAME_MATCH = "^[\u4E00-\u9FA5]{2,8}$";
    public static final String PHONE_MATCH = "^1[0-9]{10}$";
    public static final String PAS_MATCH = "^[0-9a-zA]{6,16}$";

    public static boolean isprintLog = true;

    public static String getUrl(String act, String fun) {
        String sign = MD5.md5s( Sign + tag );
        return url + "tag=" + tag + "&sign=" + sign + "&act=" + act + "&fun=" + fun;
    }

    public static String getUrl(String act, String fun, String tag) {
        String sign = MD5.md5s( Sign + tag );
        return url + "tag=" + tag + "&sign=" + sign + "&act=" + act + "&fun=" + fun;
    }

    public static String tagg = "wjk";

    public static String getRegisterUrl(String act, String fun) {
        String sign = MD5.md5s( Sign + tagg );
        return url + "tag=" + tagg + "&sign=" + sign + "&act=" + act + "&fun=" + fun;
    }

    public static SharedPreferences getSP(Context context) {
        sp = context.getSharedPreferences( "account.config", Context.MODE_PRIVATE );
        return sp;
    }

    public static boolean isLogin(Context context) {
        if (sp == null) {
            sp = getSP( context );
        }
        return sp.getBoolean( "login", false );
    }

    public static String getText(EditText editText) {
        String value = editText.getText().toString().trim();
        return value;
    }

    public static User getUser(Context context) {
        String json = getSP( context ).getString( "user", "" );
        Gson gson = new Gson();
        return gson.fromJson( json, User.class );
    }

    public static void setUser(Context context, User user) {
        Gson gson = new Gson();
        String josn = gson.toJson( user );
        getSP( context ).edit().putString( "user", josn ).commit();
    }

    public static List<String> province = new ArrayList<>();

    public  static  void   setProvice(){
        province.clear();
        province.add("不限");
        province.add("北京市");
        province.add("山东省");
        province.add("山西省");
        province.add("河北省");
        province.add("河南省");
        province.add("天津市");
        province.add("辽宁省");
        province.add("黑龙江省");
        province.add("吉林省");
        province.add("湖北省");
        province.add("湖南省");
        province.add("上海市");
        province.add("四川省");
        province.add("重庆市");
        province.add("陕西省");
        province.add("甘肃省");
        province.add("云南省");
        province.add("新疆维吾尔自治区");
        province.add("内蒙古自治区");
        province.add("海南省");
        province.add("贵州省");
        province.add("青海省");
        province.add("广东省");
        province.add("宁夏回族自治区");
        province.add("西藏自治区");
        province.add("广西壮族自治区");
        province.add("江苏省 ");
        province.add("浙江省");
        province.add("安徽省");
        province.add("江西省");
        province.add("福建省");
    }
}
