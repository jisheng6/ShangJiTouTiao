package com.jish.shangjitoutiao.fragment;

import android.content.Context;
import android.content.SharedPreferences;
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
import com.jish.shangjitoutiao.adapter.ShouYeAdapter;
import com.jish.shangjitoutiao.bean.ShouYe_XinXiBean;
import com.jish.shangjitoutiao.present.ShouYePresenter;
import com.jish.shangjitoutiao.retrofit.RetrofitUtil;
import com.jish.shangjitoutiao.util.Api;
import com.jish.shangjitoutiao.util.OnItemClickListener;
import com.jish.shangjitoutiao.util.SignUtils;
import com.jish.shangjitoutiao.view.ShouYeView;

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
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Adminjs on 2018/1/30.
 */

public class NewsFragment extends Fragment implements ShouYeView{
    @BindView(R.id.xr)
    XRecyclerView xr;
    Unbinder unbinder;
    private ShouYePresenter presenter;
    private ShouYeAdapter adapter;
    private String param;
    private int page = 1;
    private String pid;
    private String title;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.shouye_fenlei_fragment, container, false);
        unbinder = ButterKnife.bind(this, view);
        LinearLayoutManager manager = new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);
        xr.setLayoutManager(manager);
        adapter = new ShouYeAdapter(getActivity());
        xr.setAdapter(adapter);
        Bundle bundle = getArguments();
        param = bundle.getString("name", "331");
        presenter = new ShouYePresenter(this);
        presenter.get(page+"",param);
        //允许刷新，加载更多
        xr.setPullRefreshEnabled(true);
        xr.setLoadingMoreEnabled(true);

        xr.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                Toast.makeText(getActivity(),"正在刷新！",Toast.LENGTH_SHORT).show();
                page ++;
                xr.refreshComplete();
            }

            @Override
            public void onLoadMore() {
                Toast.makeText(getActivity(),"正在加载....",Toast.LENGTH_SHORT).show();
                page++;
                long timestamp = new Date().getTime() / 1000;//时间戳
                Map<String, String> map = new HashMap<>();
                map.put("timestamp", String.valueOf(timestamp));
                map.put("token", String.valueOf("702fc591d39ba1ef404fa1ce4e64dc16"));
                System.out.println("shouy:" + timestamp);
                map.put("page",page+"");
                map.put("cate_id",param);
                try {
                    String  sign = SignUtils.getSignature(map, Api.PRIVATE_KEY);

                    System.out.println("shouy:" + sign);
                    RetrofitUtil.api.postShouYe(String.valueOf(page),sign,param,String.valueOf(timestamp),String.valueOf("702fc591d39ba1ef404fa1ce4e64dc16"))
                            .subscribeOn(Schedulers.io())
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribe(new Observer<ShouYe_XinXiBean>() {
                                @Override
                                public void onSubscribe(Disposable d) {

                                }

                                @Override
                                public void onNext(ShouYe_XinXiBean shouYeBean) {
                                     adapter.addData(shouYeBean);
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
                xr.loadMoreComplete();
             adapter.setOnItemClickListener(new OnItemClickListener() {
                 @Override
                 public void onItemClick(View view, int position) {
                 }
             });
            }
        });
        return view;
    }
    @Override
    public void success(ShouYe_XinXiBean bean) {
        adapter.addData(bean);
        for (int i=0;i<bean.getData().size();i++){
            title = bean.getData().get(i).getTitle();
        }
        SharedPreferences sp = getActivity().getSharedPreferences("sp_demo", Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = sp.edit();
        edit.putString("title", title);
        edit.commit();
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }


}
