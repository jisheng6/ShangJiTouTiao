package com.jish.shangjitoutiao.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

import com.jish.shangjitoutiao.R;
import com.jish.shangjitoutiao.activity.ShangJi_SouSuoActivity;
import com.jish.shangjitoutiao.activity.ShouYe_SouSuoActivity;
import com.jish.shangjitoutiao.adapter.CaiAdapter;
import com.jish.shangjitoutiao.adapter.JiuGongAdapter;
import com.jish.shangjitoutiao.adapter.TuiJianAdapter;
import com.jish.shangjitoutiao.adapter.ZixunAdapter;
import com.jish.shangjitoutiao.bean.CaiBean;
import com.jish.shangjitoutiao.bean.JiuGongBean;
import com.jish.shangjitoutiao.bean.ShangJiBannerBean;
import com.jish.shangjitoutiao.bean.TuiJianBean;
import com.jish.shangjitoutiao.bean.ZiXunBean;
import com.jish.shangjitoutiao.present.CaiPresenter;
import com.jish.shangjitoutiao.present.JiuGongPresenter;
import com.jish.shangjitoutiao.present.TuiJianPresenter;
import com.jish.shangjitoutiao.present.ZiXunPresenter;
import com.jish.shangjitoutiao.retrofit.RetrofitUtil;
import com.jish.shangjitoutiao.util.Api;
import com.jish.shangjitoutiao.util.GlideImageLoader;
import com.jish.shangjitoutiao.util.SignUtils;
import com.jish.shangjitoutiao.view.CaiView;
import com.jish.shangjitoutiao.view.JiuGongView;
import com.jish.shangjitoutiao.view.TuiJianView;
import com.jish.shangjitoutiao.view.ZiXunView;
import com.youth.banner.Banner;

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

public class Fragment_shangji extends Fragment implements JiuGongView, ZiXunView, TuiJianView, CaiView {
    @BindView(R.id.banner)
    Banner banner;
    Unbinder unbinder;
    @BindView(R.id.jiu_recycler)
    RecyclerView jiuRecycler;
    @BindView(R.id.zi_recycler)
    RecyclerView ziRecycler;
    @BindView(R.id.tui_recycler)
    RecyclerView tuiRecycler;
    @BindView(R.id.cai_recycler)
    RecyclerView caiRecycler;
    @BindView(R.id.sjsousuo_edit)
    EditText sjsousuoEdit;
    @BindView(R.id.sjsousuo_search)
    ImageView sjsousuoSearch;

    private List<ShangJiBannerBean.DataBean> data;
    private List<String> list;
    private JiuGongPresenter presenter;
    private JiuGongAdapter adapter;
    private ZiXunPresenter ziXunPresenter;
    private ZixunAdapter zixunAdapter;
    private TuiJianPresenter tuiJianPresenter;
    private TuiJianAdapter tuiJianAdapter;
    private CaiPresenter caiPresenter;
    private CaiAdapter caiAdapter;
    private String id;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_shangji, container, false);
        unbinder = ButterKnife.bind(this, view);
        lunBo();
        jiuGong();
        ziXun();
        tuiJian();
        cai();
        return view;
    }

    private void cai() {
        caiPresenter = new CaiPresenter(this);
        caiPresenter.get();
        LinearLayoutManager caimanager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        caiRecycler.setLayoutManager(caimanager);
        caiAdapter = new CaiAdapter(getActivity());
        caiRecycler.setAdapter(caiAdapter);
    }

    private void tuiJian() {
        tuiJianPresenter = new TuiJianPresenter(this);
        tuiJianPresenter.get();
        LinearLayoutManager tuijianmanager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        tuiRecycler.setLayoutManager(tuijianmanager);
        tuiJianAdapter = new TuiJianAdapter(getActivity());
        tuiRecycler.setAdapter(tuiJianAdapter);
    }

    private void ziXun() {
        ziXunPresenter = new ZiXunPresenter(this);
        ziXunPresenter.get();
        LinearLayoutManager lamanager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        ziRecycler.setLayoutManager(lamanager);
        zixunAdapter = new ZixunAdapter(getActivity());
        ziRecycler.setAdapter(zixunAdapter);
    }

    private void jiuGong() {
        presenter = new JiuGongPresenter(this);
        presenter.get();
        GridLayoutManager manager = new GridLayoutManager(getActivity(), 4);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        jiuRecycler.setLayoutManager(manager);
        adapter = new JiuGongAdapter(getActivity());
        jiuRecycler.setAdapter(adapter);
    }

    private void lunBo() {
        long timestamp = new Date().getTime() / 1000;//时间戳
        Map<String, String> map = new HashMap<>();
        map.put("timestamp", String.valueOf(timestamp));
        System.out.println("banner:" + timestamp);
        try {
            String sign = SignUtils.getSignature(map, Api.PRIVATE_KEY);
            System.out.println("banner:" + sign);
            list = new ArrayList<>();
            RetrofitUtil.api.postBanner(sign, String.valueOf(timestamp))
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Observer<ShangJiBannerBean>() {
                        @Override
                        public void onSubscribe(Disposable d) {

                        }

                        @Override
                        public void onNext(ShangJiBannerBean shangJiBannerBean) {
                            data = shangJiBannerBean.getData();
                            for (int i = 0; i < data.size(); i++) {
                                list.add(data.get(i).getImg_src());
                            }
                            banner.setImageLoader(new GlideImageLoader());
                            //设置集合
                            banner.setImages(list);
                            //banner执行完方法之后调用
                            banner.start();
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

    @Override
    public void success(JiuGongBean bean) {
        adapter.addData(bean);
    }

    @Override
    public void success(ZiXunBean bean) {
        zixunAdapter.addData(bean);
    }

    @Override
    public void success(TuiJianBean bean) {
        tuiJianAdapter.addData(bean);
    }

    @Override
    public void success(CaiBean bean) {
        for (int i=0;i<bean.getData().size();i++){
            id = bean.getData().get(i).getCate_id();
        }
        SharedPreferences sp = getActivity().getSharedPreferences("sp_demo", Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = sp.edit();
        edit.putString("id", id);
        edit.commit();
        caiAdapter.addData(bean);
    }
    @OnClick(R.id.sjsousuo_search)
    public void onViewClicked() {
        String sjsousuoedit = sjsousuoEdit.getText().toString().trim();
        Intent intent = new Intent(getActivity(),ShangJi_SouSuoActivity.class);
        intent.putExtra("sjsousuo",sjsousuoedit);
        startActivity(intent);
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }



}
