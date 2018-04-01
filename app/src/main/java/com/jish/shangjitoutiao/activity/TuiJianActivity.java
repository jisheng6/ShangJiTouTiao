package com.jish.shangjitoutiao.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;

import com.jish.shangjitoutiao.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Adminjs on 2018/2/7.
 */

public class TuiJianActivity extends Activity {
    @BindView(R.id.tuijian_fan)
    ImageView fabuFan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tuijian);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.tuijian_fan)
    public void onViewClicked() {
        finish();
    }
}
