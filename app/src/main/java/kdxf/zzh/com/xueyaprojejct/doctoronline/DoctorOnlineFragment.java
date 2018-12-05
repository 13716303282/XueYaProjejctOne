package kdxf.zzh.com.xueyaprojejct.doctoronline;

import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import kdxf.zzh.com.xueyaprojejct.R;
import kdxf.zzh.com.xueyaprojejct.adapter.MyRecyclerViewAdapter;
import kdxf.zzh.com.xueyaprojejct.bean.Expert;
import kdxf.zzh.com.xueyaprojejct.bean.ExpertDetil;
import kdxf.zzh.com.xueyaprojejct.framework.BaseFragment;
import kdxf.zzh.com.xueyaprojejct.http.OkHttpUtils;
import kdxf.zzh.com.xueyaprojejct.http.RequestCallBack;
import kdxf.zzh.com.xueyaprojejct.utils.Config;
import kdxf.zzh.com.xueyaprojejct.utils.LogUtils;
import okhttp3.Call;

import static android.app.Activity.RESULT_OK;

/**
 * Created by ASUS on 2018/11/10.
 */

public class DoctorOnlineFragment extends BaseFragment implements View.OnClickListener {
    private boolean ischeck;
    private RelativeLayout re_province;
    private RelativeLayout re_title;
    private RelativeLayout re_grade;
    private RelativeLayout re_input;
    private LinearLayout ll_freeplus;
    private TextView tv_query;
    private TextView tv_ask;
    private TextView tv_adviser;
    private RecyclerView Recy;
    private MyRecyclerViewAdapter adapter;
    private GridLayoutManager manager;
    private TextView tv_province;
    private AMapLocationClient locationClient = null;
    private AMapLocationClientOption locationOption = null;
    private ImageView iv_location;
    private TextView tv_tit;
    private TextView tv_grade;
    private TextView tv_input;
    private ImageView iv_checkbox;
    private String dataString;
    private String titleString;
    private String gradeString;
    private String keywordString;
    private String is_plus;
    private List<ExpertDetil> list;

    @Override
    public View getView(LayoutInflater inflater) {
        return inflater.inflate( R.layout.fragment_doctor_online, null );
    }

    @Override
    public void initView(View view) {
        ischeck = false;
        ImageView iv_back = view.findViewById( R.id.iv_back );
        iv_back.setVisibility( View.GONE );
        TextView tv_save = view.findViewById( R.id.tv_save );
        tv_save.setVisibility( View.GONE );
        TextView tv_title = view.findViewById( R.id.tv_title );
        tv_title.setText( "医生在线" );
        re_province = view.findViewById( R.id.re_province );
        re_title = view.findViewById( R.id.re_title );
        re_grade = view.findViewById( R.id.re_grade );
        re_input = view.findViewById( R.id.re_input );
        ll_freeplus = view.findViewById( R.id.LL_freeplus );
        tv_query = view.findViewById( R.id.tv_query );
        tv_ask = view.findViewById( R.id.tv_ask );
        tv_adviser = view.findViewById( R.id.tv_adviser );
        Recy = view.findViewById( R.id.Recy );
        tv_province = view.findViewById( R.id.tv_province );
        iv_location = view.findViewById( R.id.iv_location );
        tv_tit = view.findViewById( R.id.tv_tit );
        tv_grade = view.findViewById( R.id.tv_grade );
        tv_input = view.findViewById( R.id.tv_input );
        iv_checkbox =view. findViewById( R.id.iv_checkbox );

    }

    @Override
    public void initClick() {
        re_province.setOnClickListener( this );
        re_title.setOnClickListener( this );
        re_grade.setOnClickListener( this );
        re_input.setOnClickListener( this );
        ll_freeplus.setOnClickListener( this );
        tv_query.setOnClickListener( this );
        tv_ask.setOnClickListener( this );
        tv_adviser.setOnClickListener( this );
        Recy.setOnClickListener( this );
        iv_location.setOnClickListener( this );
        iv_checkbox.setOnClickListener( this );

    }

    @Override
    public void initLogic() {
        list = new ArrayList<>();
        adapter = new MyRecyclerViewAdapter( getActivity(), list );
        manager = new GridLayoutManager( getActivity(), 4 );
        Recy.setLayoutManager( manager );
        Recy.setAdapter( adapter );

//        GET http://api.wws.xywy.com/index.php?&tag=BloodAndroid&sign=2c19b2821ebc5306c3ac37bac5b4288b&act=zhuanjia&fun=HotDoctor&pageNum=1&pageCount=4 HTTP/1.1
        String url = Config.getUrl( "zhuanjia", "HotDoctor" ) + "&pageNum=1" + "&pageCount=4";
        OkHttpUtils.getInstance().get( url, new RequestCallBack<String>() {



            @Override
            public void sucess(Call call, String t) {
                LogUtils.Log_i( DoctorOnlineFragment.class.getName(), t );
                Gson gson = new Gson();
               final Expert expert = gson.fromJson( t, Expert.class );
                if (expert.getCode() == 10000) {
                    handler.post( new Runnable() {
                        @Override
                        public void run() {
                            list.addAll( expert.getData() );
                            adapter.notifyDataSetChanged();
                        }
                    } );
                }
            }

            @Override
            public void fail(Call call, IOException e) {
            }
        } );
    }

    @Override
    public void onClick(View v) {
        super.onClick( v );
        switch (v.getId()) {
            case R.id.re_province:
                Intent intent = new Intent( getActivity(), ProvinceActivity.class );
                //1 其实就是 requestCode 请求码 传入了唯一值 1
                startActivityForResult( intent, 1 );  //回传  intent
                break;
            case R.id.iv_location:
                initLocation();
                break;
            case R.id.re_title:
                Intent intent1 = new Intent( getActivity(), DoctorTitleActivity.class );
                //2 其实就是 requestCode 请求码 传入了唯一值 2
                startActivityForResult( intent1, 2 );
                break;
            case R.id.re_grade:
                Intent intent2 = new Intent( getActivity(), HospitalGradeActivity.class );
                //3 其实就是 requestCode 请求码 传入了唯一值 3
                startActivityForResult( intent2, 3 );
                break;
            case R.id.re_input:
                Intent intent3 = new Intent( getActivity(), KeywordActivity.class );
                //4 其实就是 requestCode 请求码 传入了唯一值 4
                startActivityForResult( intent3, 4 );
                break;
            case R.id.iv_checkbox:
                if (ischeck) {
                    is_plus = "0";
                    iv_checkbox.setImageResource(R.mipmap.checkbox_normal  );
                    ischeck=false;
                }else{
                    is_plus="1";
                    iv_checkbox.setImageResource(R.mipmap.checkbox_press  );
                    ischeck=true;
                }
                break;
            case R.id. tv_query:
                Intent intent4 = new Intent(getActivity(),QueryActivity.class);
//                intent4.putExtra("province", tv_province.setText( location.getCity() ));
                intent4.putExtra("province",dataString);
                intent4.putExtra("title",titleString);
                intent4.putExtra("grade",gradeString);
                intent4.putExtra("keyword",keywordString);
                intent4.putExtra( "check", is_plus);
               startActivity( intent4 );
                break;
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult( requestCode, resultCode, data );
        switch (requestCode) {
            case 1:
                if (resultCode == RESULT_OK) {
                    dataString = data.getStringExtra( "data_string" );
                    tv_province.setText( dataString );
                }
                break;
            case 2:
                if (resultCode == RESULT_OK) {
                    titleString = data.getStringExtra( "title_string" );
                    tv_tit.setText( titleString );
                }
                break;
            case 3:
                if (resultCode == RESULT_OK) {
                    gradeString = data.getStringExtra( "grade_string" );
                    tv_grade.setText( gradeString );
                }
                break;
            case 4:
                if (resultCode == RESULT_OK) {
                    keywordString = data.getStringExtra( "keyword_string" );
                    tv_input.setText( keywordString );
                }
                break;
        }
    }


    /**
     * 初始化定位
     *
     */
    private void initLocation() {
        //初始化client
        locationClient = new AMapLocationClient( getActivity().getApplicationContext() );
        locationOption = new AMapLocationClientOption();
        //设置定位参数
        locationClient.setLocationOption( locationOption );
        // 设置定位监听
        locationClient.setLocationListener( locationListener );

        startLocation();
    }

    /**
     * 定位监听
     */
    AMapLocationListener locationListener = new AMapLocationListener() {
        @Override
        public void onLocationChanged(AMapLocation   location) {
            if (null != location) {
                //errCode等于0代表定位成功，其他的为定位失败，具体的可以参照官网定位错误码说明
                if (location.getErrorCode() == 0) {
                    tv_province.setText( location.getCity() );
                    dataString=location.getCity();
                    stopLocation();
                } else {
                    show( location.getErrorInfo() );
                }
            }
        }
    };

    /**
     * 停止定位
     *
     */
    private void stopLocation() {
        // 停止定位
        locationClient.stopLocation();
    }

    /**
     * 开始定位
     */
    private void startLocation() {
        // 设置定位参数
        locationClient.setLocationOption( locationOption );
        // 启动定位
        locationClient.startLocation();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        destroyLocation();
    }

    /**
     * 销毁定位
     *

     */
    private void destroyLocation() {
        if (null != locationClient) {
            /**
             * 如果AMapLocationClient是在当前Activity实例化的，
             * 在Activity的onDestroy中一定要执行AMapLocationClient的onDestroy
             */
            locationClient.onDestroy();
            locationClient = null;
            locationOption = null;
        }
    }
}
