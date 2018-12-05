package kdxf.zzh.com.xueyaprojejct.login;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import kdxf.zzh.com.xueyaprojejct.MainActivity;
import kdxf.zzh.com.xueyaprojejct.R;
import kdxf.zzh.com.xueyaprojejct.bean.GetSms1;
import kdxf.zzh.com.xueyaprojejct.framework.BaseActivity;
import kdxf.zzh.com.xueyaprojejct.http.OkHttpUtils;
import kdxf.zzh.com.xueyaprojejct.http.RequestCallBack;
import kdxf.zzh.com.xueyaprojejct.utils.Config;
import kdxf.zzh.com.xueyaprojejct.utils.LogUtils;
import okhttp3.Call;

/**
 * Created by ASUS on 2018/11/9.
 */

public class NewPasswordActivity extends BaseActivity {

    private EditText ed_pas1;
    private EditText ed_pas2;
    private TextView tv_login2;
    private TextView input_pas;
    private ImageView iv_back;
    private GetSms1 bean;

    @Override
    public int initLayout() {
        return R.layout.activity_newpass;
    }

    @Override
    public void initView() {
        iv_back = findViewById( R.id.iv_back );
        iv_back.setVisibility( View.VISIBLE );
        TextView tv_title = findViewById( R.id.tv_title );
        tv_title.setText( "验证码确认" );
        ed_pas1 = findViewById( R.id.ed_pas1 );
        ed_pas2 = findViewById( R.id.ed_pas2 );
        tv_login2 = findViewById( R.id.tv_login2 );
        input_pas = findViewById( R.id.input_pas );
    }

    @Override
    public void initClick() {
        tv_login2.setOnClickListener( this );
    }

    @Override
    public void initlogic() {
        bean = (GetSms1) getIntent().getSerializableExtra( "object" );
        ed_pas1.addTextChangedListener( new PassTextWatcher() );
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iv_back:
                finish();
                break;
            case R.id.tv_login2:
                String pass1= Config.getText( ed_pas1 );
                String pass2= Config.getText( ed_pas2 );
                boolean falg=checkInfo( pass1,true );
                if (falg&&pass1.equals( pass2 )){
                    String url = Config.getUrl( "kbb", "resetProperty" ) ;
                    Map<String ,String> map=new HashMap<>(  );
                    map.put( "value", pass1);
                    map.put( "phonenum",bean.getData().getPhonenum() );
                    map.put( "code",bean.getSMScode() );
                    map.put( "userid",bean.getData().getUserid() );
                    map.put( "keyword","password");

                    OkHttpUtils.getInstance().post( url,map, new RequestCallBack<String>() {
                        @Override
                        public void sucess(Call call, String t) {
                            LogUtils.Log_i( NewPasswordActivity.class.getName(), t );
                            try {
                                JSONObject object=new JSONObject( t );
                            int code=object.optInt( "state" );
                            if (code==200){
                                enterActivity( MainActivity.class );
                            }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                        }

                        @Override
                        public void fail(Call call, IOException e) {

                        }
                    } );
                }else {
                    show( "密码不一致" );
                }

                break;
        }
    }
    private boolean checkInfo(String pass, boolean falg) {
        if (falg) {
             if (!Pattern.matches( Config.PAS_MATCH, pass )) {
                show( "请输入正确的密码" );
                return false;
            }
        } else {
            if (!Pattern.matches( Config.PAS_MATCH, pass )) {
                return false;
            }
        }
        return true;
    }
    public class PassTextWatcher implements TextWatcher{

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
                input_pas.setText( "" );
                input_pas.setBackgroundResource( R.mipmap.checkbox_press );
            } else {
                if (len == 0) {
                    input_pas.setText( getText( R.string.input_phone ) );
                } else {
                    input_pas.setText( "" );
                }
                input_pas.setBackgroundResource( R.color.white );
            }
        }
    }

}
