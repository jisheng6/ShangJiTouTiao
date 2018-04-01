package com.jish.shangjitoutiao.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.jish.shangjitoutiao.R;
import com.jish.shangjitoutiao.bean.ShouYe_XiangQingBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Adminjs on 2018/2/2.
 */

public class XiangQingAdapter extends RecyclerView.Adapter<XiangQingAdapter.IViewHolder>{
   private Context context;
   private List<ShouYe_XiangQingBean.DataBean>list;

    public XiangQingAdapter(Context context) {
        this.context = context;
    }
    public void addData(ShouYe_XiangQingBean bean){
        if(list == null){
            list = new ArrayList<>();
        }
        list.add(bean.getData());
        notifyDataSetChanged();
    }

    @Override
    public IViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.xiangqing_layout, null);
        return new IViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final IViewHolder holder, int position) {
        holder.tit.setText(list.get(position).getVo().getTitle());
        holder.image.setImageURI(list.get(position).getMembers().getAvatars());
        holder.name.setText(list.get(position).getMembers_info().getNickname());

//        SharedPreferences sp = context.getSharedPreferences("sp_demo", Context.MODE_PRIVATE);
//        String id = sp.getString("id", null);
//        String url = "https://toutiao.28.com/Index/article_app/id/";
//        holder.webView.getSettings().setDomStorageEnabled(true);
//        holder.webView.loadUrl(url+id+"html");
//
//        holder.webView.getSettings().setJavaScriptEnabled(true);
//
//        holder.webView.getSettings().setSavePassword(false);
//        holder.webView.setVerticalScrollBarEnabled(false);
//        holder.webView.setHorizontalScrollBarEnabled(false);
//        // 设置可以支持缩放
//        holder.webView.getSettings().setSupportZoom(true);
//        // 扩大比例的缩放
//        holder.webView.getSettings().setUseWideViewPort(true);
//        // 自适应屏幕
//        holder.webView.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
//        holder.webView.getSettings().setLoadWithOverviewMode(true);
//        holder.webView.setWebViewClient(new WebViewClient() {
//            @Override
//            public void onPageFinished(WebView view, String url) {
//
//            }
//            @Override
//            public void onReceivedError(WebView view, int errorCode,
//                                        String description, String failingUrl) {
//                super.onReceivedError(view, errorCode, description, failingUrl);
//            }
//            @Override
//            public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
//                //super.onReceivedSslError(view, handler, error);
//                handler.proceed();
//            }
//        });
    }
    @Override
    public int getItemCount() {
            return list == null ? 0 : list.size();
    }

    class IViewHolder extends RecyclerView.ViewHolder{
        TextView tit;
        SimpleDraweeView image;
        TextView name;
     //   WebView webView;
        public IViewHolder(View itemView) {
            super(itemView);
            tit = itemView.findViewById(R.id.xiang_tit);
            image = itemView.findViewById(R.id.xiangqing_image);
            name = itemView.findViewById(R.id.xiangxiang_name);
     //       webView = itemView.findViewById(R.id.webview);
        }
    }
}
