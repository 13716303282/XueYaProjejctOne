package kdxf.zzh.com.xueyaprojejct.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import kdxf.zzh.com.xueyaprojejct.R;

/**
 * Created by ASUS on 2018/11/15.
 */

public class MyBaseAdapter extends BaseAdapter {
    private Context context;
    private List<String> province;


    public MyBaseAdapter(Context context, List<String> province) {
        this.context = context;
        this.province = province;
    }

    @Override
    public int getCount() {
        return province.size();
    }

    @Override
    public Object getItem(int position) {
        return province.get( position );
    }

    @Override
    public long getItemId(int position) {
        return position ;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
      convertView=View.inflate(context, R.layout.item_province,null );
        TextView  tv_province = convertView.findViewById( R.id.tv_province );
        tv_province.setText( province.get( position ) );
        return convertView;
    }
}
