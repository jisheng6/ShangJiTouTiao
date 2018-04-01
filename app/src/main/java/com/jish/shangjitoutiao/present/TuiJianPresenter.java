package com.jish.shangjitoutiao.present;


import com.jish.shangjitoutiao.bean.TuiJianBean;
import com.jish.shangjitoutiao.bean.ZiXunBean;
import com.jish.shangjitoutiao.model.TuiJianModel;
import com.jish.shangjitoutiao.model.ZiXunModel;
import com.jish.shangjitoutiao.view.TuiJianView;
import com.jish.shangjitoutiao.view.ZiXunView;

/**
 * Created by Adminjs on 2018/1/30.
 */

public class TuiJianPresenter {
    private TuiJianModel model;
    private TuiJianView view;

    public TuiJianPresenter(TuiJianView view) {
        this.view = view;
        this.model = new TuiJianModel();
    }
    public void get(){
       model.getData(new TuiJianModel.TuiJianModelCallBack() {
           @Override
           public void success(TuiJianBean bean) {
               if(view != null){
                   view.success(bean);
               }
           }
       });
    }
}
