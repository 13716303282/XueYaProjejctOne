package kdxf.zzh.com.xueyaprojejct.doctoronline;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import kdxf.zzh.com.xueyaprojejct.R;
import kdxf.zzh.com.xueyaprojejct.bean.Timetable;
import kdxf.zzh.com.xueyaprojejct.framework.BaseFragment;
import kdxf.zzh.com.xueyaprojejct.http.OkHttpUtils;
import kdxf.zzh.com.xueyaprojejct.http.RequestCallBack;
import kdxf.zzh.com.xueyaprojejct.utils.Config;
import kdxf.zzh.com.xueyaprojejct.utils.LogUtils;
import okhttp3.Call;

/**
 * Created by ASUS on 2018/11/20.
 */

public class TimetableFragment extends BaseFragment {

    private List<View> list1;
    private List<View> list2;
    private List<View> list3;
    private Map<String, List<View>> map;
    private TextView tv_10;
    private TextView tv_11;
    private TextView tv_12;
    private TextView tv_13;
    private TextView tv_14;
    private TextView tv_15;
    private TextView tv_16;
    private TextView tv_18;
    private TextView tv_19;
    private TextView tv_20;
    private TextView tv_21;
    private TextView tv_22;
    private TextView tv_23;
    private TextView tv_24;
    private TextView tv_26;
    private TextView tv_27;
    private TextView tv_28;
    private TextView tv_29;
    private TextView tv_30;
    private TextView tv_31;
    private TextView tv_32;
    private TextView tv_address_name;
    private TextView tv_address;
    public Handler handler=new Handler(  );
    @Override
    public View getView(LayoutInflater inflater) {
        return inflater.inflate( R.layout.fragment_timetable, null );
    }

    @Override
    public void initView(View view) {
        tv_address_name = view.findViewById( R.id.tv_address_name );
        tv_address = view.findViewById( R.id.tv_address );
        tv_10 = view.findViewById( R.id.tv_10 );
        tv_11 = view.findViewById( R.id.tv_11 );
        tv_12 = view.findViewById( R.id.tv_12 );
        tv_13 = view.findViewById( R.id.tv_13 );
        tv_14 = view.findViewById( R.id.tv_14 );
        tv_15 = view.findViewById( R.id.tv_15 );
        tv_16 = view.findViewById( R.id.tv_16 );
        tv_18 = view.findViewById( R.id.tv_18 );
        tv_19 = view.findViewById( R.id.tv_19 );
        tv_20 = view.findViewById( R.id.tv_20 );
        tv_21 = view.findViewById( R.id.tv_21 );
        tv_22 = view.findViewById( R.id.tv_22 );
        tv_23 = view.findViewById( R.id.tv_23 );
        tv_24 = view.findViewById( R.id.tv_24 );
        tv_26 = view.findViewById( R.id.tv_26 );
        tv_27 = view.findViewById( R.id.tv_27 );
        tv_28 = view.findViewById( R.id.tv_28 );
        tv_29 = view.findViewById( R.id.tv_29 );
        tv_30 = view.findViewById( R.id.tv_30 );
        tv_31 = view.findViewById( R.id.tv_31 );
        tv_32 = view.findViewById( R.id.tv_32 );

//        list1 = new ArrayList();
//        list2 = new ArrayList();
//        list3 = new ArrayList();
//        map = new HashMap();
//        list1.add( tv_10 );
//        list1.add( tv_11 );
//        list1.add( tv_12 );
//        list1.add( tv_13 );
//        list1.add( tv_14 );
//        list1.add( tv_15 );
//        list1.add( tv_16 );
//
//        list2.add( tv_18 );
//        list2.add( tv_19 );
//        list2.add( tv_20 );
//        list2.add( tv_21 );
//        list2.add( tv_22 );
//        list2.add( tv_23 );
//        list2.add( tv_24 );
//
//        list3.add( tv_26 );
//        list3.add( tv_27 );
//        list3.add( tv_28 );
//        list3.add( tv_29 );
//        list3.add( tv_30 );
//        list3.add( tv_31 );
//        list3.add( tv_32 );
//        map.put( "上午", list1 );
//        map.put( "下午", list2 );
//        map.put( "晚上", list3 );

    }

    @Override
    public void initClick() {
//        GET /index.php?&tag=BloodAndroid&sign=2c19b2821ebc5306c3ac37bac5b4288b&act=app
//        &fun=doctor&source=xywy_app&id=319 HTTP/1.1


//        GET /index.php?&tag=BloodAndroid&sign=2c19b2821ebc5306c3ac37bac5b4288b&act=app
//        &fun=doctor&source=xywy_app&id=1179 HTTP/1.1
        String url = Config.getUrl( "app", "doctor" ) + "&source=xywy_app&id=1179";
        LogUtils.Log_i( "TimetableFragment", url );
        OkHttpUtils.getInstance().get( url, new RequestCallBack<String>() {
            @Override
            public void sucess(Call call, String t) {
                LogUtils.Log_i( "TimetableFragment", t );
                Gson gson = new Gson();
                final Timetable timetable = gson.fromJson( t, Timetable.class );
                if (timetable.getResult() == 1) {
                    handler.post( new Runnable() {
                        @Override
                        public void run() {


                    String address = timetable.getData().getAddress().toString();
                    String week = timetable.getData().getSchedule().getRdtime().get( 0 ).getWeek();
                    String halfday = timetable.getData().getSchedule().getRdtime().get( 0 ).getHalfday();
                    tv_address.setText( address );
                    if ( "1".equals( week ) && "1".equals( halfday )) {

                        tv_10.setText( "专家" );
                        tv_10.setBackgroundResource( R.color.expert );
                    }if ("1".equals( week ) && "2".equals( halfday )) {
                        tv_18.setText( "专家" );
                        tv_18.setBackgroundResource( R.color.expert );
                    }if ("1".equals( week ) && "3".equals( halfday )) {
                        tv_26.setText( "专家" );
                        tv_26.setBackgroundResource( R.color.expert );
                    }


                    if ("2".equals( week ) && "1".equals( halfday )) {
                        tv_11.setText( "专家" );
                        tv_11.setBackgroundResource( R.color.expert );
                    }if ("2".equals( week ) && "2".equals( halfday )) {
                        tv_19.setText( "专家" );
                        tv_19.setBackgroundResource( R.color.expert );
                    }if (week .equals( 2 ) &&"3".equals( halfday )) {
                        tv_27.setText( "专家" );
                        tv_27.setBackgroundResource( R.color.expert );
                    }



                    if ("3".equals( week ) && "1".equals( halfday )) {
                        tv_12.setText( "专家" );
                        tv_12.setBackgroundResource( R.color.expert );
                    }if (week .equals( 3 ) && halfday .equals( 2 )) {
                        tv_20.setText( "专家" );
                        tv_20.setBackgroundResource( R.color.expert );
                    }if ("3".equals( week ) &&"3".equals( halfday )) {
                        tv_28.setText( "专家" );
                        tv_28.setBackgroundResource( R.color.expert );
                    }



                    if ("4".equals( week ) && halfday.equals( 1 )) {
                        tv_13.setText( "专家" );
                        tv_13.setBackgroundResource( R.color.expert );
                    }if ("4".equals( week ) && "2".equals( halfday )) {
                        tv_21.setText( "专家" );
                        tv_21.setBackgroundResource( R.color.expert );
                    }if (week.equals( 4 ) && halfday .equals( 3)) {
                        tv_29.setText( "专家" );
                        tv_29.setBackgroundResource( R.color.expert );
                    }


                    if ("5".equals( week ) && "1".equals( halfday )) {
                        tv_14.setText( "专家" );
                        tv_14.setBackgroundResource( R.color.expert );
                    }if ("5".equals( week ) && halfday .equals( 2 )) {
                        tv_22.setText( "专家" );
                        tv_22.setBackgroundResource( R.color.expert );
                    }if ("5".equals( week ) && halfday .equals( 3 )) {
                        tv_30.setText( "专家" );
                        tv_30.setBackgroundResource( R.color.expert );
                    }



                    if ("6".equals( week ) && "1".equals( halfday )) {
                        tv_15.setText( "专家" );
                        tv_15.setBackgroundResource( R.color.expert );
                    }if (week.equals( 6 ) && halfday .equals( 2 )) {
                        tv_23.setText( "专家" );
                        tv_23.setBackgroundResource( R.color.expert );
                    }if ("6".equals( week ) && halfday .equals( 3 )) {
                        tv_31.setText( "专家" );
                        tv_31.setBackgroundResource( R.color.expert );
                    }


                    if ("7".equals( week ) && "1".equals( halfday )) {
                        tv_16.setText( "专家" );
                        tv_16.setBackgroundResource( R.color.expert );
                    }if ("7".equals( week ) && halfday .equals( 2 )) {
                        tv_24.setText( "专家" );
                        tv_24.setBackgroundResource( R.color.expert );
                    }if ("7".equals( week ) &&"3".equals( halfday )) {
                        tv_32.setText( "专家" );
                        tv_32.setBackgroundResource( R.color.expert );
                    }

                        }
                    } );

                }
            }

            @Override
            public void fail(Call call, IOException e) {
                LogUtils.Log_i( "TimetableFragment", e.getMessage() );

            }
        } );
    }

    @Override
    public void initLogic() {

    }
}
