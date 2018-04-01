package com.jish.shangjitoutiao.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.jish.shangjitoutiao.R;
import com.jish.shangjitoutiao.activity.XiangQingAcyivity;
import com.jish.shangjitoutiao.bean.ShouYe_XinXiBean;
import com.jish.shangjitoutiao.util.OnItemClickListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Adminjs on 2018/1/30.
 */

public class ShouYeAdapter extends XRecyclerView.Adapter<XRecyclerView.ViewHolder>{
   private Context context;
   private List<ShouYe_XinXiBean.DataBean> list;
    public ShouYeAdapter(Context context) {
        this.context = context;
    }
    public void addData(ShouYe_XinXiBean bean){
        if(list == null){
            list = new ArrayList<>();
        }
        list.addAll(bean.getData());
        notifyDataSetChanged();
    }
    @Override
    public XRecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = null;
        XRecyclerView.ViewHolder holder = null;
        switch (viewType){
            case 0:
                view = View.inflate(context,R.layout.layout_item,null);
                holder = new ViewHolder1(view);
                break;
            case 1:
                view = View.inflate(context,R.layout.item_layout,null);
                holder = new ViewHolder2(view);
                break;
        }
        return holder;

    }

    @Override
    public void onBindViewHolder(final XRecyclerView.ViewHolder holder, final int position) {
        switch (getItemViewType(position)) {
            case 0:
                final ViewHolder1 holder1 = (ViewHolder1) holder;
                holder1.title.setText(list.get(position).getTitle());
                holder1.image1.setImageURI(list.get(position).getArticleImg().get(0).getPath());
                holder1.image2.setImageURI(list.get(position).getArticleImg().get(1).getPath());
                holder1.image3.setImageURI(list.get(position).getArticleImg().get(2).getPath());
                holder1.tit.setText(list.get(position).getCate_name());
                holder1.time.setText(list.get(position).getCdate());
                holder1.kan.setText(list.get(position).getView());
                holder1.zhuanzai.setText(list.get(position).getReply());
                holder1.title.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(context, XiangQingAcyivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putString("id", list.get(position).getId());
                        intent.putExtras(bundle);
                        context.startActivity(intent);
                    }
                });
                holder1.image1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(context, XiangQingAcyivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putString("id", list.get(position).getId());
                        intent.putExtras(bundle);
                        context.startActivity(intent);
                    }
                });
                holder1.image2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(context, XiangQingAcyivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putString("id", list.get(position).getId());
                        intent.putExtras(bundle);
                        context.startActivity(intent);
                    }
                });
                holder1.image3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(context, XiangQingAcyivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putString("id", list.get(position).getId());
                        intent.putExtras(bundle);
                        context.startActivity(intent);
                    }
                });
                holder1.tit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(context, XiangQingAcyivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putString("id", list.get(position).getId());
                        intent.putExtras(bundle);
                        context.startActivity(intent);
                    }
                });
                holder1.time.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(context, XiangQingAcyivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putString("id", list.get(position).getId());
                        intent.putExtras(bundle);
                        context.startActivity(intent);
                    }
                });
                break;
            case 1:
                final ViewHolder2 holder2 = (ViewHolder2) holder;
                holder2.swim.setImageURI(list.get(position).getArticleImg().get(0).getPath());
                holder2.biao.setText(list.get(position).getTitle());
                holder2.name.setText(list.get(position).getCate_name());
                holder2.time.setText(list.get(position).getCdate());
                holder2.kan.setText(list.get(position).getView());
                holder2.zhuanzai.setText(list.get(position).getReply());
                holder2.biao.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(context, XiangQingAcyivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putString("id", list.get(position).getId());
                        intent.putExtras(bundle);
                        context.startActivity(intent);
                    }
                });
                holder2.swim.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(context, XiangQingAcyivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putString("id", list.get(position).getId());
                        intent.putExtras(bundle);
                        context.startActivity(intent);
                    }
                });
                holder2.name.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(context, XiangQingAcyivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putString("id", list.get(position).getId());
                        intent.putExtras(bundle);
                        context.startActivity(intent);
                    }
                });
                holder2.time.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(context, XiangQingAcyivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putString("id", list.get(position).getId());
                        intent.putExtras(bundle);
                        context.startActivity(intent);
                    }
                });
                break;
        }

    }
    @Override
    public int getItemViewType(int position) {
    if(list.get( position).getArticleImg().size() == 3){//集合size等于3
            return 0;
        }else {
            return 1;
        }
    }
    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }
    private OnItemClickListener mOnItemClickListener;
    public void setOnItemClickListener(OnItemClickListener mOnItemClickListener){
        this.mOnItemClickListener = mOnItemClickListener;
    }
    static class ViewHolder1 extends XRecyclerView.ViewHolder {
        private final TextView title;
        private final SimpleDraweeView image1;
        private final SimpleDraweeView image2;
        private final SimpleDraweeView image3;
        private final TextView tit;
        private final TextView time;
        private final TextView kan;
        private final TextView zhuanzai;

        ViewHolder1(View view) {
            super(view);
            title = view.findViewById(R.id.title);
            image1 = view.findViewById(R.id.image1);
            image2 = view.findViewById(R.id.image2);
            image3 = view.findViewById(R.id.image3);
            tit = view.findViewById(R.id.tit);
            time = view.findViewById(R.id.time);
            kan = view.findViewById(R.id.kan);
            zhuanzai = view.findViewById(R.id.zhuanzai);
        }
    }
        static class ViewHolder2 extends XRecyclerView.ViewHolder {
            private final SimpleDraweeView swim;
            private final TextView biao;
            private final TextView name;
            private final TextView time;
            private final TextView kan;
            private final TextView zhuanzai;
            ViewHolder2(View view) {
                super(view);
                swim = view.findViewById(R.id.swim);
                biao = view.findViewById(R.id.biao);
                name = view.findViewById(R.id.biao_title);
                time = view.findViewById(R.id.biao_time);
                kan = view.findViewById(R.id.biao_kan);
                zhuanzai = view.findViewById(R.id.biao_zhuanzai);
            }
    }
}
