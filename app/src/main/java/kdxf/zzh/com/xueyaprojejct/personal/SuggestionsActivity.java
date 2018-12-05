package kdxf.zzh.com.xueyaprojejct.personal;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import kdxf.zzh.com.xueyaprojejct.R;
import kdxf.zzh.com.xueyaprojejct.bean.User;
import kdxf.zzh.com.xueyaprojejct.framework.BaseActivity;
import kdxf.zzh.com.xueyaprojejct.http.OkHttpUtils;
import kdxf.zzh.com.xueyaprojejct.http.RequestCallBack;
import kdxf.zzh.com.xueyaprojejct.utils.Config;
import kdxf.zzh.com.xueyaprojejct.utils.LogUtils;
import okhttp3.Call;

/**
 * Created by ASUS on 2018/11/13.
 */

public class SuggestionsActivity extends BaseActivity implements View.OnClickListener {

    private ImageView iv_back;
    private TextView tv_save;
    private EditText ed_suggestions;
    private TextView tv_change;
    private User user;

    @Override
    public int initLayout() {
        return R.layout.activity_suggestions;
    }

    @Override
    public void initView() {
        TextView tv_title = findViewById( R.id.tv_title );
        tv_title.setText( "意见反馈" );
        iv_back = findViewById( R.id.iv_back );
        tv_save = findViewById( R.id.tv_save );
        tv_save.setText( "发送" );
        ed_suggestions = findViewById( R.id.ed_suggestions );
        tv_change = findViewById( R.id.tv_change );
    }

    @Override
    public void initClick() {
        iv_back.setOnClickListener( this );
        tv_save.setOnClickListener( this );
        ed_suggestions.addTextChangedListener( new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                tv_change.setText( s.length() + "" );
                if (s.length() == 600) {
                    show( "字数已达到上线" );
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        } );

    }

    @Override
    public void initlogic() {
        user = Config.getUser( SuggestionsActivity.this );
    }

    @Override
    public void onClick(View v) {
        super.onClick( v );
        switch (v.getId()) {
            case R.id.iv_back:
                finish();
            case R.id.tv_save:
                if (ed_suggestions.getText().toString().isEmpty()){
                    show( "您还没有写建议呢~" );
                    return;
                }
//  POST /index.php?&tag=BloodAndroid&sign=2c19b2821ebc5306c3ac37bac5b4288b&act=kbb&fun=user_feedback HTTP/1.1
                String url = Config.getUrl( "kbb", "user_feedback" );
                Map<String,String> map=new HashMap<>(  );
                map.put( "apptype","10004");
                map.put( "content",ed_suggestions.getText().toString());
                map.put( "userid", user.getUserid());
                OkHttpUtils.getInstance().post( url, map, new RequestCallBack<String>() {
                    @Override
                    public void sucess(Call call, String t) {
                        LogUtils.Log_i( SuggestionsActivity.class.getName(),t );
                    }

                    @Override
                    public void fail(Call call, IOException e) {

                    }
                } );
                break;
        }
    }
}
