package com.jish.shangjitoutiao.adapter;

import android.app.job.JobInfo;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.jish.shangjitoutiao.R;
import com.jish.shangjitoutiao.activity.ShangJi_Class;
import com.jish.shangjitoutiao.bean.JiuGongBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Adminjs on 2018/2/2.
 */

public class JiuGongAdapter extends RecyclerView.Adapter<JiuGongAdapter.IViewHolder>{
   private Context context;
   private List<JiuGongBean.DataBean>list;

    public JiuGongAdapter(Context context) {
        this.context = context;
    }
    public void addData(JiuGongBean bean){
        if(list == null){
            list = new ArrayList<>();
        }
        list.addAll(bean.getData());
        notifyDataSetChanged();
    }

    @Override
    public IViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.jiugong_layout, null);
        return new IViewHolder(view);
    }

    @Override
    public void onBindViewHolder(IViewHolder holder, int position) {
        holder.simpleDraweeView.setImageURI(list.get(position).getImages());
        holder.simpleDraweeView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ShangJi_Class.class);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    class IViewHolder extends RecyclerView.ViewHolder{
        SimpleDraweeView simpleDraweeView;
        public IViewHolder(View itemView) {
            super(itemView);
            simpleDraweeView = itemView.findViewById(R.id.simple);
        }
    }
}
