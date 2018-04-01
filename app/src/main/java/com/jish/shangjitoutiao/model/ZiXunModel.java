package com.jish.shangjitoutiao.model;

import com.jish.shangjitoutiao.bean.JiuGongBean;
import com.jish.shangjitoutiao.bean.ZiXunBean;
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

public class ZiXunModel {
    public void getData(final ZiXunModelCallBack callBack){
        long timestamp = new Date().getTime() / 1000;//时间戳
        Map<String, String> map = new HashMap<>();
        map.put("timestamp", String.valueOf(timestamp));
        System.out.println("zixun:" + timestamp);
        try {
          String  sign = SignUtils.getSignature(map, Api.PRIVATE_KEY);

            System.out.println("zixun:" + sign);
            RetrofitUtil.api.postZiXun(sign,String.valueOf(timestamp))
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Consumer<ZiXunBean>() {
                        @Override
                        public void accept(ZiXunBean bean) throws Exception {
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

    public interface ZiXunModelCallBack {
        public void success(ZiXunBean bean);
    }
}
