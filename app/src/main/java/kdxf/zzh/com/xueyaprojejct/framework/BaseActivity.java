package kdxf.zzh.com.xueyaprojejct.framework;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

import kdxf.zzh.com.xueyaprojejct.bean.SerObject;

/**
 * Created by ASUS on 2018/11/6.
 */

public  abstract class  BaseActivity extends FragmentActivity implements View.OnClickListener{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( initLayout() );
        initView();
        initClick();
        initlogic();
    }
    public  abstract  int initLayout();
    public  abstract  void  initView();
    public  abstract  void  initClick();
    public  abstract  void  initlogic();

    public  void  enterActivity(Class clazz){
        Intent intent=new Intent( BaseActivity.this,clazz );
        startActivity( intent );
    }
    public  void  enterActivity(Class clazz, SerObject object){
        Intent intent=new Intent( BaseActivity.this,clazz );
        intent.putExtra( "object",object );
        startActivity( intent );
    }
    @Override
    public void onClick(View v) {

    }
    public  void show(final String msg){
        handler.post( new Runnable() {
            @Override
            public void run() {
                Toast toast= Toast.makeText( BaseActivity.this, msg, Toast.LENGTH_SHORT );
                toast.setGravity( Gravity.CENTER,0,0 );
                toast.show();
            }
        } );

    }

    public Handler  handler=new Handler(  );
}
