package kdxf.zzh.com.xueyaprojejct.doctoronline;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import kdxf.zzh.com.xueyaprojejct.R;
import kdxf.zzh.com.xueyaprojejct.bean.ExpertDetil;
import kdxf.zzh.com.xueyaprojejct.framework.BaseActivity;

/**
 * Created by ASUS on 2018/11/20.
 */

public class DoctorActivity extends BaseActivity implements View.OnClickListener {

    private ImageView iv_img;
    private TextView tv_name;
    private TextView tv_hospital;
    private TextView tv_title1;
    private TextView tv_department;
    private TextView tv_grade;
    private TextView tv_goodat;
    private ImageView iv_back;
    private FragmentManager manager;
    private ReplyFragment replyFragment;
    private TimetableFragment timetableFragment;
    private ShareFragment shareFragment;
    private FragmentTransaction transaction;
    private TextView tv_reply;
    private TextView tv_timetable;
    private TextView tv_share;
    private View v_1;
    private View v_2;
    private View v_3;

    @Override
    public int initLayout() {
        return R.layout.avtivity_doctor;
    }

    @Override
    public void initView() {
        ExpertDetil expertDetil = (ExpertDetil) getIntent().getSerializableExtra( "exper_data" );
        iv_back = findViewById( R.id.iv_back );
        TextView tv_save = findViewById( R.id.tv_save );
        tv_save.setVisibility( View.GONE );
        TextView tv_title = findViewById( R.id.tv_title );
        tv_title.setText( expertDetil.getName() );
        iv_img = findViewById( R.id.iv_img );
        Glide.with( DoctorActivity.this ).load( expertDetil.getApp_image() ).into( iv_img );
        tv_name = findViewById( R.id.tv_name );
        tv_name.setText( expertDetil.getName() );
        tv_hospital = findViewById( R.id.tv_hospital );
        tv_hospital.setText( expertDetil.getHospital() );
        tv_title1 = findViewById( R.id.tv_title1 );
        tv_title1.setText( expertDetil.getTitle() );
        tv_department = findViewById( R.id.tv_department );
        tv_department.setText( expertDetil.getDepart() );
        tv_grade = findViewById( R.id.tv_grade );
        tv_grade.setText( expertDetil.getTeach() );
        tv_goodat = findViewById( R.id.tv_goodat );
        tv_goodat.setText( expertDetil.getGoodat() );
        tv_reply = findViewById( R.id.tv_reply );
        tv_timetable = findViewById( R.id.tv_timetable );
        tv_share = findViewById( R.id.tv_share );
        v_1 = findViewById( R.id.v_1 );
        v_2 = findViewById( R.id.v_2 );
        v_3 = findViewById( R.id.v_3 );
    }

    @Override
    public void initClick() {
        iv_back.setOnClickListener( this );
        tv_reply.setOnClickListener( this );
        tv_timetable.setOnClickListener( this );
        tv_share.setOnClickListener( this );



    }

    @Override
    public void initlogic() {
        manager = getSupportFragmentManager();
        show();
    }

    private void show() {
        transaction = manager.beginTransaction();
        ReplyFragment replyFragment = new ReplyFragment();
        transaction.add( R.id.fram, replyFragment ).show( replyFragment ).commit();
    }

    @Override
    public void onClick(View v) {
        transaction = manager.beginTransaction();
        hide();
        hideline();
        super.onClick( v );
        switch (v.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.tv_reply:
                v_1.setVisibility( View.VISIBLE );
                if (replyFragment == null) {
                    replyFragment = new ReplyFragment();
                    transaction.add( R.id.fram, replyFragment ).show( replyFragment ).commit();
                }else {
                    transaction.show( replyFragment ).commit();
                }
                break;
            case R.id.tv_timetable:
                v_2.setVisibility( View.VISIBLE );
                if (timetableFragment == null) {
                    timetableFragment = new TimetableFragment();
                    transaction.add( R.id.fram, timetableFragment ).show( timetableFragment ).commit();
                }else {
                    transaction.show( timetableFragment ).commit();
                }
                break;
            case R.id.tv_share:
                v_3.setVisibility( View.VISIBLE );
                if (shareFragment == null) {
                    shareFragment = new ShareFragment();
                    transaction.add( R.id.fram, shareFragment ).show( shareFragment ).commit();
                }else {
                    transaction.show( shareFragment ).commit();
                }
                break;
        }
    }
    public  void hide(){
        if (replyFragment!=null){
            transaction.hide( replyFragment );
        }
        if (timetableFragment!=null){
            transaction.hide( timetableFragment );
        }
        if (shareFragment!=null){
            transaction.hide( shareFragment );
        }
    }
    public  void hideline() {
    v_1.setVisibility( View.INVISIBLE );
    v_2.setVisibility( View.INVISIBLE );
    v_3.setVisibility( View.INVISIBLE );
    }
}
