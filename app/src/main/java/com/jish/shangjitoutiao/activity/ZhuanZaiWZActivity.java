package com.jish.shangjitoutiao.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.jish.shangjitoutiao.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Adminjs on 2018/2/8.
 */

public class ZhuanZaiWZActivity extends Activity {
    @BindView(R.id.zhuangzaiwz_fan)
    ImageView zhuangzaiwzFan;
    @BindView(R.id.sousuo_title)
    TextView sousuoTitle;
    @BindView(R.id.qing)
    Button qing;
    @BindView(R.id.bian)
    Button bian;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhuangzaiwz);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.zhuangzaiwz_fan, R.id.qing, R.id.bian})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.zhuangzaiwz_fan:
                finish();
                break;
            case R.id.qing:
                break;
            case R.id.bian:
                break;
        }
    }
}
