package kdxf.zzh.com.xueyaprojejct.login;

import android.os.CountDownTimer;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import kdxf.zzh.com.xueyaprojejct.R;
import kdxf.zzh.com.xueyaprojejct.bean.GetSmsBean;
import kdxf.zzh.com.xueyaprojejct.framework.BaseActivity;
import kdxf.zzh.com.xueyaprojejct.http.OkHttpUtils;
import kdxf.zzh.com.xueyaprojejct.http.RequestCallBack;
import kdxf.zzh.com.xueyaprojejct.utils.Config;
import kdxf.zzh.com.xueyaprojejct.utils.LogUtils;
import okhttp3.Call;

/**
 * Created by ASUS on 2018/11/8.
 */

public class RegisterTwoActivity extends BaseActivity {

    private EditText ed_input_code;
    private TextView tv_time;
    private TextView tv_bangding;
    private GetSmsBean bean;

    @Override
    public int initLayout() {
        return R.layout.activity_register_two;
    }

    @Override
    public void initView() {
        ed_input_code = findViewById( R.id.ed_input_code );
        tv_time = findViewById( R.id.tv_time );
        tv_bangding = findViewById( R.id.tv_bangding );

    }

    @Override
    public void initClick() {
        tv_bangding.setOnClickListener( this );
        new CountDownTimer( 60000, 1000 ) {
            @Override
            public void onTick(long millisUntilFinished) {
                tv_bangding.setClickable( true );
                tv_time.setText( "接收短信大约需要" + millisUntilFinished/1000 + "秒" );
            }

            @Override
            public void onFinish() {
                finish();
            }
        }.start();
    }

    @Override
    public void initlogic() {
        bean = (GetSmsBean) getIntent().getSerializableExtra( "object" );
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_bangding:
                String code = Config.getText( ed_input_code );
                LastBangdingSmscode(code);
                break;
        }
    }

    private void LastBangdingSmscode(String code) {
        String url=Config.getRegisterUrl( "kbb","users" )+"&type=registAccount";
        Map<String,String> map=new HashMap<>(  );
        map.put("phonenum", bean.getPhone());
        map.put("password", bean.getPass());
        map.put("accountstr", bean.getName());
        map.put("code", code);
        map.put("test", "2");
        map.put("height", "0");
        map.put("birthday", System.currentTimeMillis()+"");
        OkHttpUtils.getInstance().post( url, map, new RequestCallBack<String>() {
            @Override
            public void sucess(Call call, String t) {
                LogUtils.Log_i( RegisterTwoActivity.class.getName(),t );
            }

            @Override
            public void fail(Call call, IOException e) {

            }
        } );
    }
}
