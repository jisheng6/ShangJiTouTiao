package com.jish.shangjitoutiao.activity;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.jish.shangjitoutiao.R;
import com.jish.shangjitoutiao.util.CountDownTimerUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Adminjs on 2018/2/6.
 */

public class ZhaoMiActivity extends Activity {

    @BindView(R.id.shaomi_fan)
    ImageView shaomiFan;
    @BindView(R.id.zhao_useripone)
    EditText zhaoUseripone;
    @BindView(R.id.zhao_userpass)
    EditText zhaoUserpass;
    @BindView(R.id.zhao_huoqu)
    TextView zhaoHuoqu;
    @BindView(R.id.zhao_but)
    Button zhaoBut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhaomi);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.shaomi_fan, R.id.zhao_huoqu, R.id.zhao_but})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.shaomi_fan:
                finish();
                break;
            case R.id.zhao_huoqu:
                if (!TextUtils.isEmpty(zhaoUseripone.getText())){
                    CountDownTimerUtils mCountDownTimerUtils = new CountDownTimerUtils(zhaoHuoqu, 60000, 1000);
                    mCountDownTimerUtils.start();
                }else{
                    Toast.makeText(this, "手机格式不正确", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.zhao_but:
                break;
        }
    }
}
