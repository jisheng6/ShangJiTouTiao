package com.jish.shangjitoutiao.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;
import com.jish.shangjitoutiao.R;
import com.jish.shangjitoutiao.bean.CaiBean;
import com.jish.shangjitoutiao.bean.ShangJi_SouSuoBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Adminjs on 2018/2/2.
 */

public class ShangJi_SouSuo_Adapter extends RecyclerView.Adapter<ShangJi_SouSuo_Adapter.IViewHolder>{
   private Context context;
   private List<ShangJi_SouSuoBean.DataBean>list;

    public ShangJi_SouSuo_Adapter(Context context) {
        this.context = context;
    }
    public void addData(ShangJi_SouSuoBean bean){
        if(list == null){
            list = new ArrayList<>();
        }
        list.addAll(bean.getData());
        notifyDataSetChanged();
    }

    @Override
    public IViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.shangji_sousuo_layout, null);
        return new IViewHolder(view);
    }

    @Override
    public void onBindViewHolder(IViewHolder holder, int position) {
        holder.title.setText(list.get(position).getTitle());
        holder.name.setText(list.get(position).getCompany_name());
        holder.sign.setText(list.get(position).getSign());
        holder.image.setImageURI(list.get(position).getLogo());
        RoundingParams roundingParams = RoundingParams.fromCornersRadius(5f);
        roundingParams.setRoundAsCircle(true);
        holder.image.getHierarchy().setRoundingParams(roundingParams);
    }
    @Override
    public int getItemCount() {
            return list == null ? 0 : list.size();
    }

    class IViewHolder extends RecyclerView.ViewHolder{
        private final TextView title;
        private final TextView name;
        private final TextView sign;
        private final SimpleDraweeView image;

        public IViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.sjsousuo_title);
            name = itemView.findViewById(R.id.sjsousuo_name);
            sign = itemView.findViewById(R.id.sjsousuo_sign);
            image = itemView.findViewById(R.id.sjsousuo_image);
        }
    }
}
