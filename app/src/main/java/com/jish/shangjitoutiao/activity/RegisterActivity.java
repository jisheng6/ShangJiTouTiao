package com.jish.shangjitoutiao.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.jish.shangjitoutiao.R;
import com.jish.shangjitoutiao.util.CountDownTimerUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Adminjs on 2018/2/1.
 */

public class RegisterActivity extends Activity {
    @BindView(R.id.uipone)
    EditText uipone;
    @BindView(R.id.uyan)
    EditText uyan;
    @BindView(R.id.huo)
    TextView huo;
    @BindView(R.id.upass)
    EditText upass;
    @BindView(R.id.upass_u)
    EditText upassU;
    @BindView(R.id.register_a)
    Button registerA;
    @BindView(R.id.deng)
    TextView deng;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.huo, R.id.register_a, R.id.deng})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.huo:
                if (!TextUtils.isEmpty(uipone.getText())){
                    CountDownTimerUtils mCountDownTimerUtils = new CountDownTimerUtils(huo, 60000, 1000);
                    mCountDownTimerUtils.start();
                }else{
                    Toast.makeText(this, "手机格式不正确", Toast.LENGTH_SHORT).show();
                }

                break;
            case R.id.register_a:

                break;
            case R.id.deng:
                Intent intent1 = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent1);
                break;
        }
    }
}
