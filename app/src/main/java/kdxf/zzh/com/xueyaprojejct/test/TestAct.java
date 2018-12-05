package kdxf.zzh.com.xueyaprojejct.test;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.TextView;

import kdxf.zzh.com.xueyaprojejct.R;

/**
 * Created by ASUS on 2018/11/11.
 */

public class TestAct extends Activity {

    private NumberPicker nb;
    private String[] srt = {"男", "女"};
    private String sex = "";
    private Button xuanze;
    private TextView tv_sex;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.test_act );
        tv_sex = findViewById( R.id.tv_sex );

//        final Dialog test = new Dialog( TestAct.this );
//        View view = View.inflate( TestAct.this, R.activity_Doctor_title .test, null );
//        test.setContentView( view );



//        nb = view.findViewById( R.id.test_np );
//        xuanze = view.findViewById( R.id.test_button );
        nb.setMinValue( 0 );
        nb.setMaxValue( srt.length - 1 );
        nb.setDisplayedValues( srt );
        nb.setValue( 0 );
        nb.invalidate();
        nb.setOnValueChangedListener( new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                sex = srt[newVal];
            }
        } );

//        xuanze.setOnClickListener( new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                test.dismiss();
//                tv_sex.setText( "性别：  " + test );
//            }
//        } );
    }
}
