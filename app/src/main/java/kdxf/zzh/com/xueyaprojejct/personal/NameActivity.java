package kdxf.zzh.com.xueyaprojejct.personal;

import android.view.View;
import android.widget.ImageView;

import kdxf.zzh.com.xueyaprojejct.R;
import kdxf.zzh.com.xueyaprojejct.framework.BaseActivity;

/**
 * Created by ASUS on 2018/11/11.
 */

public class NameActivity extends BaseActivity implements View.OnClickListener{

    private ImageView iv_back;

    @Override
    public int initLayout() {
        return R.layout.activity_name;
    }

    @Override
    public void initView() {
        iv_back = findViewById( R.id.iv_back );
    }

    @Override
    public void initClick() {
        iv_back.setOnClickListener( this );
    }

    @Override
    public void initlogic() {

    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.iv_back:
                finish();
                break;
        }
    }
}
