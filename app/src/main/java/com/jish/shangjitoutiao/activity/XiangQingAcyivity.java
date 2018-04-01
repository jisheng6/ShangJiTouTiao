package com.jish.shangjitoutiao.activity;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.http.SslError;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.webkit.SslErrorHandler;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;

import com.jish.shangjitoutiao.R;
import com.jish.shangjitoutiao.adapter.XiangQingAdapter;
import com.jish.shangjitoutiao.bean.ShouYe_XiangQingBean;
import com.jish.shangjitoutiao.present.XiangQingPresenter;
import com.jish.shangjitoutiao.view.XiangQingView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Adminjs on 2018/2/4.
 */

public class XiangQingAcyivity extends Activity implements XiangQingView {
    @BindView(R.id.xiangqing_recycler)
    RecyclerView xiangqingRecycler;
    @BindView(R.id.fanhui)
    ImageView fanhui;
    private XiangQingPresenter presenter;
    private XiangQingAdapter adapter;
    private WebView webView;
    private String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xiangqing);
        ButterKnife.bind(this);
        Bundle buddle = getIntent().getExtras();
        id = buddle.getString("id");
        SharedPreferences sp = getSharedPreferences("sp_demo", Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = sp.edit();
        edit.putString("id", id);
        edit.commit();
        presenter = new XiangQingPresenter(this);
        presenter.get(id);
        LinearLayoutManager manager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        adapter = new XiangQingAdapter(this);
        xiangqingRecycler.setLayoutManager(manager);
        xiangqingRecycler.setAdapter(adapter);
        webView = findViewById(R.id.webview);
        webVe();

    }

    private void webVe() {
//        SharedPreferences sp = getSharedPreferences("sp_demo", Context.MODE_PRIVATE);
//        String id = sp.getString("id", null);
        String url = "https://toutiao.28.com/Index/article_app/id/";
        webView.getSettings().setDomStorageEnabled(true);
        webView.loadUrl(url+id+"html");

        webView.getSettings().setJavaScriptEnabled(true);

        webView.getSettings().setSavePassword(false);
        webView.setVerticalScrollBarEnabled(false);
        webView.setHorizontalScrollBarEnabled(false);
        // 设置可以支持缩放
        webView.getSettings().setSupportZoom(true);
        // 扩大比例的缩放
        webView.getSettings().setUseWideViewPort(true);
        // 自适应屏幕
        webView.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        webView.getSettings().setLoadWithOverviewMode(true);
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {

            }
            @Override
            public void onReceivedError(WebView view, int errorCode,
                                        String description, String failingUrl) {
                super.onReceivedError(view, errorCode, description, failingUrl);
            }
            @Override
            public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
                //super.onReceivedSslError(view, handler, error);
                handler.proceed();
            }
        });
    }

    @Override
    public void success(ShouYe_XiangQingBean bean) {
        adapter.addData(bean);
    }

    @OnClick(R.id.fanhui)
    public void onViewClicked() {
        finish();
    }
}
