package com.jish.shangjitoutiao.present;


import com.jish.shangjitoutiao.bean.JiuGongBean;
import com.jish.shangjitoutiao.bean.VideoBean;
import com.jish.shangjitoutiao.model.JiuGongModel;
import com.jish.shangjitoutiao.model.VideoModel;
import com.jish.shangjitoutiao.view.JiuGongView;
import com.jish.shangjitoutiao.view.VideoView;

/**
 * Created by Adminjs on 2018/1/30.
 */

public class JiuGongPresenter {
    private JiuGongModel model;
    private JiuGongView view;

    public JiuGongPresenter(JiuGongView view) {
        this.view = view;
        this.model = new JiuGongModel();
    }
    public void get(){
       model.getData(new JiuGongModel.JiuGongModelCallBack() {
           @Override
           public void success(JiuGongBean bean) {
               if(view != null){
                   view.success(bean);
               }
           }
       });
    }
}
