package com.jish.shangjitoutiao.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.jish.shangjitoutiao.R;
import com.jish.shangjitoutiao.adapter.SJ_ClassAdapter;
import com.jish.shangjitoutiao.bean.SJ_classBean;
import com.jish.shangjitoutiao.bean.VideoBean;
import com.jish.shangjitoutiao.present.SJ_ClassPresenter;
import com.jish.shangjitoutiao.present.VideoPresenter;
import com.jish.shangjitoutiao.retrofit.RetrofitUtil;
import com.jish.shangjitoutiao.util.Api;
import com.jish.shangjitoutiao.util.SignUtils;
import com.jish.shangjitoutiao.view.SJ_classView;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Adminjs on 2018/2/5.
 */

public class SJ_ClassFragment extends Fragment implements SJ_classView{
    @BindView(R.id.xre_class)
    XRecyclerView xreClass;
    Unbinder unbinder;
    private SJ_ClassAdapter adapter;
    private String param;
    private int page = 1;
    private SJ_ClassPresenter presenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.sj_class_fragment, container, false);
        unbinder = ButterKnife.bind(this, view);
        LinearLayoutManager manager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        xreClass.setLayoutManager(manager);
        adapter = new SJ_ClassAdapter(getActivity());
        xreClass.setAdapter(adapter);
        Bundle bundle = getArguments();
        param = bundle.getString("name", "338");
        presenter = new SJ_ClassPresenter(this);
        presenter.get(page + "", param);

        //允许刷新，加载更多
        xreClass.setPullRefreshEnabled(true);
        xreClass.setLoadingMoreEnabled(true);
        xreClass.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                Toast.makeText(getActivity(), "正在刷新.....！", Toast.LENGTH_SHORT).show();
                page++;
                xreClass.refreshComplete();
            }

            @Override
            public void onLoadMore() {
                Toast.makeText(getActivity(), "正在加载！", Toast.LENGTH_SHORT).show();
                page++;

                long timestamp = new Date().getTime() / 1000;//时间戳
                Map<String, String> map = new HashMap<>();
                map.put("timestamp", String.valueOf(timestamp));
                map.put("page", page+"");
                map.put("cate_id", param);
                System.out.println("SJ_Class:" + timestamp);
                try {
                    String  sign = SignUtils.getSignature(map, Api.PRIVATE_KEY);

                    System.out.println("SJ_Class:" + sign);
                    RetrofitUtil.api.postSJClass(page+"",param,sign,String.valueOf(timestamp))
                            .subscribeOn(Schedulers.io())
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribe(new Observer<SJ_classBean>() {
                                @Override
                                public void onSubscribe(Disposable d) {

                                }

                                @Override
                                public void onNext(SJ_classBean sj_classBean) {
                                     adapter.addData(sj_classBean);
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
                xreClass.loadMoreComplete();
            }
        });
        return view;
    }
    @Override
    public void success(SJ_classBean bean) {
        adapter.addData(bean);
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }


}
