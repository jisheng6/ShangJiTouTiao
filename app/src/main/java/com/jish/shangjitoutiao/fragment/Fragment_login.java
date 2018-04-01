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
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.jish.shangjitoutiao.MainActivity;
import com.jish.shangjitoutiao.R;
import com.jish.shangjitoutiao.activity.RegisterActivity;
import com.jish.shangjitoutiao.activity.ZhaoMiActivity;
import com.jish.shangjitoutiao.bean.LoginBean;
import com.jish.shangjitoutiao.retrofit.RetrofitUtil;
import com.jish.shangjitoutiao.util.Api;
import com.jish.shangjitoutiao.util.SignUtils;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Adminjs on 2018/2/1.
 */

public class Fragment_login extends Fragment {
    @BindView(R.id.ipone)
    EditText ipone;
    @BindView(R.id.pass)
    EditText pass;
    @BindView(R.id.wang)
    TextView wang;
    @BindView(R.id.login_n)
    Button loginN;
    @BindView(R.id.register_n)
    Button registerN;
    Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.wang, R.id.login_n, R.id.register_n})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.wang:
                Intent intent1 = new Intent(getActivity(), ZhaoMiActivity.class);
                startActivity(intent1);
                break;
            case R.id.login_n:
                String p = ipone.getText().toString().trim();
                String pa = pass.getText().toString().trim();
                long timestamp = new Date().getTime() / 1000;//时间戳
                String type = "login";
                Map<String, String> map = new HashMap<>();
                map.put("mobile", p);
                map.put("timestamp", String.valueOf(timestamp));
                map.put("password", pa);
                System.out.println("login:" + timestamp);
                map.put("type", type);
                try {
                    String sign = SignUtils.getSignature(map, Api.PRIVATE_KEY);
                    System.out.println("login:" + sign);

                    RetrofitUtil.api.postLogin(p,pa,sign,String.valueOf(timestamp),type)
                            .subscribeOn(Schedulers.io())
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribe(new Observer<LoginBean>() {
                                @Override
                                public void onSubscribe(Disposable d) {

                                }

                                @Override
                                public void onNext(LoginBean loginBean) {
                                    int status = loginBean.getStatus();
                                    if (status == 1) {
                                        Toast.makeText(getActivity(), loginBean.getMsg(), Toast.LENGTH_SHORT).show();
                                        Intent intent = new Intent(getActivity(), MainActivity.class);
                                        String uid = loginBean.getData().getUser().getUid();
                                        String token = loginBean.getData().getYunxin().getToken();
                                        String name = loginBean.getData().getUser().getNickname();
                                        String avatar = loginBean.getData().getUser().getAvatar();
                                        SharedPreferences sp = getActivity().getSharedPreferences("sp_demo", Context.MODE_PRIVATE);
                                        SharedPreferences.Editor edit = sp.edit();
                                        edit.putString("token",token);
                                        edit.putString("uid", uid);
                                        edit.putString("name",name);
                                        edit.putString("avatar",avatar);
                                        edit.commit();
                                        startActivity(intent);
                                    } else {
                                        Toast.makeText(getActivity(), "登录失败", Toast.LENGTH_SHORT).show();
                                    }
                                }

                                @Override
                                public void onError(Throwable e) {

                                }

                                @Override
                                public void onComplete() {

                                }
                            });
                } catch (IOException e) {
                    e.printStackTrace();
                }

                break;
            case R.id.register_n:
                Intent intent = new Intent(getActivity(), RegisterActivity.class);
                startActivity(intent);
                break;
        }
    }
}
