package com.jish.shangjitoutiao.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
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
import com.jish.shangjitoutiao.bean.DongLoginBean;
import com.jish.shangjitoutiao.bean.YanZma_loginBean;
import com.jish.shangjitoutiao.retrofit.RetrofitUtil;
import com.jish.shangjitoutiao.util.Api;
import com.jish.shangjitoutiao.util.CountDownTimerUtils;
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

public class Fragment_login_ipone extends Fragment{
    @BindView(R.id.useripone)
    EditText useripone;
    @BindView(R.id.smscode)
    EditText smscode;
    @BindView(R.id.ji)
    TextView ji;
    @BindView(R.id.login_a)
    Button loginA;
    @BindView(R.id.register_a)
    Button registerA;
    Unbinder unbinder;
    @BindView(R.id.huoqu)
    TextView huoqu;
    int time = 60;
    private Handler handler;
    private String p;
    private String dialog;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login_ipone, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.ji, R.id.login_a, R.id.register_a,R.id.huoqu})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ji:
                Intent intent1 = new Intent(getActivity(), ZhaoMiActivity.class);
                startActivity(intent1);
                break;
            case R.id.huoqu:
                if (!TextUtils.isEmpty(useripone.getText())){
                    CountDownTimerUtils mCountDownTimerUtils = new CountDownTimerUtils(huoqu, 60000, 1000);
                    mCountDownTimerUtils.start();
                }else{
                    Toast.makeText(getActivity(), "手机格式不正确", Toast.LENGTH_SHORT).show();
                }
                p = useripone.getText().toString().trim();
                long timestamp = new Date().getTime() / 1000;//时间戳
                String type = "login";
                Map<String, String> map = new HashMap<>();
                map.put("mobile", p);
                map.put("timestamp", String.valueOf(timestamp));
                map.put("type", type);
                System.out.println("yanZ_login:" + timestamp);
                try {
                    String sign = SignUtils.getSignature(map, Api.PRIVATE_KEY);
                    System.out.println("yanZ_login:" + sign);
                    RetrofitUtil.api.postDuanXin_login(p,sign,String.valueOf(timestamp),type)
                            .subscribeOn(Schedulers.io())
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribe(new Observer<YanZma_loginBean>() {
                                @Override
                                public void onSubscribe(Disposable d) {

                                }

                                @Override
                                public void onNext(YanZma_loginBean yanZma_loginBean) {
                                    dialog = yanZma_loginBean.getDialog();
                                    int status = yanZma_loginBean.getStatus();
                                    if (status == 1) {
                                        Toast.makeText(getActivity(), yanZma_loginBean.getMsg(), Toast.LENGTH_SHORT).show();
//                                        SharedPreferences sp = getActivity().getSharedPreferences("sp_demo", Context.MODE_PRIVATE);
//                                        SharedPreferences.Editor edit = sp.edit();
//                                        edit.putString("dialog", dialog);
//                                        edit.commit();
                                    } else {
                                        Toast.makeText(getActivity(), "发送失败", Toast.LENGTH_SHORT).show();
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
            case R.id.login_a:
      //          String zhanghao = useripone.getText().toString().trim();
                String smscod = smscode.getText().toString().trim();
//                SharedPreferences sp = getActivity().getSharedPreferences("sp_demo", Context.MODE_PRIVATE);
//                String dialog = sp.getString("dialog", null);
                long timestamp_login = new Date().getTime() / 1000;//时间戳
                String type_login = "login";
                Map<String, String> map_login = new HashMap<>();
                map_login.put("mobile", p);
                map_login.put("timestamp", String.valueOf(timestamp_login));
                map_login.put("smscode", smscod);
                map_login.put("Token",dialog);
                System.out.println("dong:" + timestamp_login);
                map_login.put("type", type_login);
                try {
                    String sign_login = SignUtils.getSignature(map_login, Api.PRIVATE_KEY);
                    System.out.println("dong_login:" + sign_login);
                    RetrofitUtil.api.postdong_login(p,smscod,sign_login,String.valueOf(timestamp_login),dialog,type_login)
                            .subscribeOn(Schedulers.io())
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribe(new Observer<DongLoginBean>() {
                                @Override
                                public void onSubscribe(Disposable d) {

                                }

                                @Override
                                public void onNext(DongLoginBean dongLoginBean) {
                                    int status_login = dongLoginBean.getStatus();
                                    if (status_login == 1) {
                                        Toast.makeText(getActivity(), dongLoginBean.getMsg(), Toast.LENGTH_SHORT).show();
                                        Intent intent = new Intent(getActivity(), MainActivity.class);
                                        startActivity(intent);
                                    }else{
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
            case R.id.register_a:
                Intent intent = new Intent(getActivity(), RegisterActivity.class);
                startActivity(intent);
                break;
        }
    }
}
