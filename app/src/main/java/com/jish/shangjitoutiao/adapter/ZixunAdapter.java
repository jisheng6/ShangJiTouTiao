package com.jish.shangjitoutiao.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.jish.shangjitoutiao.R;
import com.jish.shangjitoutiao.bean.JiuGongBean;
import com.jish.shangjitoutiao.bean.ZiXunBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Adminjs on 2018/2/2.
 */

public class ZixunAdapter extends RecyclerView.Adapter<ZixunAdapter.IViewHolder>{
   private Context context;
   private List<ZiXunBean.DataBean>list;

    public ZixunAdapter(Context context) {
        this.context = context;
    }
    public void addData(ZiXunBean bean){
        if(list == null){
            list = new ArrayList<>();
        }
        list.addAll(bean.getData());
        notifyDataSetChanged();
    }

    @Override
    public IViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.layout_zixun, null);
        return new IViewHolder(view);
    }

    @Override
    public void onBindViewHolder(IViewHolder holder, int position) {
            holder.zixun.setText(list.get(position).getTitle());
    }
    @Override
    public int getItemCount() {
            return list == null ? 0 : list.size();
    }

    class IViewHolder extends RecyclerView.ViewHolder{
        TextView zixun;
        public IViewHolder(View itemView) {
            super(itemView);
            zixun = itemView.findViewById(R.id.zixun);
        }
    }
}
