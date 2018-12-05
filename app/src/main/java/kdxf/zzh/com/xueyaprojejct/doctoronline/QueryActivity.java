package kdxf.zzh.com.xueyaprojejct.doctoronline;

import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import kdxf.zzh.com.xueyaprojejct.R;
import kdxf.zzh.com.xueyaprojejct.adapter.MyQueryRecyclerViewAdapter;
import kdxf.zzh.com.xueyaprojejct.bean.Expert;
import kdxf.zzh.com.xueyaprojejct.bean.ExpertDetil;
import kdxf.zzh.com.xueyaprojejct.framework.BaseActivity;
import kdxf.zzh.com.xueyaprojejct.http.OkHttpUtils;
import kdxf.zzh.com.xueyaprojejct.http.RequestCallBack;
import kdxf.zzh.com.xueyaprojejct.utils.Config;
import kdxf.zzh.com.xueyaprojejct.utils.LogUtils;
import okhttp3.Call;

/**
 * Created by ASUS on 2018/11/19.
 */

public class QueryActivity extends BaseActivity implements View.OnClickListener{

    private RecyclerView recy;
    private List<ExpertDetil> list;
    public Handler handler=new Handler(  );
    private ImageView iv_back;
    private String province;
    private String title;
    private String keyword;
    private String grade;
    private String is_plus;
    private MyQueryRecyclerViewAdapter adapter;

    @Override
    public int initLayout() {
        return R.layout.activity_query;
    }

    @Override
    public void initView() {
        iv_back = findViewById( R.id.iv_back );
        TextView tv_save = findViewById( R.id.tv_save );
        tv_save.setVisibility( View.GONE );
        TextView tv_title =findViewById( R.id.tv_title );
        tv_title.setText( "全部14624位专家" );
        recy = findViewById( R.id.recy );
    }

    @Override
    public void initClick() {
        iv_back.setOnClickListener( this );
    }
    @Override
    public void initlogic() {


        province = getIntent().getStringExtra( "province" );
        title = getIntent().getStringExtra( "title" );
        grade = getIntent().getStringExtra( "grade" );
        keyword = getIntent().getStringExtra( "keyword" );
        is_plus = getIntent().getStringExtra( "check" );
        list = new ArrayList<>(  );
        adapter = new MyQueryRecyclerViewAdapter( QueryActivity.this,list );
        LinearLayoutManager manager = new LinearLayoutManager( QueryActivity.this );
        recy.setLayoutManager( manager );
        recy.setAdapter( adapter );
//      GET /index.php?&tag=BloodAndroid&sign=2c19b2821ebc5306c3ac37bac5b4288b
//      &act=zhuanjia&fun=SearchDoctor&pageCount=10&pageNum=1
//      &province=&title=&keyword=&illid=%E9%AB%98%E8%A1%80%E5%8E%8B&IsPlus=0&level= HTTP/1.1
   String url= Config.getUrl( "zhuanjia","SearchDoctor" )+"&pageCount=10"+"&pageNum=1"+
           "&province=" +province+"&title="+title+"&keyword="+keyword+"&illid="+"高血压"+"&IsPlus="+is_plus+"&level="+grade;
        OkHttpUtils.getInstance().get( url, new RequestCallBack<String>() {

            private Expert expert;

            @Override
            public void sucess(Call call, String t) {
                LogUtils.Log_i( QueryActivity.class.getName(),t );
                Gson gson=new Gson();
                expert = gson.fromJson(t, Expert.class );
             if (expert.getCode()==10000){

                 handler.post( new Runnable() {
                     @Override
                     public void run() {
                         if(expert.getData().size()==0){
                             show( "没有匹配信息" );
                             return;
                         }
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
        switch (v.getId()){
            case R.id.iv_back:
                finish();
                break;
        }
    }
}
