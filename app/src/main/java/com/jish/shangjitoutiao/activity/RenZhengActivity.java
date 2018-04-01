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

public class RenZhengActivity extends Activity {
    @BindView(R.id.renzheng_fan)
    ImageView renzhengFan;
    @BindView(R.id.renzheng_fa)
    Button renzhengFa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_renzheng);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.renzheng_fan, R.id.renzheng_fa})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.renzheng_fan:
                finish();
                break;
            case R.id.renzheng_fa:
                break;
        }
    }
}
