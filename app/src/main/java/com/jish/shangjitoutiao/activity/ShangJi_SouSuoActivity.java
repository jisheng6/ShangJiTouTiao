package com.jish.shangjitoutiao.activity;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;

import com.jish.shangjitoutiao.R;
import com.jish.shangjitoutiao.adapter.ShangJi_SouSuo_Adapter;
import com.jish.shangjitoutiao.bean.ShangJi_SouSuoBean;
import com.jish.shangjitoutiao.present.ShangJi_SouSuoPresenter;
import com.jish.shangjitoutiao.view.ShangJi_SouSuoView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Adminjs on 2018/2/5.
 */

public class ShangJi_SouSuoActivity extends Activity implements ShangJi_SouSuoView {

    @BindView(R.id.shangji_fan)
    ImageView shangjiFan;
    @BindView(R.id.shangji_sousuo_recycler)
    RecyclerView shangjiSousuoRecycler;
    private int page = 1;
    private ShangJi_SouSuoPresenter presenter;
    private ShangJi_SouSuo_Adapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shangji_sousuo);
        ButterKnife.bind(this);

        presenter = new ShangJi_SouSuoPresenter(this);
        String sjsousuo = getIntent().getStringExtra("sjsousuo");
        SharedPreferences sp = getSharedPreferences("sp_demo", Context.MODE_PRIVATE);
        String id = sp.getString("id", null);
        if (!TextUtils.isEmpty(sjsousuo)) {
            presenter.get(page + "", sjsousuo,id);
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
        shangjiSousuoRecycler.setLayoutManager(manager);
        adapter = new ShangJi_SouSuo_Adapter(this);
        shangjiSousuoRecycler.setAdapter(adapter);

    }


    @Override
    public void success(ShangJi_SouSuoBean bean) {
       adapter.addData(bean);
    }

    @OnClick(R.id.shangji_fan)
    public void onViewClicked() {
        finish();
    }
}
