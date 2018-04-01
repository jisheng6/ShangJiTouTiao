package com.jish.shangjitoutiao.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.jish.shangjitoutiao.R;
import com.jish.shangjitoutiao.adapter.ShouYe_SouSuoAdapter;
import com.jish.shangjitoutiao.bean.ShouYe_SouSuoBean;
import com.jish.shangjitoutiao.present.ShouYe_SouSuoPresenter;
import com.jish.shangjitoutiao.view.ShouYe_SouSuoView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Adminjs on 2018/2/5.
 */

public class ShouYe_SouSuoActivity extends Activity implements ShouYe_SouSuoView {
    @BindView(R.id.fan)
    ImageView fan;
    @BindView(R.id.sousuo_title)
    TextView sousuoTitle;
    @BindView(R.id.shouye_sousuo_recycler)
    RecyclerView shouyeSousuoRecycler;
    private ShouYe_SouSuoPresenter presenter;
    private int page = 1;
    private ShouYe_SouSuoAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shouye_sousuo);
        ButterKnife.bind(this);
        presenter = new ShouYe_SouSuoPresenter(this);
        String sousuo = getIntent().getStringExtra("sousuo");
        if (!TextUtils.isEmpty(sousuo)) {
            presenter.get(page + "", sousuo);
        } else {
            setContentView(R.layout.shouye_sousuo_activity);
           ImageView sousuoFan = findViewById(R.id.sousuo_fan);
            sousuoFan.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    finish();
                }
            });
        }
        LinearLayoutManager manager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        shouyeSousuoRecycler.setLayoutManager(manager);
        adapter = new ShouYe_SouSuoAdapter(this);
        shouyeSousuoRecycler.setAdapter(adapter);

    }

    @Override
    public void success(ShouYe_SouSuoBean bean) {
        adapter.addData(bean);
    }

    @OnClick(R.id.fan)
    public void onViewClicked() {
        finish();
    }
}
