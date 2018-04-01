package com.jish.shangjitoutiao.present;


import com.jish.shangjitoutiao.bean.CaiBean;
import com.jish.shangjitoutiao.bean.TuiJianBean;
import com.jish.shangjitoutiao.model.CaiModel;
import com.jish.shangjitoutiao.model.TuiJianModel;
import com.jish.shangjitoutiao.view.CaiView;
import com.jish.shangjitoutiao.view.TuiJianView;

/**
 * Created by Adminjs on 2018/1/30.
 */

public class CaiPresenter {
    private CaiModel model;
    private CaiView view;

    public CaiPresenter(CaiView view) {
        this.view = view;
        this.model = new CaiModel();
    }
    public void get(){
       model.getData(new CaiModel.CaiModelCallBack() {
           @Override
           public void success(CaiBean bean) {
               if(view != null){
                   view.success(bean);
               }
           }
       });
    }
}
