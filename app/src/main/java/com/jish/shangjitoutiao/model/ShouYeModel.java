package com.jish.shangjitoutiao.model;

import com.jish.shangjitoutiao.bean.ShouYe_XinXiBean;
import com.jish.shangjitoutiao.retrofit.RetrofitUtil;
import com.jish.shangjitoutiao.util.Api;
import com.jish.shangjitoutiao.util.SignUtils;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Adminjs on 2018/1/30.
 */

public class ShouYeModel {

    public void getData(String page,String id, final ShouYeModelCallBack callBack){
        long timestamp = new Date().getTime() / 1000;//时间戳
        Map<String, String> map = new HashMap<>();
        map.put("timestamp", String.valueOf(timestamp));
        map.put("token", String.valueOf("702fc591d39ba1ef404fa1ce4e64dc16"));
        System.out.println("shouy:" + timestamp);
        map.put("page",1+"");
        map.put("cate_id",id);
        try {
          String  sign = SignUtils.getSignature(map, Api.PRIVATE_KEY);

            System.out.println("shouy:" + sign);
            RetrofitUtil.api.postShouYe(page,sign,id,String.valueOf(timestamp),String.valueOf("702fc591d39ba1ef404fa1ce4e64dc16"))
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Consumer<ShouYe_XinXiBean>() {
                        @Override
                        public void accept(ShouYe_XinXiBean bean) throws Exception {
                            callBack.success(bean);
                        }
                    }, new Consumer<Throwable>() {
                        @Override
                        public void accept(Throwable throwable) throws Exception {

                        }
                    });

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public interface ShouYeModelCallBack {
        public void success(ShouYe_XinXiBean bean);
    }
}
