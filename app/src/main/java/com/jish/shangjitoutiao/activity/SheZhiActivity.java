package com.jish.shangjitoutiao.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.jish.shangjitoutiao.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Adminjs on 2018/2/8.
 */

public class SheZhiActivity extends Activity {
    @BindView(R.id.shezhi_fan)
    ImageView shezhiFan;
    @BindView(R.id.shezhi_simp)
    SimpleDraweeView shezhiSimp;
    @BindView(R.id.shezhi_tit)
    TextView shezhiTit;
    @BindView(R.id.she_fan)
    ImageView sheFan;
    @BindView(R.id.shezhi_rela)
    RelativeLayout shezhiRela;
    @BindView(R.id.she_xiu)
    TextView sheXiu;
    @BindView(R.id.zhi_fan)
    ImageView zhiFan;
    @BindView(R.id.shezhi_yout)
    RelativeLayout shezhiYout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shezhi);
        ButterKnife.bind(this);
        SharedPreferences sp = getSharedPreferences("sp_demo", Context.MODE_PRIVATE);
        String name = sp.getString("name", null);
        shezhiTit.setText(name);
    }

    @OnClick({R.id.shezhi_fan, R.id.shezhi_rela, R.id.shezhi_yout})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.shezhi_fan:
                finish();
                break;
            case R.id.shezhi_rela:
                break;
            case R.id.shezhi_yout:
                Intent intent = new Intent(SheZhiActivity.this, XiuGaiActivity.class);
                startActivity(intent);
                finish();
                break;
        }
    }
}
