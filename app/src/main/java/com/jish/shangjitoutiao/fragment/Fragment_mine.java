package com.jish.shangjitoutiao.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.drawee.view.SimpleDraweeView;
import com.jish.shangjitoutiao.R;
import com.jish.shangjitoutiao.activity.BoLeActivity;
import com.jish.shangjitoutiao.activity.FaBuActivity;
import com.jish.shangjitoutiao.activity.FaBuWZActivity;
import com.jish.shangjitoutiao.activity.FenSiActivity;
import com.jish.shangjitoutiao.activity.FenXiangctivity;
import com.jish.shangjitoutiao.activity.GuanZhuActivity;
import com.jish.shangjitoutiao.activity.JiHuaActivity;
import com.jish.shangjitoutiao.activity.KaoChaActivity;
import com.jish.shangjitoutiao.activity.LoginActivity;
import com.jish.shangjitoutiao.activity.RenZhengActivity;
import com.jish.shangjitoutiao.activity.SheZhiActivity;
import com.jish.shangjitoutiao.activity.ShouCangActivity;
import com.jish.shangjitoutiao.activity.ShouYueActivity;
import com.jish.shangjitoutiao.activity.TuiJianActivity;
import com.jish.shangjitoutiao.activity.ZhuanZaiWZActivity;

/**
 * Created by Adminjs on 2018/1/30.
 */

public class Fragment_mine extends Fragment implements View.OnClickListener {
    private SimpleDraweeView simp;
    private TextView tit1;
    private TextView tui;
    private LinearLayout fabu;
    private LinearLayout fenxiang;
    private LinearLayout kaocha;
    private LinearLayout tuijian;
    private ImageView shezhi;
    private LinearLayout guanzhu;
    private LinearLayout fensi;
    private LinearLayout shoucang;
    private LinearLayout bole;
    private LinearLayout zhuangzaiwz;
    private LinearLayout fabuwz;
    private LinearLayout renzheng;
    private LinearLayout shouyue;
    private LinearLayout jihua;
    private View view;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        SharedPreferences sp = getActivity().getSharedPreferences("sp_demo", Context.MODE_PRIVATE);
        String uid = sp.getString("uid", null);
        if (uid != null) {
            view = inflater.inflate(R.layout.fragment_mine, container, false);
            String name = sp.getString("name", null);
            String avatar = sp.getString("avatar", null);
            BuJu();
            tit1.setText(name);
            simp.setImageURI(avatar);
            return view;

        } else {
            Intent intent = new Intent(getActivity(), LoginActivity.class);
            startActivity(intent);
            getActivity().finish();
            return null;
        }
    }

    private void BuJu() {
        simp = view.findViewById(R.id.simp);
        tit1 = view.findViewById(R.id.titl);
        tui = view.findViewById(R.id.tui);
        fabu = view.findViewById(R.id.fabu);
        fenxiang = view.findViewById(R.id.fenxiang);
        kaocha = view.findViewById(R.id.kaocha);
        tuijian = view.findViewById(R.id.tuijian);
        shezhi = view.findViewById(R.id.shezhi);
        guanzhu = view.findViewById(R.id.guanzhu);
        fensi = view.findViewById(R.id.fensi);
        shoucang = view.findViewById(R.id.shoucang);
        bole = view.findViewById(R.id.bole);
        zhuangzaiwz = view.findViewById(R.id.zhuanzaiwz);
        fabuwz = view.findViewById(R.id.fabuwz);
        renzheng = view.findViewById(R.id.renzheng);
        shouyue = view.findViewById(R.id.shouyue);
        jihua = view.findViewById(R.id.jihua);
        simp.setOnClickListener(this);
        tui.setOnClickListener(this);
        tit1.setOnClickListener(this);
        fabu.setOnClickListener(this);
        fenxiang.setOnClickListener(this);
        kaocha.setOnClickListener(this);
        tuijian.setOnClickListener(this);
        shezhi.setOnClickListener(this);
        guanzhu.setOnClickListener(this);
        fensi.setOnClickListener(this);
        shoucang.setOnClickListener(this);
        bole.setOnClickListener(this);
        zhuangzaiwz.setOnClickListener(this);
        fabuwz.setOnClickListener(this);
        renzheng.setOnClickListener(this);
        shouyue.setOnClickListener(this);
        jihua.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.simp:
                Intent intent = new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);
                break;
            case R.id.titl:
                Intent intent1 = new Intent(getActivity(), LoginActivity.class);
                startActivity(intent1);
                break;
            case R.id.shezhi:
                Intent intents = new Intent(getActivity(), SheZhiActivity.class);
                startActivity(intents);
                break;
            case R.id.fabuwz:
                Intent intentb = new Intent(getActivity(), FaBuWZActivity.class);
                startActivity(intentb);
                break;
            case R.id.guanzhu:
                Intent intentg = new Intent(getActivity(), GuanZhuActivity.class);
                startActivity(intentg);
                break;
            case R.id.fensi:
                Intent intentf = new Intent(getActivity(), FenSiActivity.class);
                startActivity(intentf);
                break;
            case R.id.shoucang:
                Intent intenta = new Intent(getActivity(), ShouCangActivity.class);
                startActivity(intenta);
                break;
            case R.id.zhuanzaiwz:
                Intent intentz = new Intent(getActivity(), ZhuanZaiWZActivity.class);
                startActivity(intentz);
                break;
            case R.id.shouyue:
                Intent intenty = new Intent(getActivity(), ShouYueActivity.class);
                startActivity(intenty);
                break;
            case R.id.bole:
                Intent intentl = new Intent(getActivity(), BoLeActivity.class);
                startActivity(intentl);
                break;
            case R.id.fabu:
                Intent intent3 = new Intent(getActivity(), FaBuActivity.class);
                startActivity(intent3);
                break;
            case R.id.jihua:
                Intent intenth = new Intent(getActivity(), JiHuaActivity.class);
                startActivity(intenth);
                break;
            case R.id.tuijian:
                Intent intent6 = new Intent(getActivity(), TuiJianActivity.class);
                startActivity(intent6);
                break;
            case R.id.renzheng:
                Intent intente = new Intent(getActivity(), RenZhengActivity.class);
                startActivity(intente);
                break;
            case R.id.fenxiang:
                Intent intent4 = new Intent(getActivity(), FenXiangctivity.class);
                startActivity(intent4);
                break;
            case R.id.kaocha:
                Intent intent5 = new Intent(getActivity(), KaoChaActivity.class);
                startActivity(intent5);
                break;
            case R.id.tui:
                SharedPreferences sp = getActivity().getSharedPreferences("sp_demo", Context.MODE_PRIVATE);
                sp.edit().clear().commit();
                Toast.makeText(getActivity(), "已清空", Toast.LENGTH_SHORT).show();
                Intent intent2 = new Intent(getActivity(), LoginActivity.class);
                startActivity(intent2);
                break;
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
