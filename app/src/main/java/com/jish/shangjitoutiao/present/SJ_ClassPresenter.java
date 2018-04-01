package com.jish.shangjitoutiao.present;


import com.jish.shangjitoutiao.bean.CaiBean;
import com.jish.shangjitoutiao.bean.SJ_classBean;
import com.jish.shangjitoutiao.model.CaiModel;
import com.jish.shangjitoutiao.model.SJ_ClassModel;
import com.jish.shangjitoutiao.view.CaiView;
import com.jish.shangjitoutiao.view.SJ_classView;

/**
 * Created by Adminjs on 2018/1/30.
 */

public class SJ_ClassPresenter {
    private SJ_ClassModel model;
    private SJ_classView view;

    public SJ_ClassPresenter(SJ_classView view) {
        this.view = view;
        this.model = new SJ_ClassModel();
    }
    public void get(String page,String id){
       model.getData(page,id,new SJ_ClassModel.SJ_ClassModelCallBack() {
           @Override
           public void success(SJ_classBean bean) {
               if(view != null){
                   view.success(bean);
               }
           }
        });
    }
}
