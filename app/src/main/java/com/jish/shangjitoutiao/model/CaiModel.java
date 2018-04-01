package com.jish.shangjitoutiao.model;

import com.jish.shangjitoutiao.bean.CaiBean;
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

public class CaiModel {
    public void getData(final CaiModelCallBack callBack){
        long timestamp = new Date().getTime() / 1000;//时间戳
        Map<String, String> map = new HashMap<>();
        map.put("timestamp", String.valueOf(timestamp));
        System.out.println("Cai:" + timestamp);
        try {
          String  sign = SignUtils.getSignature(map, Api.PRIVATE_KEY);

            System.out.println("Cai:" + sign);
            RetrofitUtil.api.postCai(sign,String.valueOf(timestamp))
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Consumer<CaiBean>() {
                        @Override
                        public void accept(CaiBean bean) throws Exception {
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

    public interface CaiModelCallBack {
        public void success(CaiBean bean);
    }
}
