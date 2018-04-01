package com.jish.shangjitoutiao.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.jish.shangjitoutiao.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Adminjs on 2018/2/8.
 */

public class JiHuaActivity extends Activity {
    @BindView(R.id.jihua_fan)
    ImageView jihuaFan;
    @BindView(R.id.shenqing)
    Button shenqing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jihua);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.jihua_fan, R.id.shenqing})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.jihua_fan:
                finish();
                break;
            case R.id.shenqing:
                break;
        }
    }
}
