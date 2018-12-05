package kdxf.zzh.com.xueyaprojejct.login;

import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import kdxf.zzh.com.xueyaprojejct.MainActivity;
import kdxf.zzh.com.xueyaprojejct.R;
import kdxf.zzh.com.xueyaprojejct.bean.User;
import kdxf.zzh.com.xueyaprojejct.framework.BaseActivity;
import kdxf.zzh.com.xueyaprojejct.http.OkHttpUtils;
import kdxf.zzh.com.xueyaprojejct.http.RequestCallBack;
import kdxf.zzh.com.xueyaprojejct.utils.Config;
import okhttp3.Call;

/**
 * Created by ASUS on 2018/11/6.
 */

public class WelcomeActivity extends BaseActivity {

    private ImageView iv_welcome;

    @Override
    public int initLayout() {
        return R.layout.activity_welcome;
    }

    @Override
    public void initView() {
        iv_welcome = findViewById( R.id.iv_welcome );
    }

    @Override
    public void initClick() {

    }

    @Override
    public void initlogic() {
        AlphaAnimation animation = new AlphaAnimation( 0, 1 );
        animation.setDuration( 2000 );
        animation.setAnimationListener( new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                if (Config.isLogin(WelcomeActivity.this)){
                    login();
                }else {
                    enterActivity( LoginActivity.class );
                }
                finish();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        } );
        iv_welcome.setAnimation( animation );
//        animation.start();
    }

    public void login() {
        String url= Config.getUrl( "kbb","users" )+"&type=login";
        Map<String ,String > map=new HashMap<>(  );
        map.put( "phonenum",Config.getSP( WelcomeActivity.this ).getString( "phone","") );
        map.put( "password",Config.getSP( WelcomeActivity.this ).getString( "pas","") );
        OkHttpUtils.getInstance().post( url,map,new AA() );
    }

    public class AA implements RequestCallBack<String> {

        @Override
        public void sucess(Call call, String t) {
            Gson gson = new Gson();
            User user = gson.fromJson( t, User.class );
            if (user.getState() == 200) {
                enterActivity( MainActivity.class );
            } else {
                show( "格式错误" );
            }

        }

        @Override
        public void fail(Call call, IOException e) {
            show( "数据错误" );
        }
    }
}
