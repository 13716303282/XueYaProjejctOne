package kdxf.zzh.com.xueyaprojejct.doctoronline;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import kdxf.zzh.com.xueyaprojejct.R;
import kdxf.zzh.com.xueyaprojejct.framework.BaseActivity;

/**
 * Created by ASUS on 2018/11/15.
 */

public class DoctorTitleActivity extends BaseActivity implements View.OnClickListener {
    private  String title="不限";
    private TextView tv_physician;
    private TextView tv_chief_doctor;
    private TextView tv_chief_physician;
    private TextView tv_deputy_chief_physician;
    private TextView tv_buxian;
    private TextView tv_sure;

    @Override
    public int initLayout() {
        return R.layout.activity_doctor_title;
    }

    @Override
    public void initView() {
        tv_physician = findViewById( R.id.tv_physician );
        tv_chief_doctor = findViewById( R.id.tv_chief_doctor );
        tv_chief_physician = findViewById( R.id.tv_chief_physician );
        tv_deputy_chief_physician = findViewById( R.id.tv_deputy_chief_physician );
        tv_buxian = findViewById( R.id.tv_buxian );
        tv_sure = findViewById( R.id.tv_sure );
    }

    @Override
    public void initClick() {
        tv_physician.setOnClickListener( this );
        tv_chief_doctor.setOnClickListener( this );
        tv_chief_physician.setOnClickListener( this );
        tv_deputy_chief_physician.setOnClickListener( this );
        tv_buxian.setOnClickListener( this );
        tv_sure.setOnClickListener( this );
    }

    @Override
    public void initlogic() {

    }

    @Override
    public void onClick(View v) {
        super.onClick( v );
        switch (v.getId()){
            case R.id.tv_buxian:
                setAllBackground();
                setBackground(tv_buxian, R.color.huise);
                title=tv_buxian.getText().toString();
                break;
            case R.id.tv_physician:
                setAllBackground();
                setBackground(tv_physician, R.color.huise);
                title=tv_physician.getText().toString();
                break;
            case R.id.tv_chief_doctor:
                setAllBackground();
                setBackground(tv_chief_doctor, R.color.huise);
                title=tv_chief_doctor.getText().toString();
                break;
            case R.id.tv_chief_physician:
                setAllBackground();
                setBackground(tv_chief_physician, R.color.huise);
                title=tv_chief_physician.getText().toString();
                break;
            case R.id.tv_deputy_chief_physician:
                setAllBackground();
                setBackground(tv_deputy_chief_physician, R.color.huise);
                title=tv_deputy_chief_physician.getText().toString();
                break;
            case R.id.tv_sure:
                Intent intent = new Intent();
                intent.putExtra("title_string", title);
                setResult(RESULT_OK, intent);
                finish();
                break;

        }
    }
    private void setBackground(View view, int resId){
        view.setBackgroundResource( resId );
    }

    private void setAllBackground(){
        setBackground(tv_buxian, R.color.white);
        setBackground(tv_physician, R.color.white);
        setBackground(tv_chief_doctor, R.color.white);
        setBackground(tv_chief_physician, R.color.white);
        setBackground(tv_deputy_chief_physician, R.color.white);
    }

}
