package kdxf.zzh.com.xueyaprojejct.login;

import android.content.Intent;
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
import kdxf.zzh.com.xueyaprojejct.bean.GetForgetSms;
import kdxf.zzh.com.xueyaprojejct.framework.BaseActivity;
import kdxf.zzh.com.xueyaprojejct.http.OkHttpUtils;
import kdxf.zzh.com.xueyaprojejct.http.RequestCallBack;
import kdxf.zzh.com.xueyaprojejct.utils.Config;
import kdxf.zzh.com.xueyaprojejct.utils.LogUtils;
import okhttp3.Call;

/**
 * Created by ASUS on 2018/11/6.
 */

public class ForgetActivity extends BaseActivity {

    private TextView tv_sendSms;
    private ImageView iv_back;
    private TextView input_phone;
    private EditText ed_phone;

    @Override
    public int initLayout() {
        return R.layout.activity_forget;
    }

    @Override
    public void initView() {
        iv_back = findViewById( R.id.iv_back );
        iv_back.setVisibility( View.VISIBLE );
        TextView tv_title = findViewById( R.id.tv_title );
        tv_title.setText( "忘记密码" );
        tv_sendSms = findViewById( R.id.tv_sendSms );
        input_phone = findViewById( R.id.input_phone );
        ed_phone = findViewById( R.id.ed_phone );
    }

    @Override
    public void initClick() {
        iv_back.setOnClickListener( this );
        tv_sendSms.setOnClickListener( this );
    }

    @Override
    public void initlogic() {
        ed_phone.addTextChangedListener( new PhoneTextWatcher() );
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
            if (Pattern.matches( Config.PHONE_MATCH, s.toString() )) {
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
            check_send_button();
        }
    }

    public void check_send_button() {
        String phone = Config.getText( ed_phone );
        boolean falg = checkInfo( phone, false );
        if (falg) {
            tv_sendSms.setClickable( true );
            tv_sendSms.setBackgroundColor( getResources().getColor( R.color.colortheme ) );
        } else {
            tv_sendSms.setClickable( false );
            tv_sendSms.setBackgroundColor( getResources().getColor( R.color.huise ) );
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.tv_sendSms:
                final String phone = Config.getText( ed_phone );
                boolean flag = checkInfo( phone, true );
                if (flag) {
                    String url = Config.getUrl( "sms", "sendCode" ) + "&target=" + phone + "&type=2";
                    OkHttpUtils.getInstance().get( url, new RequestCallBack<String>() {
                        @Override
                        public void sucess(Call call, String t) {
                            LogUtils.Log_i( ForgetActivity.class.getName(), t );

                            Gson gson = new Gson();
                            GetForgetSms forgetSms = gson.fromJson( t, GetForgetSms.class );
                            if (forgetSms.getCode() == 10000) {
                                forgetSms.setPhone( phone );
//                                enterActivity( ConfirmSmsActivity.class, forgetSms );
                                Intent intent=new Intent( ForgetActivity.this,ConfirmSmsActivity.class );
                                intent.putExtra( "phone",phone );
                                intent.putExtra( "id",forgetSms.getId() );
                                startActivity( intent );
                            }else {
                                show( forgetSms.getError() );
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

    private boolean checkInfo(String phone, boolean falg) {
        if (falg) {
            if (!Pattern.matches( Config.PHONE_MATCH, phone )) {
                show( "请输入正确的手机号码" );
                return false;
            }
        } else {
            if (!Pattern.matches( Config.PHONE_MATCH, phone )) {
                return false;
            }
        }
        return true;
    }
}
