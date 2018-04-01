package com.jish.shangjitoutiao.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import com.jish.shangjitoutiao.MainActivity;
import com.jish.shangjitoutiao.R;

import butterknife.ButterKnife;

/**
 * Created by Adminjs on 2018/2/6.
 */

public class TouYeAcyivity extends Activity{
    private int time = 5;
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            if (time>0){
                time--;
                handler.sendEmptyMessageDelayed(0,1000);
            }else{
                Intent intent = new Intent(TouYeAcyivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_touye);
        handler.sendEmptyMessageDelayed(0,1000);
    }
}
