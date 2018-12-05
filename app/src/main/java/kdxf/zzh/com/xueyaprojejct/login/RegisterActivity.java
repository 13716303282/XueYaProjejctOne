package kdxf.zzh.com.xueyaprojejct.login;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.regex.Pattern;

import kdxf.zzh.com.xueyaprojejct.R;
import kdxf.zzh.com.xueyaprojejct.bean.GetSmsBean;
import kdxf.zzh.com.xueyaprojejct.framework.BaseActivity;
import kdxf.zzh.com.xueyaprojejct.http.OkHttpUtils;
import kdxf.zzh.com.xueyaprojejct.http.RequestCallBack;
import kdxf.zzh.com.xueyaprojejct.utils.Config;
import kdxf.zzh.com.xueyaprojejct.utils.LogUtils;
import okhttp3.Call;

/**
 * Created by ASUS on 2018/11/6.
 */

public class RegisterActivity extends BaseActivity {

    private EditText ed_name;
    private EditText ed_pass;
    private EditText ed_phone;
    private TextView tv_input_name;
    private TextView tv_input_phone;
    private TextView tv_input_pas;
    private TextView tv_send;
    private ImageView iv_back;

    @Override
    public int initLayout() {
        return R.layout.activty_register;
    }

    @Override
    public void initView() {
        iv_back = findViewById( R.id.iv_back );
        iv_back.setVisibility( View.VISIBLE );
        TextView tv_title = findViewById( R.id.tv_title );
        tv_title.setText( "快速注册" );
        ed_name = findViewById( R.id.ed_name );
        ed_phone = findViewById( R.id.ed_phone );

        ed_pass = findViewById( R.id.ed_pass );

        tv_input_name = findViewById( R.id.tv_input_name );
        tv_input_phone = findViewById( R.id.tv_input_phone );
        tv_input_pas = findViewById( R.id.tv_input_pas );
        tv_send = findViewById( R.id.tv_send );
    }

    @Override
    public void initClick() {
//        tv_input_name.setOnClickListener( this );
//        tv_input_phone.setOnClickListener( this );
//        tv_input_pas.setOnClickListener( this );
        tv_send.setOnClickListener( this );
        iv_back.setOnClickListener( this );
    }

    @Override
    public void initlogic() {
        ed_phone.addTextChangedListener( new PhoneTextWatcher() );
        ed_pass.addTextChangedListener( new PasTextWatcher() );
        ed_name.addTextChangedListener( new NameTextWatcher() );

    }
    public class NameTextWatcher implements TextWatcher {

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            int len = s.length();
            if (Pattern.matches( Config.NAME_MATCH, s.toString() )) {
                tv_input_name.setText( "" );
                tv_input_name.setBackgroundResource( R.mipmap.checkbox_press );
            } else {
                if (len == 0) {
                    tv_input_name.setText( getText( R.string.input_name ) );
                } else {
                    tv_input_name.setText( "" );
                }
                tv_input_name.setBackgroundResource( R.color.white );

            }

            check_send_button();
        }
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
            if (Pattern.matches( Config.PAS_MATCH, s.toString() )) {
                tv_input_pas.setText( "" );
                tv_input_pas.setBackgroundResource( R.mipmap.checkbox_press );
            } else {
                if (len == 0) {
                    tv_input_pas.setText( getText( R.string.input_pas ) );
                } else {
                    tv_input_pas.setText( "" );
                }
                tv_input_pas.setBackgroundResource( R.color.white );

            }
            check_send_button();
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
//            if (len == 11) {
//                tv_input_phone.setText( "" );
//                tv_input_phone.setBackgroundResource( R.mipmap.checkbox_press );
//            } else {
//                if (len == 0) {
//                    tv_input_phone.setText( getText( R.string.input_phone ) );
//                } else {
//                    tv_input_phone.setText( "" );
//                }
//                tv_input_phone.setBackgroundResource( R.color.white );
//            }

            if(Pattern.matches( Config.PHONE_MATCH,s.toString() )){
                tv_input_phone.setText( "" );
                tv_input_phone.setBackgroundResource( R.mipmap.checkbox_press );
            }else{
                if (len == 0) {
                    tv_input_phone.setText( getText( R.string.input_phone ) );
                } else {
                    tv_input_phone.setText( "" );
                }
                   tv_input_phone.setBackgroundResource( R.color.white );
            }

            check_send_button();

        }

    }


    public  void  check_send_button(){
         String name = Config.getText( ed_name );
         String phone = Config.getText( ed_phone );
         String pass = Config.getText( ed_pass );
        boolean falg= checkInfo( name, phone, pass,false );
        if(falg){
            tv_send.setClickable( true );
            tv_send.setBackgroundColor( getResources().getColor( R.color.colortheme ) );
        }else{
            tv_send.setClickable( false );
            tv_send.setBackgroundColor( getResources().getColor( R.color.huise) );
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.tv_send:
                final String name = Config.getText( ed_name );
                final String phone = Config.getText( ed_phone );
                final String pass = Config.getText( ed_pass );
                final boolean flag = checkInfo( name, phone, pass ,true);
                if (flag) {

                    //发送验证码请求
                    String url = Config.getUrl( "sms", "sendCode" ) + "&target=" + phone + "&type=4";
                    OkHttpUtils.getInstance().get( url, new RequestCallBack<String>() {
                        @Override
                        public void sucess(Call call,final String t) {
                            LogUtils.Log_i( RegisterActivity.class.getName(), t );


                                    Gson gson = new Gson();
                                    GetSmsBean getSmsBean = gson.fromJson( t, GetSmsBean.class );

                                    if (getSmsBean.getCode() == 10000) {
                                        getSmsBean.setName( name );
                                        getSmsBean.setPhone( phone );
                                        getSmsBean.setPass( pass );
                                        enterActivity( RegisterTwoActivity.class, getSmsBean );
                                    } else {
                                        show( getSmsBean.getError() );
                                    }

                        }

                        @Override
                        public void fail(Call call, IOException e) {

                        }
                    } );

                }

                break;

        }
    }

    /**
     *
     * @param name
     * @param phone
     * @param Pass
     * @param falg  判断是否是点击事件
     * @return
     */
    private boolean checkInfo(String name, String phone, String Pass,boolean falg) {

        if(falg){
        if (!Pattern.matches( Config.NAME_MATCH, name )) {
            show( "请输入正确的名字" );
            return false;
        }
        if (!Pattern.matches( Config.PHONE_MATCH, phone )) {
            show( "请输入正确的手机号码" );
            return false;
        }
        if (!Pattern.matches( Config.PAS_MATCH, Pass )) {
            show( "请输入正确的密码" );
            return false;
        }
        }else{
            if (!Pattern.matches( Config.NAME_MATCH, name )) {
                return false;
            }
            if (!Pattern.matches( Config.PHONE_MATCH, phone )) {
                return false;
            }
            if (!Pattern.matches( Config.PAS_MATCH, Pass )) {
                return false;
            }
        }
        return  true;
    }
}
