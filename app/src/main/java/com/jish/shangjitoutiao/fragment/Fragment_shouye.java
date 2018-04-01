package com.jish.shangjitoutiao.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

import com.jish.shangjitoutiao.R;
import com.jish.shangjitoutiao.activity.ShouYe_SouSuoActivity;
import com.jish.shangjitoutiao.bean.ShouYe_FenleiBean;
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
import butterknife.Unbinder;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Adminjs on 2018/1/30.
 */

public class Fragment_shouye extends Fragment {
    @BindView(R.id.tab_layout)
    TabLayout tabLayout;
    @BindView(R.id.view_pager)
    ViewPager viewPager;
    Unbinder unbinder;
    @BindView(R.id.sousuo_edit)
    EditText sousuoEdit;
    @BindView(R.id.sousuo_search)
    ImageView sousuoSearch;
    private ArrayList<String> list;
    private List<String> listid = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_shouye, container, false);
        unbinder = ButterKnife.bind(this, view);
        list = new ArrayList<String>();
        fenLei();

        return view;
    }

    private void fenLei() {
        long timestamp = new Date().getTime() / 1000;//时间戳
        Map<String, String> map = new HashMap<>();
        map.put("timestamp", String.valueOf(timestamp));
        map.put("token", String.valueOf("702fc591d39ba1ef404fa1ce4e64dc16"));
        System.out.println("fenlei:" + timestamp);
        try {
            String sign = SignUtils.getSignature(map, Api.PRIVATE_KEY);

            System.out.println("fenlei:" + sign);
            RetrofitUtil.api.postFenLei(sign, String.valueOf(timestamp), String.valueOf("702fc591d39ba1ef404fa1ce4e64dc16"))
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Observer<ShouYe_FenleiBean>() {
                        @Override
                        public void onSubscribe(Disposable d) {

                        }
                        @Override
                        public void onNext(ShouYe_FenleiBean fenleiBean) {
                            final List<ShouYe_FenleiBean.DataBean> data = fenleiBean.getData();
                            list.add("推荐");
                            listid.add(String.valueOf(data.get(0).getCate_id().equals("300")));
                            for (int i = 0; i < data.size(); i++) {
                                list.add(data.get(i).getCate_name());
                                listid.add(data.get(i).getCate_id());
                            }
                            viewPager.setOffscreenPageLimit(list.size());
                            viewPager.setAdapter(new FragmentPagerAdapter(getFragmentManager()) {
                                @Override
                                public CharSequence getPageTitle(int position) {
                                    //展示的标题
                                    return list.get(position);
                                }

                                @Override
                                public Fragment getItem(int position) {
                                    //....fragment集合viewPager使用的时候,fragment是new出来的
                                    NewsFragment newsFragment = new NewsFragment();

                                    Bundle bundle = new Bundle();

                                    //把当前位置的标题传递过去
                                    bundle.putString("name", listid.get(position));

                                    newsFragment.setArguments(bundle);

                                    return newsFragment;
                                }

                                @Override
                                public int getCount() {
                                    return list.size();
                                }
                            });
                            //绑定在一起
                            tabLayout.setupWithViewPager(viewPager);
                        }

                        @Override
                        public void onError(Throwable e) {

                        }

                        @Override
                        public void onComplete() {

                        }
                    });
            tabLayout.setupWithViewPager(viewPager);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @OnClick(R.id.sousuo_search)
    public void onViewClicked() {
        String sousuoedit = sousuoEdit.getText().toString().trim();
        Intent intent = new Intent(getActivity(),ShouYe_SouSuoActivity.class);
        intent.putExtra("sousuo",sousuoedit);
        startActivity(intent);
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
