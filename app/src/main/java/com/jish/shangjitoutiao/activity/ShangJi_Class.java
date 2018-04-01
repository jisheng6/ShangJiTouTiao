package com.jish.shangjitoutiao.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.jish.shangjitoutiao.R;
import com.jish.shangjitoutiao.bean.JiuGongBean;
import com.jish.shangjitoutiao.fragment.SJ_ClassFragment;
import com.jish.shangjitoutiao.retrofit.RetrofitUtil;
import com.jish.shangjitoutiao.util.Api;
import com.jish.shangjitoutiao.util.SignUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Adminjs on 2018/2/5.
 */

public class ShangJi_Class extends AppCompatActivity {
    @BindView(R.id.tablayout_class)
    TabLayout tablayoutClass;
    @BindView(R.id.viewpager_class)
    ViewPager viewpagerClass;
    @BindView(R.id.class_fan)
    ImageView classFan;
    private ArrayList<String> list;
    private List<String> listid = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shangjiclass);
        ButterKnife.bind(this);
        list = new ArrayList<>();
        sjClass();
    }

    private void sjClass() {
        long timestamp = new Date().getTime() / 1000;//时间戳
        Map<String, String> map = new HashMap<>();
        map.put("timestamp", String.valueOf(timestamp));
        System.out.println("jiugong:" + timestamp);
        try {
            String sign = SignUtils.getSignature(map, Api.PRIVATE_KEY);

            System.out.println("jiugong:" + sign);
            RetrofitUtil.api.postJiuGong(sign, String.valueOf(timestamp))
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Observer<JiuGongBean>() {
                        @Override
                        public void onSubscribe(Disposable d) {

                        }

                        @Override
                        public void onNext(JiuGongBean jiuGongBean) {
                            final List<JiuGongBean.DataBean> data = jiuGongBean.getData();
                            for (int i = 0; i < data.size(); i++) {
                                list.add(data.get(i).getC_name());
                                listid.add(data.get(i).getC_id());
                                viewpagerClass.setOffscreenPageLimit(list.size());
                            }
                            viewpagerClass.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
                                @Override
                                public CharSequence getPageTitle(int position) {
                                    //展示的标题
                                    return list.get(position);
                                }

                                @Override
                                public Fragment getItem(int position) {
                                    //....fragment集合viewPager使用的时候,fragment是new出来的
                                    SJ_ClassFragment sj_classFragment = new SJ_ClassFragment();

                                    Bundle bundle = new Bundle();

                                    //把当前位置的标题传递过去
                                    bundle.putString("name", listid.get(position));

                                    sj_classFragment.setArguments(bundle);

                                    return sj_classFragment;
                                }

                                @Override
                                public int getCount() {
                                    return list.size();
                                }
                            });
                            //绑定在一起
                            tablayoutClass.setupWithViewPager(viewpagerClass);
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

    }

    @OnClick(R.id.class_fan)
    public void onViewClicked() {
        finish();
    }
}
