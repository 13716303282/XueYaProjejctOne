package kdxf.zzh.com.xueyaprojejct.doctoronline;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import kdxf.zzh.com.xueyaprojejct.R;
import kdxf.zzh.com.xueyaprojejct.adapter.MyBaseAdapter;
import kdxf.zzh.com.xueyaprojejct.framework.BaseActivity;
import kdxf.zzh.com.xueyaprojejct.utils.Config;

/**
 * Created by ASUS on 2018/11/15.
 */

public class ProvinceActivity extends BaseActivity {

    private ListView lv_list;
    private MyBaseAdapter adapter;
    private ImageView iv_back;

    @Override
    public int initLayout() {
        return R.layout.activity_province;
    }

    @Override
    public void initView() {
         iv_back = findViewById( R.id.iv_back );
        TextView tv_save = findViewById( R.id.tv_save );
        tv_save.setVisibility( View.GONE );
        TextView tv_title = findViewById( R.id.tv_title );
        tv_title.setText( "省份" );
        lv_list = findViewById( R.id.lv_list );
    }

    @Override
    public void initClick() {
        iv_back.setOnClickListener( this );
    }

    @Override
    public void initlogic() {
        Config.setProvice();
        adapter = new MyBaseAdapter( ProvinceActivity.this, Config.province );
        lv_list.setAdapter( adapter );
        lv_list.setOnItemClickListener( new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent();
                intent.putExtra("data_string",Config.province.get( position ));
                //RESULT_OK 这个值相当于 onActivityResult方法里面的resultCode
                setResult(RESULT_OK, intent); //回传
                finish();
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
