package com.jish.shangjitoutiao.present;


import com.jish.shangjitoutiao.bean.JiuGongBean;
import com.jish.shangjitoutiao.bean.ZiXunBean;
import com.jish.shangjitoutiao.model.JiuGongModel;
import com.jish.shangjitoutiao.model.ZiXunModel;
import com.jish.shangjitoutiao.view.JiuGongView;
import com.jish.shangjitoutiao.view.ZiXunView;

/**
 * Created by Adminjs on 2018/1/30.
 */

public class ZiXunPresenter {
    private ZiXunModel model;
    private ZiXunView view;

    public ZiXunPresenter(ZiXunView view) {
        this.view = view;
        this.model = new ZiXunModel();
    }
    public void get(){
       model.getData(new ZiXunModel.ZiXunModelCallBack() {
           @Override
           public void success(ZiXunBean bean) {
               if(view != null){
                   view.success(bean);
               }
           }
       });
    }
}
