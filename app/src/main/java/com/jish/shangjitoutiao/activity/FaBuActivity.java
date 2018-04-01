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

public class FaBuActivity extends Activity {
    @BindView(R.id.fabu_fan)
    ImageView fabuFan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fabu);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.fabu_fan)
    public void onViewClicked() {
        finish();
    }
}
