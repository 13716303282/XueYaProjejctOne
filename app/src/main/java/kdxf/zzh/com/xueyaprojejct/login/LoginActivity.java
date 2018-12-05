package kdxf.zzh.com.xueyaprojejct.login;

import android.content.SharedPreferences;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import kdxf.zzh.com.xueyaprojejct.MainActivity;
import kdxf.zzh.com.xueyaprojejct.R;
import kdxf.zzh.com.xueyaprojejct.bean.GetUserInfo;
import kdxf.zzh.com.xueyaprojejct.bean.User;
import kdxf.zzh.com.xueyaprojejct.framework.BaseActivity;
import kdxf.zzh.com.xueyaprojejct.http.OkHttpUtils;
import kdxf.zzh.com.xueyaprojejct.http.RequestCallBack;
import kdxf.zzh.com.xueyaprojejct.utils.Config;
import kdxf.zzh.com.xueyaprojejct.utils.LogUtils;
import okhttp3.Call;

/**
 * Created by ASUS on 2018/11/6.
 */

public class LoginActivity extends BaseActivity {

    private EditText ed_phone;
    private EditText ed_pas;
    private TextView input_phone;
    private TextView input_pas;
    private TextView tv_forget;
    private TextView tv_login;
    private TextView tv_register;
    private String phone;
    private String pas;

    @Override
    public int initLayout() {
        return R.layout.activity_login;
    }

    @Override
    public void initView() {
        ed_phone = findViewById( R.id.ed_phone );
        ed_pas = findViewById( R.id.ed_pas );

        input_phone = findViewById( R.id.input_phone );
        input_pas = findViewById( R.id.input_pas );

        tv_forget = findViewById( R.id.tv_forget );
        tv_login = findViewById( R.id.tv_login );
        tv_register = findViewById( R.id.tv_register );
    }

    @Override
    public void initClick() {
        input_phone.setOnClickListener( this );
        input_pas.setOnClickListener( this );
        tv_forget.setOnClickListener( this );
        tv_login.setOnClickListener( this );
        tv_register.setOnClickListener( this );
    }

    @Override
    public void initlogic() {
        ed_phone.addTextChangedListener( new PhoneTextWatcher() );
        ed_pas.addTextChangedListener( new PasTextWatcher() );
    }

    public class PasTextWatcher implements TextWatcher {

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            int len = s.length();
            if (len >= 6 && len <= 16) {
                input_pas.setText( "" );
                input_pas.setBackgroundResource( R.mipmap.checkbox_press );
            } else {
                if (len == 0) {
                    input_pas.setText( getText( R.string.input_pas ) );
                } else {
                    input_pas.setText( "" );
                }
                input_pas.setBackgroundResource( R.color.white );

            }
        }
    }

    public class PhoneTextWatcher implements TextWatcher {

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            int len = s.length();
            if (len == 11) {
                input_phone.setText( "" );
                input_phone.setBackgroundResource( R.mipmap.checkbox_press );
            } else {
                if (len == 0) {
                    input_phone.setText( getText( R.string.input_phone ) );
                } else {
                    input_phone.setText( "" );
                }
                input_phone.setBackgroundResource( R.color.white );
            }
        }

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_forget:
                enterActivity( ForgetActivity.class );
                break;
            case R.id.tv_login:
                phone = ed_phone.getText().toString().trim();
                pas = ed_pas.getText().toString().trim();
                boolean is_right = checkInfo( phone, pas );
                if (is_right) {
                    //用户获取密码请求服务器
                    String url = Config.getUrl( "kbb", "users" ) + "&type=login";
                    Log.i( "url", url );
                    Map<String, String> map = new HashMap<>();
                    map.put( "phonenum", phone );
                    map.put( "password", pas );
                    OkHttpUtils.getInstance().post( url, map, new AA() );
                }

                break;
            case R.id.tv_register:
                enterActivity( RegisterActivity.class );
                break;
        }

    }

    public boolean checkInfo(String phone, String pas) {
        int phone_len = phone.length();
        int pas_len = pas.length();
        if (phone_len == 11 && pas_len >= 6 && pas_len <= 16) {
            return true;
        }
        if (phone_len != 11) {
            show( "请输入正确的手机号码" );
            return false;
        }
        if (!(pas_len >= 6 && pas_len <= 16)) {
            show( "请输入正确的密码" );
            return false;
        }
        return true;

    }

    public class AA implements RequestCallBack<String> {

        @Override
        public void sucess(Call call, String t) {
            Gson gson = new Gson();
            User user = gson.fromJson( t, User.class );
            if (user.getState() == 200) {
                getMyInfo(user.getUserid(),user);
            } else {
                show( "格式错误" );
            }

        }

        @Override
        public void fail(Call call, IOException e) {
        }
    }

    public void getMyInfo(String userid, final User user) {
//        GET /index.php?act=kbb&fun=users&type=pullAccountInfo&tag=wjk&userid=160687947&sign=ee3dd4651821d3a45f4329a86d459cb7 HTTP/1.1
        final String url = Config.getUrl( "kbb", "users", "wjk" ) + "&userid=" + userid + "&type=pullAccountInfo";

        LogUtils.Log_i( LoginActivity.class.getName(), url );

        OkHttpUtils.getInstance().get( url, new RequestCallBack<String>() {
            @Override
            public void sucess(Call call, String t) {
                Gson gson=new Gson();
                GetUserInfo getUserInfo=gson.fromJson( t,GetUserInfo.class );
                if (getUserInfo.getState()==200){
                    user.setAccountstr(getUserInfo.getAccounts().get( 0 ).getAccountstr());
                    user.setAvatar( getUserInfo.getAvatar() );
                    user.setEmail( getUserInfo.getEmail() );
                    user.setPushable( getUserInfo.getPushable() );
                    SharedPreferences sp = Config.getSP( LoginActivity.this );
                    sp.edit().putString( "phone", phone ).putString( "pas", pas ).putBoolean( "login", true ).commit();
                   Config.setUser( LoginActivity.this,user );
                    enterActivity( MainActivity.class );
                    finish();
                }else{
                    show( "出現錯誤" );
                }
            }

            @Override
            public void fail(Call call, IOException e) {
                LogUtils.Log_i(  LoginActivity.class.getName(), e.getMessage() );
            }
        } );
    }
}
