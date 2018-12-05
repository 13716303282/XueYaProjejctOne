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

public class AboutBloodActivity extends BaseActivity implements View.OnClickListener{

    private RelativeLayout re_score;
    private RelativeLayout re_suggestions;
    private ImageView iv_back;

    @Override
    public int initLayout() {
        return R.layout.activity_about;
    }

    @Override
    public void initView() {
        TextView tv_title = findViewById( R.id.tv_title );
        tv_title.setText( "关于血压卫士" );
        re_score = findViewById( R.id.re_score );
        re_suggestions = findViewById( R.id.re_suggestions );
        iv_back = findViewById( R.id.iv_back );
    }

    @Override
    public void initClick() {
        re_score.setOnClickListener( this );
        re_suggestions.setOnClickListener( this );
        iv_back.setOnClickListener( this );
    }

    @Override
    public void initlogic() {

    }

    @Override
    public void onClick(View v) {
        super.onClick( v );
        switch (v.getId()){
            case R.id.re_suggestions:
                enterActivity( SuggestionsActivity.class );
                break;
            case R.id.iv_back:
                finish();
        }
    }
}
