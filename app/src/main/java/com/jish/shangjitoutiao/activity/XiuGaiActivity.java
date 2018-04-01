package com.jish.shangjitoutiao.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.jish.shangjitoutiao.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Adminjs on 2018/2/8.
 */

public class XiuGaiActivity extends Activity {
    @BindView(R.id.xiugai_uipone)
    EditText xiugaiUipone;
    @BindView(R.id.xiugai_uyan)
    EditText xiugaiUyan;
    @BindView(R.id.xiugai_huo)
    TextView xiugaiHuo;
    @BindView(R.id.xiugai_upass)
    EditText xiugaiUpass;
    @BindView(R.id.xiugai_upass_u)
    EditText xiugaiUpassU;
    @BindView(R.id.xiugai_register_a)
    Button xiugaiRegisterA;
    @BindView(R.id.xiugai_deng)
    TextView xiugaiDeng;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xiugai);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.xiugai_huo, R.id.xiugai_register_a, R.id.xiugai_deng})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.xiugai_huo:
                break;
            case R.id.xiugai_register_a:
                break;
            case R.id.xiugai_deng:
                Intent intent = new Intent(XiuGaiActivity.this, LoginActivity.class);
                startActivity(intent);
                break;
        }
    }
}
