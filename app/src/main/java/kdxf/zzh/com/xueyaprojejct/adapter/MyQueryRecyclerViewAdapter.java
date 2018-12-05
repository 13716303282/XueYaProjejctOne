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
 * Created by ASUS on 2018/11/19.
 */

public class MyQueryRecyclerViewAdapter extends RecyclerView.Adapter<MyQueryRecyclerViewAdapter.VH> {
    private Context context;
    private List<ExpertDetil> list;

    public MyQueryRecyclerViewAdapter(Context context, List<ExpertDetil> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate( context, R.layout.item_query, null );
        return new VH( view );
    }

    @Override
    public void onBindViewHolder(VH holder, int position) {
     final   ExpertDetil detil=list.get( position );
        holder.itemView.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( context, DoctorActivity.class );
                intent.putExtra( "exper_data", detil );
                context.startActivity(intent);
            }
        } );
        Glide.with( context ).load( detil.getApp_image() ).into( holder.iv_img );
        holder.iv_is_plus.setImageResource( R.mipmap.is_plus_normal );
        holder.tv_name.setText( detil.getName() );
        holder.tv_hospital.setText( detil.getHospital() );
        holder.tv_title.setText( detil.getTitle() );
        holder.tv_department.setText( detil.getDepart() );
        holder.tv_grade.setText( detil.getTeach() );
        holder.tv_goodat.setText( detil.getGoodat() );

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class VH extends RecyclerView.ViewHolder {

        private final ImageView iv_img;
        private final ImageView iv_is_plus;
        private final TextView tv_name;
        private final TextView tv_hospital;
        private final TextView tv_title;
        private final TextView tv_department;
        private final TextView tv_grade;
        private final TextView tv_goodat;

        public VH(View itemView) {
            super( itemView );
            iv_img = itemView.findViewById( R.id.iv_img );
            iv_is_plus = itemView.findViewById( R.id.iv_is_plus );
            tv_name = itemView.findViewById( R.id.tv_name );
            tv_hospital = itemView.findViewById( R.id.tv_hospital );
            tv_title = itemView.findViewById( R.id.tv_title );
            tv_department = itemView.findViewById( R.id.tv_department );
            tv_grade = itemView.findViewById( R.id.tv_grade );
            tv_goodat = itemView.findViewById( R.id.tv_goodat );
        }
    }
}
