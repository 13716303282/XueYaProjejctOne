package kdxf.zzh.com.xueyaprojejct.doctoronline;

import android.view.LayoutInflater;
import android.view.View;

import java.io.IOException;

import kdxf.zzh.com.xueyaprojejct.R;
import kdxf.zzh.com.xueyaprojejct.framework.BaseFragment;
import kdxf.zzh.com.xueyaprojejct.http.OkHttpUtils;
import kdxf.zzh.com.xueyaprojejct.http.RequestCallBack;
import kdxf.zzh.com.xueyaprojejct.utils.Config;
import kdxf.zzh.com.xueyaprojejct.utils.LogUtils;
import okhttp3.Call;

/**
 * Created by ASUS on 2018/11/20.
 */

public class ReplyFragment extends BaseFragment {
    @Override
    public View getView(LayoutInflater inflater) {
        return inflater.inflate( R.layout.fragment_reply,null );
    }

    @Override
    public void initView(View view) {

    }

    @Override
    public void initClick() {

    }

    @Override
    public void initLogic() {

//     GET /index.php?&tag=BloodAndroid&sign=2c19b2821ebc5306c3ac37bac5b4288b&act=zhuanjia
//     &fun=DoctorRely&expertid=8143&pageNum=1&pageCount=20 HTTP/1.11
        String url= Config.getUrl( "zhuanjia","DoctorRely" )+"&expertid=8143&pageNum=1&pageCount=20";
        OkHttpUtils.getInstance().get( url, new RequestCallBack<String>() {
            @Override
            public void sucess(Call call, String t) {
                LogUtils.Log_i( "ReplyFragment",t);
                show( "专家回复为空" );
            }

            @Override
            public void fail(Call call, IOException e) {

            }
        } );
    }
}
