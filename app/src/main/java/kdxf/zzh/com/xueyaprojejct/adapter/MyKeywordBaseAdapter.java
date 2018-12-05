package kdxf.zzh.com.xueyaprojejct.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import kdxf.zzh.com.xueyaprojejct.R;

/**
 * Created by ASUS on 2018/11/16.
 */

public class MyKeywordBaseAdapter extends BaseAdapter {
    private Context context;
    private List<String> list;

    public MyKeywordBaseAdapter(Context context, List<String> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get( position );
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView=View.inflate(context, R.layout.item_keyword,null );
        TextView tv_1=convertView.findViewById( R.id.tv_1 );
        tv_1.setText( list.get( position ) );
        return convertView;
    }
}
