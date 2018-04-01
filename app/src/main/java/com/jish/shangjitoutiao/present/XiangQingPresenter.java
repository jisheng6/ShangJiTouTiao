package com.jish.shangjitoutiao.present;


import com.jish.shangjitoutiao.bean.ShouYe_XiangQingBean;
import com.jish.shangjitoutiao.bean.ZiXunBean;
import com.jish.shangjitoutiao.model.XiangQingModel;
import com.jish.shangjitoutiao.model.ZiXunModel;
import com.jish.shangjitoutiao.view.XiangQingView;
import com.jish.shangjitoutiao.view.ZiXunView;

/**
 * Created by Adminjs on 2018/1/30.
 */

public class XiangQingPresenter {
    private XiangQingModel model;
    private XiangQingView view;

    public XiangQingPresenter(XiangQingView view) {
        this.view = view;
        this.model = new XiangQingModel();
    }
    public void get(String id){
       model.getData(id,new XiangQingModel.XiangQingModelCallBack() {
           @Override
           public void success(ShouYe_XiangQingBean bean) {
               if(view != null){
                   view.success(bean);
               }
           }
       });
    }
}
