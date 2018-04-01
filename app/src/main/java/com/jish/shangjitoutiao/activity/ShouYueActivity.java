package com.jish.shangjitoutiao.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jish.shangjitoutiao.R;
import com.xys.libzxing.zxing.activity.CaptureActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Adminjs on 2018/2/8.
 */

public class ShouYueActivity extends Activity {
    @BindView(R.id.shouyue_fan)
    ImageView shouyueFan;
    @BindView(R.id.zhangdan)
    TextView zhangdan;
    @BindView(R.id.saoyisao)
    LinearLayout saoyisao;
    @BindView(R.id.yue)
    LinearLayout yue;
    @BindView(R.id.yinghka)
    LinearLayout yinghka;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shouyue);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.shouyue_fan, R.id.zhangdan, R.id.saoyisao, R.id.yue, R.id.yinghka})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.shouyue_fan:
                finish();
                break;
            case R.id.zhangdan:
                break;
            case R.id.saoyisao:
                Intent intent = new Intent(ShouYueActivity.this, CaptureActivity.class);
                startActivity(intent);
                break;
            case R.id.yue:
                break;
            case R.id.yinghka:
                break;
        }
    }
}
