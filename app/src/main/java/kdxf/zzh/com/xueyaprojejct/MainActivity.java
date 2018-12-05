package kdxf.zzh.com.xueyaprojejct;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import kdxf.zzh.com.xueyaprojejct.adapter.MyFragmentAdapter;
import kdxf.zzh.com.xueyaprojejct.bloodmanger.BloodMangerFragment;
import kdxf.zzh.com.xueyaprojejct.doctoronline.DoctorOnlineFragment;
import kdxf.zzh.com.xueyaprojejct.personal.PersonalFragment;

public class MainActivity extends FragmentActivity implements View.OnClickListener {

    private FragmentTransaction transaction;
    private TextView doctor;
    private TextView blood;
    private TextView personal;
    private ViewPager viewapge;
    private DoctorOnlineFragment doctorOnlineFragment;
    private BloodMangerFragment bloodMangerFragment;
    private PersonalFragment personalFragment;
    private FragmentManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        initView();
        initClick();
        initlogic();
    }

    private void initlogic() {
        List<Fragment> list = new ArrayList<>();
        doctorOnlineFragment = new DoctorOnlineFragment();
        bloodMangerFragment = new BloodMangerFragment();
        personalFragment = new PersonalFragment();

        list.add( doctorOnlineFragment );
        list.add( bloodMangerFragment );
        list.add( personalFragment );
        manager = getSupportFragmentManager();
        MyFragmentAdapter adapter = new MyFragmentAdapter( manager, MainActivity.this, list );
        viewapge.setAdapter( adapter );
        setCurrentZeron();
    }

    private void initClick() {
        doctor.setOnClickListener( this );
        blood.setOnClickListener( this );
        personal.setOnClickListener( this );
    }

    private void initView() {
        doctor = findViewById( R.id.doctor );
        blood = findViewById( R.id.blood );
        personal = findViewById( R.id.personal );

        viewapge = findViewById( R.id.viewapge );
    }

    @Override
    public void onClick(View v) {
        hide();
        switch (v.getId()){
            case R.id.doctor:
                setCurrentZeron();
                break;
            case R.id.blood:
                viewapge.setCurrentItem(1);
                setDrawable(doctor,R.mipmap.doctor_head_normal,R.color.personal);
                setDrawable(blood,R.mipmap.blood_manger_press,R.color.colortheme);
                setDrawable(personal,R.mipmap.persional_normal,R.color.personal);
                break;
            case R.id.personal:
                viewapge.setCurrentItem(2);
                setDrawable(doctor,R.mipmap.doctor_head_normal,R.color.personal);
                setDrawable(blood,R.mipmap.blood_manger_normal,R.color.personal);
                setDrawable(personal,R.mipmap.persional_press,R.color.colortheme);
                break;
        }
    }



    public void setDrawable(TextView textView, int Resourid, int colorid) {
        Drawable drawable = getResources().getDrawable( Resourid );
        drawable.setBounds( 0, 0, drawable.getMinimumHeight(), drawable.getMinimumWidth() );
        textView.setCompoundDrawables( null, drawable, null, null );
        textView.setTextColor(getResources().getColor( colorid ) );
    }
    public void  setCurrentZeron(){
        viewapge.setCurrentItem(0);
        setDrawable(doctor,R.mipmap.doctor_head_press,R.color.colortheme);
        setDrawable(blood,R.mipmap.blood_manger_normal,R.color.personal);
        setDrawable(personal,R.mipmap.persional_normal,R.color.personal);
    }
    public  void   hide(){
        if(transaction==null){
            transaction = manager.beginTransaction();
        }

        if(doctorOnlineFragment!=null){
            transaction.hide(doctorOnlineFragment);
        }
        if(bloodMangerFragment!=null){
            transaction.hide(bloodMangerFragment);
        }
        if(personalFragment!=null){
            transaction.hide(personalFragment);
        }
    }
}
