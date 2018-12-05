package kdxf.zzh.com.xueyaprojejct.doctoronline;

import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import kdxf.zzh.com.xueyaprojejct.R;
import kdxf.zzh.com.xueyaprojejct.adapter.MyKeywordBaseAdapter;
import kdxf.zzh.com.xueyaprojejct.framework.BaseActivity;

/**
 * Created by ASUS on 2018/11/16.
 */

public class KeywordActivity extends BaseActivity implements View.OnClickListener {

    private EditText ed_keyword;
    private TextView tv_sure3;
    private ListView iv_list;
    private ImageView iv_back;


    @Override
    public int initLayout() {
        return R.layout.activity_keyword;
    }

    @Override
    public void initView() {

        iv_back = findViewById( R.id.iv_back );
        TextView tv_save = findViewById( R.id.tv_save );
        tv_save.setVisibility( View.GONE );
        TextView tv_title = findViewById( R.id.tv_title );
        tv_title.setText( "关键字" );
        ed_keyword = findViewById( R.id.ed_keyword );
        tv_sure3 = findViewById( R.id.tv_sure3 );
        iv_list = findViewById( R.id.iv_list );

        SharedPreferences sp = getSharedPreferences( "config", KeywordActivity.MODE_PRIVATE );
        Set<String> set = sp.getStringSet( "list", null );
        if (set == null) {
            return;
        }
        final List<String> list = new ArrayList<>( set );
        MyKeywordBaseAdapter adapter = new MyKeywordBaseAdapter( KeywordActivity.this, list );
        iv_list.setAdapter( adapter );
        iv_list.setOnItemClickListener( new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ed_keyword.setText( list.get( position ) );
            }
        } );

    }

    @Override
    public void initClick() {
//        ed_keyword.setOnClickListener( this );
        tv_sure3.setOnClickListener( this );
        iv_back.setOnClickListener( this );
    }

    @Override
    public void initlogic() {

    }

    @Override
    public void onClick(View v) {
        super.onClick( v );
        switch (v.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.tv_sure3:
                Intent intent = new Intent();
                intent.putExtra( "keyword_string", ed_keyword.getText().toString() );
                //获取sp 对象
                SharedPreferences sharedPreferences = getSharedPreferences( "config",
                        KeywordActivity.MODE_PRIVATE );

                //获取 editor
                SharedPreferences.Editor editor = sharedPreferences.edit();

                //创建 集合 用来存放 包括当前搜索过的（EditText中的内容） 和 以前搜索过的内容（SP保存的内容）  所有搜索过的内容
                Set<String> set = new HashSet<>();

                //获取以前搜索过的内容
                Set<String> keyword_string = sharedPreferences.getStringSet( "list", null );

                //如果keyword_string 为空 代表第一次存放 不需要添加以前搜索的内容  反之 把以前搜索的内容添加到 现在的集合中
                if (keyword_string != null)
                    set.addAll( keyword_string );

                //添加当前搜索的内容
                set.add( ed_keyword.getText().toString() );

                //把所有的数据存入 sp 中
                editor.putStringSet( "list", set );
                editor.commit();

                //给上一个页面传递数据
                setResult( RESULT_OK, intent );
                //关闭页面
                if (ed_keyword.getText().toString().isEmpty()){
                    show( "关键字不能为空" );
                    return;

                }
                finish();
                break;

        }
    }


}
