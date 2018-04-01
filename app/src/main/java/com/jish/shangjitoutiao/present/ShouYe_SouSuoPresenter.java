package com.jish.shangjitoutiao.present;


import com.jish.shangjitoutiao.bean.ShouYe_SouSuoBean;
import com.jish.shangjitoutiao.bean.ShouYe_XiangQingBean;
import com.jish.shangjitoutiao.model.ShouYe_SouSuoModel;
import com.jish.shangjitoutiao.model.XiangQingModel;
import com.jish.shangjitoutiao.view.ShouYe_SouSuoView;
import com.jish.shangjitoutiao.view.XiangQingView;

/**
 * Created by Adminjs on 2018/1/30.
 */

public class ShouYe_SouSuoPresenter {
    private ShouYe_SouSuoModel model;
    private ShouYe_SouSuoView view;

    public ShouYe_SouSuoPresenter(ShouYe_SouSuoView view) {
        this.view = view;
        this.model = new ShouYe_SouSuoModel();
    }
    public void get(String page,String title){
       model.getData(page,title,new ShouYe_SouSuoModel.ShouYe_SouSuoModelCallBack() {
           @Override
           public void success(ShouYe_SouSuoBean bean) {
               if(view != null){
                   view.success(bean);
               }
           }
       });
    }
}
