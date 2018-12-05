package kdxf.zzh.com.xueyaprojejct.personal;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import kdxf.zzh.com.xueyaprojejct.R;
import kdxf.zzh.com.xueyaprojejct.framework.BaseActivity;

/**
 * Created by ASUS on 2018/11/13.
 */

public class SettingActivity extends BaseActivity implements View.OnClickListener{

    private RelativeLayout re_account;
    private RelativeLayout re_clear;
    private RelativeLayout re_about;
    private ImageView iv_back;

    @Override
    public int initLayout() {
        return R.layout.activity_setting;
    }

    @Override
    public void initView() {
        TextView tv_title = findViewById( R.id.tv_title );
        tv_title.setText( "设置" );
        re_account = findViewById( R.id.re_account );
        re_clear = findViewById( R.id.re_Clear );
        re_about = findViewById( R.id.re_about );
        iv_back = findViewById( R.id.iv_back );
    }

    @Override
    public void initClick() {
        re_account.setOnClickListener( this );
        re_clear.setOnClickListener( this );
        re_about.setOnClickListener( this );
        iv_back.setOnClickListener( this );
    }

    @Override
    public void initlogic() {

    }

    @Override
    public void onClick(View v) {
        super.onClick( v );
        switch (v.getId()){
            case R.id.re_about:
                enterActivity( AboutBloodActivity.class );
                break;
            case R.id.iv_back:
                finish();
        }
    }
}
