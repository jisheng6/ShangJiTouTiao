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
import com.jish.shangjitoutiao.adapter.VideoAdapter;
import com.jish.shangjitoutiao.bean.VideoBean;
import com.jish.shangjitoutiao.present.VideoPresenter;
import com.jish.shangjitoutiao.retrofit.RetrofitUtil;
import com.jish.shangjitoutiao.util.Api;
import com.jish.shangjitoutiao.util.SignUtils;
import com.jish.shangjitoutiao.view.VideoView;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Adminjs on 2018/1/31.
 */

public class Video_Fraygment extends Fragment implements VideoView {

    @BindView(R.id.xre)
    XRecyclerView xre;
    Unbinder unbinder;
    private VideoPresenter presenter;
    private VideoAdapter adapter;
    private String param;
    private int page = 1;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.video_fenlei_fragment, container, false);
        unbinder = ButterKnife.bind(this, view);
//        SharedPreferences sp = getActivity().getSharedPreferences("sp_demo", Context.MODE_PRIVATE);
//        String id = sp.getString("id", null);
        LinearLayoutManager manager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        xre.setLayoutManager(manager);
        adapter = new VideoAdapter(getActivity());
        xre.setAdapter(adapter);
        Bundle bundle = getArguments();
        param = bundle.getString("name", "331");
        presenter = new VideoPresenter(this);
        presenter.get(page + "", param);
        //允许刷新，加载更多
        xre.setPullRefreshEnabled(true);
        xre.setLoadingMoreEnabled(true);
        xre.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                Toast.makeText(getActivity(), "正在刷新.....！", Toast.LENGTH_SHORT).show();
                page++;
                xre.refreshComplete();
            }

            @Override
            public void onLoadMore() {
                Toast.makeText(getActivity(), "正在加载！", Toast.LENGTH_SHORT).show();
                page++;
                long timestamp = new Date().getTime() / 1000;//时间戳
                Map<String, String> map = new HashMap<>();
                map.put("timestamp", String.valueOf(timestamp));
                map.put("token", String.valueOf("702fc591d39ba1ef404fa1ce4e64dc16"));
                System.out.println("video:" + timestamp);
                map.put("page",page+"");
                map.put("cate_id",param);
                try {
                    String  sign = SignUtils.getSignature(map, Api.PRIVATE_KEY);

                    System.out.println("video:" + sign);
                    RetrofitUtil.api.postVideo(String.valueOf(page),sign,param,String.valueOf(timestamp),String.valueOf("702fc591d39ba1ef404fa1ce4e64dc16"))
                            .subscribeOn(Schedulers.io())
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribe(new Observer<VideoBean>() {
                                @Override
                                public void onSubscribe(Disposable d) {

                                }

                                @Override
                                public void onNext(VideoBean videoBean) {
                                    adapter.addData(videoBean);
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
                xre.loadMoreComplete();
            }
        });
        return view;
    }

    @Override
    public void success(VideoBean bean) {
        adapter.addData(bean);
    }
    @Override
    public void onPause() {
        super.onPause();
        JCVideoPlayerStandard.releaseAllVideos();
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}

