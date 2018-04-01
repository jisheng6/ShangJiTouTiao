package com.jish.shangjitoutiao.present;

import com.jish.shangjitoutiao.bean.ShouYe_XinXiBean;
import com.jish.shangjitoutiao.model.ShouYeModel;
import com.jish.shangjitoutiao.view.ShouYeView;

/**
 * Created by Adminjs on 2018/1/30.
 */

public class ShouYePresenter {
    ShouYeModel shouYeModel;
    ShouYeView view;

    public ShouYePresenter(ShouYeView view) {
        this.view = view;
        this.shouYeModel = new ShouYeModel();
    }
    public void get(String page,String id){
        shouYeModel.getData(page,id, new ShouYeModel.ShouYeModelCallBack() {
            @Override
            public void success(ShouYe_XinXiBean bean) {
                if(view != null){
                    view.success(bean);
                }
            }
        });
    }
}
