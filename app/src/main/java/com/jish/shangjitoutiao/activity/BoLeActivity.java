package com.jish.shangjitoutiao.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.jish.shangjitoutiao.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Adminjs on 2018/2/8.
 */

public class BoLeActivity extends Activity {


    @BindView(R.id.bole_fan)
    ImageView boleFan;
    @BindView(R.id.bole_uipone)
    EditText boleUipone;
    @BindView(R.id.bole_uyan)
    EditText boleUyan;
    @BindView(R.id.bole_huo)
    TextView boleHuo;
    @BindView(R.id.bole_upass)
    EditText boleUpass;
    @BindView(R.id.bole_upass_u)
    EditText boleUpassU;
    @BindView(R.id.bole_register_a)
    Button boleRegisterA;
    @BindView(R.id.bole_deng)
    TextView boleDeng;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bole);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.bole_fan, R.id.bole_huo, R.id.bole_register_a, R.id.bole_deng})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bole_fan:
                finish();
                break;
            case R.id.bole_huo:
                break;
            case R.id.bole_register_a:
                break;
            case R.id.bole_deng:
                Intent intent = new Intent(BoLeActivity.this, LoginActivity.class);
                startActivity(intent);
                break;
        }
    }
}
