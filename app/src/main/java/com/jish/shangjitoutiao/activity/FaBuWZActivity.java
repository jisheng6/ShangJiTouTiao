package com.jish.shangjitoutiao.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.jish.shangjitoutiao.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Adminjs on 2018/2/8.
 */

public class FaBuWZActivity extends Activity {
    @BindView(R.id.fabuwz_fan)
    ImageView fabuwzFan;
    @BindView(R.id.fabuwz_fa)
    Button fabuwzFa;
    @BindView(R.id.fabuwz_tit)
    EditText fabuwzTit;
    @BindView(R.id.fabuwz_name)
    EditText fabuwzName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fabuwz);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.fabuwz_fan, R.id.fabuwz_fa})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.fabuwz_fan:
                finish();
                break;
            case R.id.fabuwz_fa:
                break;
        }
    }
}
