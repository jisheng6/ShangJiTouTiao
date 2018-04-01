package com.jish.shangjitoutiao.adapter;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.jish.shangjitoutiao.R;
import com.jish.shangjitoutiao.bean.VideoBean;
import java.util.ArrayList;
import java.util.List;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;



/**
 * Created by Adminjs on 2018/1/30.
 */

public class VideoAdapter extends XRecyclerView.Adapter<VideoAdapter.IViewholder> {
    private Context context;
    private List<VideoBean.DataBean> list;

    public VideoAdapter(Context context) {
        this.context = context;
    }
    public void addData(VideoBean bean){
        if(list == null){
            list = new ArrayList<>();
        }
        list.addAll(bean.getData());
        notifyDataSetChanged();
    }

    @Override
    public IViewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.video_layout, null);
        return new IViewholder(view);
    }

    @Override
    public void onBindViewHolder(IViewholder holder, int position) {
        holder.title.setText(list.get(position).getTitle());
        holder.jieVideo.setUp(list.get(position).getUrl(), JCVideoPlayerStandard.SCREEN_LAYOUT_NORMAL,"");
        holder.jieVideo.thumbImageView.setImageURI(Uri.parse(list.get(position).getCover_url()));
        holder.cha.setText(list.get(position).getView());
    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();

    }

    class IViewholder extends XRecyclerView.ViewHolder{

        JCVideoPlayerStandard jieVideo;
        TextView title;
        TextView color;
        TextView cha;
        public IViewholder(View itemView) {
            super(itemView);
            jieVideo = itemView.findViewById(R.id.jievideo);
            title = itemView.findViewById(R.id.video_title);
            color =  itemView.findViewById(R.id.color);
            cha = itemView.findViewById(R.id.chak);
        }
    }
}

