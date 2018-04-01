package com.jish.shangjitoutiao;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.widget.Toast;

import com.hjm.bottomtabbar.BottomTabBar;
import com.jish.shangjitoutiao.fragment.Fragment_mine;
import com.jish.shangjitoutiao.fragment.Fragment_shangji;
import com.jish.shangjitoutiao.fragment.Fragment_shouye;
import com.jish.shangjitoutiao.fragment.Fragment_video;
import com.jish.shangjitoutiao.fragment.Fragment_xiaoxi;
import com.jish.shangjitoutiao.util.Api;
import com.jish.shangjitoutiao.util.SignUtils;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.bottom_tab_bar)
    BottomTabBar bottomTabBar;
    //定义是否退出程序的标记
    private boolean isExit=false;
    //定义接受用户发送信息的handler
    private Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            //标记用户不退出状态
            isExit=false;
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        bottomTabBar.init(getSupportFragmentManager())
                .setImgSize(30,30)
                .setFontSize(10)
                .setTabPadding(10,5,10)
                .setChangeColor(Color.RED,Color.DKGRAY)
                .addTabItem("首页",R.drawable.shouye_zhu,R.drawable.shouye_unzhu,Fragment_shouye.class)
                .addTabItem("商机",R.drawable.shangji_ji, R.drawable.shangji_unji, Fragment_shangji.class)
                .addTabItem("视频",R.drawable.video_shi, R.drawable.video_unshi, Fragment_video.class)
                .addTabItem("消息",R.drawable.xiaoxi_xi,R.drawable.xiaoxi_unxi, Fragment_xiaoxi.class)
                .addTabItem("我",R.drawable.mine,R.drawable.mine_unin, Fragment_mine.class)
                .isShowDivider(false)
                .setOnTabChangeListener(new BottomTabBar.OnTabChangeListener() {
                    @Override
                    public void onTabChange(int position, String name) {

                    }
                });
        yanZ();
        register();
        jiugong();
        loGin();
    }

    private void loGin() {
        long timestamp = new Date().getTime() / 1000;//时间戳
        String type = "login";
        Map<String, String> map = new HashMap<>();
        map.put("mobile", "13120253308");
        map.put("timestamp", String.valueOf(timestamp));
        map.put("password", "jish68346");
        System.out.println("login_A:" + timestamp);
        map.put("type", type);
                try {
                    String sign = SignUtils.getSignature(map, Api.PRIVATE_KEY);
                    System.out.println("login_A:" + sign);

                } catch (IOException e) {
                    e.printStackTrace();
                }
    }

    private void yanZ() {

        long timestamp = new Date().getTime() / 1000;//时间戳
        String type = "login";
        Map<String, String> map = new HashMap<>();
        map.put("mobile", "13120253308");
        map.put("timestamp", String.valueOf(timestamp));
        map.put("type",type);
        System.out.println("yanZ:" + timestamp);

        try {
            String sign = SignUtils.getSignature(map, Api.PRIVATE_KEY);

            System.out.println("yanZ:" + sign);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    private void register() {

        long timestamp = new Date().getTime() / 1000;//时间戳
        String type = "register";
        Map<String, String> map = new HashMap<>();
        map.put("mobile", "13453904547");
        map.put("timestamp", String.valueOf(timestamp));
        map.put("password", "12345678");
        map.put("passwordVerify", "12345678");
        map.put("Token", "8asopok4mfeu8crd40ar11ise6");
        map.put("type", type);
        System.out.println("register:" + timestamp);

        try {
            String sign = SignUtils.getSignature(map, Api.PRIVATE_KEY);

            System.out.println("register:" + sign);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void jiugong() {
        long timestamp = new Date().getTime() / 1000;//时间戳
        String type = "login";
        Map<String, String> map = new HashMap<>();
        map.put("mobile", "13120253308");
        map.put("timestamp", String.valueOf(timestamp));
        map.put("smscode", "580365");
        System.out.println("jiugong:" + timestamp);
        map.put("type", type);
        map.put("dialog", String.valueOf("8asopok4mfeu8crd40ar11ise6"));
        System.out.println("jiugong:" + timestamp);
        try {
            String sign = SignUtils.getSignature(map, Api.PRIVATE_KEY);

            System.out.println("jiugong:" + sign);

        } catch (IOException e) {
            e.printStackTrace();
        }

   }
    //监听手机的物理按键点击事件
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        //判断用户是否点击的是返回键
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            //如果isExit标记为false，提示用户再次按键
            if (!isExit) {
                isExit = true;
                Toast.makeText(getApplicationContext(), "再按一次退出程序", Toast.LENGTH_SHORT).show();
                //如果用户没有在2秒内再次按返回键的话，就发送消息标记用户为不退出状态
                mHandler.sendEmptyMessageDelayed(0, 5000);
            }
            //如果isExit标记为true，退出程序
            else {
                //退出程序
                finish();
                System.exit(0);
            }
        }
        return false;
    }
}