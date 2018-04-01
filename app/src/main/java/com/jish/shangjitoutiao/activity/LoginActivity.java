package com.jish.shangjitoutiao.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;

import com.jish.shangjitoutiao.MainActivity;
import com.jish.shangjitoutiao.R;
import com.jish.shangjitoutiao.adapter.HomeAdapter;
import com.jish.shangjitoutiao.fragment.Fragment_login;
import com.jish.shangjitoutiao.fragment.Fragment_login_ipone;
import com.jish.shangjitoutiao.util.BanViewPager;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Adminjs on 2018/2/1.
 */

public class LoginActivity extends AppCompatActivity {
    @BindView(R.id.tablayout)
    TabLayout tablayout;
    @BindView(R.id.viewpager)
    BanViewPager viewpager;
    private HomeAdapter adapter;
    private ArrayList<String> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        ArrayList<Fragment> fragment = new ArrayList<>();
        fragment.add(new Fragment_login());
        fragment.add(new Fragment_login_ipone());
        adapter = new HomeAdapter(getSupportFragmentManager(), fragment, list);
        adapter.setData(fragment);
        list = new ArrayList<>();
        list.add("账号密码登录");
        list.add("手机动态登录");
        adapter.setTabs(list);
        viewpager.setAdapter(adapter);
        tablayout.setupWithViewPager(viewpager);
    }
    public void onClick(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
           onClick();
            return true;
        }
        return false;
    }
}