package kdxf.zzh.com.xueyaprojejct.doctoronline;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import kdxf.zzh.com.xueyaprojejct.R;
import kdxf.zzh.com.xueyaprojejct.framework.BaseActivity;

/**
 * Created by ASUS on 2018/11/16.
 */

public class HospitalGradeActivity extends BaseActivity implements View.OnClickListener {

    private TextView tv_hospital_grade;
    private TextView tv_1;
    private TextView tv_2;
    private TextView tv_3;
    private TextView tv_4;
    private TextView tv_5;
    private TextView tv_6;
    private TextView tv_7;
    private TextView tv_8;
    private TextView tv_sure2;
    private String hospital_grade = "不限";

    @Override
    public int initLayout() {
        return R.layout.activity_hospital_grade;
    }

    @Override
    public void initView() {
        tv_hospital_grade = findViewById( R.id.tv_hospital_grade );
        tv_1 = findViewById( R.id.tv_1 );
        tv_2 = findViewById( R.id.tv_2 );
        tv_3 = findViewById( R.id.tv_3 );
        tv_4 = findViewById( R.id.tv_4 );
        tv_5 = findViewById( R.id.tv_5 );
        tv_6 = findViewById( R.id.tv_6 );
        tv_7 = findViewById( R.id.tv_7 );
        tv_8 = findViewById( R.id.tv_8 );
        tv_sure2 = findViewById( R.id.tv_sure2 );
    }

    @Override
    public void initClick() {
        tv_1.setOnClickListener( this );
        tv_2.setOnClickListener( this );
        tv_3.setOnClickListener( this );
        tv_4.setOnClickListener( this );
        tv_5.setOnClickListener( this );
        tv_6.setOnClickListener( this );
        tv_7.setOnClickListener( this );
        tv_8.setOnClickListener( this );
        tv_sure2.setOnClickListener( this );
    }

    @Override
    public void initlogic() {

    }

    @Override
    public void onClick(View v) {
        super.onClick( v );
        switch (v.getId()) {
            case R.id.tv_1:
                setAllBackground();
                setBackground( tv_1, R.color.huise );
                hospital_grade=tv_1.getText().toString();
                break;
            case R.id.tv_2:
                setAllBackground();
                setBackground( tv_2, R.color.huise );
                hospital_grade=tv_2.getText().toString();
                break;
            case R.id.tv_3:
                setAllBackground();
                setBackground( tv_3, R.color.huise );
                hospital_grade=tv_3.getText().toString();
                break;
            case R.id.tv_4:
                setAllBackground();
                setBackground( tv_4, R.color.huise );
                hospital_grade=tv_4.getText().toString();
                break;
            case R.id.tv_5:
                setAllBackground();
                setBackground( tv_5, R.color.huise );
                hospital_grade=tv_5.getText().toString();
                break;
            case R.id.tv_6:
                setAllBackground();
                setBackground( tv_6, R.color.huise );
                hospital_grade=tv_6.getText().toString();
                break;
            case R.id.tv_7:
                setAllBackground();
                setBackground( tv_7, R.color.huise );
                hospital_grade=tv_7.getText().toString();
                break;
            case R.id.tv_8:
                setAllBackground();
                setBackground( tv_8, R.color.huise );
                hospital_grade=tv_8.getText().toString();
                break;
            case R.id.tv_sure2:
                Intent intent = new Intent();
                intent.putExtra("grade_string", hospital_grade);
                setResult(RESULT_OK, intent);
                finish();
                break;
        }
    }

    private void setBackground(View view, int resId) {
        view.setBackgroundResource( resId );
    }

    private void setAllBackground() {
        setBackground( tv_1, R.color.white );
        setBackground( tv_2, R.color.white );
        setBackground( tv_3, R.color.white );
        setBackground( tv_4, R.color.white );
        setBackground( tv_5, R.color.white );
        setBackground( tv_6, R.color.white );
        setBackground( tv_7, R.color.white );
        setBackground( tv_8, R.color.white );
    }
}
