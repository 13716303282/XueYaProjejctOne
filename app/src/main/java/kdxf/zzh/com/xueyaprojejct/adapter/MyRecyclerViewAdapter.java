package kdxf.zzh.com.xueyaprojejct.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import kdxf.zzh.com.xueyaprojejct.R;
import kdxf.zzh.com.xueyaprojejct.bean.ExpertDetil;
import kdxf.zzh.com.xueyaprojejct.doctoronline.DoctorActivity;

/**
 * Created by ASUS on 2018/11/14.
 */

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.VH> {
    private Context context;
    private List<ExpertDetil> list;

    public MyRecyclerViewAdapter(Context context, List<ExpertDetil> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate( context, R.layout.item_doctor, null );
        return new VH( view );
    }


    @Override
    public void onBindViewHolder(final VH holder, final int position) {
        final ExpertDetil detil = list.get( position );
        holder.itemView.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent( context, DoctorActivity.class );
                intent.putExtra( "exper_data", detil );
                context.startActivity(intent);
            }
        } );

        Glide.with( context ).load( detil.getApp_image() ).into( holder.head );
        holder.name.setText( detil.getName() );
    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    public class VH extends RecyclerView.ViewHolder {

        private final ImageView head;
        private final TextView name;

        public VH(View itemView) {
            super( itemView );
            head = itemView.findViewById( R.id.iv_head );
            name = itemView.findViewById( R.id.tv_name );
        }
    }
}
