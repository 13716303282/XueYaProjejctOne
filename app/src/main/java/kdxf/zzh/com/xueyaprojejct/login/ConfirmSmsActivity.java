package kdxf.zzh.com.xueyaprojejct.login;

import android.os.CountDownTimer;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;

import java.io.IOException;

import kdxf.zzh.com.xueyaprojejct.R;
import kdxf.zzh.com.xueyaprojejct.bean.GetSms1;
import kdxf.zzh.com.xueyaprojejct.framework.BaseActivity;
import kdxf.zzh.com.xueyaprojejct.http.OkHttpUtils;
import kdxf.zzh.com.xueyaprojejct.http.RequestCallBack;
import kdxf.zzh.com.xueyaprojejct.utils.Config;
import okhttp3.Call;

/**
 * Created by ASUS on 2018/11/9.
 */

public class ConfirmSmsActivity extends BaseActivity {

    private TextView tv_confirmSms;
    private TextView tv_phone2;
    private TextView tv_time;
    private ImageView iv_back;
    private EditText ed_input_code;

    @Override
    public int initLayout() {
        return R.layout.activity_register_three;
    }

    @Override
    public void initView() {
        iv_back = findViewById( R.id.iv_back );
        iv_back.setVisibility( View.VISIBLE );
        TextView tv_title = findViewById( R.id.tv_title );
        tv_title.setText( "验证码确认" );
        tv_confirmSms = findViewById( R.id.tv_confirmSms );
        tv_phone2 = findViewById( R.id.tv_phone2 );
        tv_phone2.setText( getIntent().getStringExtra( "phone" ) );
        tv_time = findViewById( R.id.tv_time );
        ed_input_code = findViewById( R.id.ed_input_code );

    }

    @Override
    public void initClick() {
        tv_time.setOnClickListener( this );
        iv_back.setOnClickListener( this );
        tv_confirmSms.setOnClickListener( this );
        new CountDownTimer( 60000, 1000 ) {
            @Override
            public void onTick(long millisUntilFinished) {
                tv_time.setClickable( true );
                tv_time.setText( "接收短信大约需要" + millisUntilFinished / 1000 + "秒" );
            }

            @Override
            public void onFinish() {
                finish();
            }
        }.start();
    }

    @Override
    public void initlogic() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.tv_confirmSms:

                String phone=getIntent().getStringExtra( "phone" );
                final String SMS= Config.getText( ed_input_code );
                String ID=getIntent().getStringExtra( "id" );
                String url = Config.getUrl( "sms", "verifyCode" ) + "&target=" + phone +"&code="+SMS+ "&type=2"+"&PHPSESSID="+ID;
                OkHttpUtils.getInstance().get( url, new RequestCallBack<String>() {
                    @Override
                    public void sucess(Call call, String t) {
                        Gson gson=new Gson();
                       GetSms1 getSms1= gson.fromJson( t, GetSms1.class );
                       if (getSms1.getCode()==10000){
                           getSms1.setSMScode( SMS );
                           enterActivity( NewPasswordActivity.class,getSms1 );
                       }else {
                           show( getSms1.getError() );
                       }
                    }

                    @Override
                    public void fail(Call call, IOException e) {

                    }
                } );


//                enterActivity( NewPasswordActivity.class,sms);
                break;
        }

    }
}
