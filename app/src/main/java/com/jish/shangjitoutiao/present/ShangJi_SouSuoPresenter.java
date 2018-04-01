package com.jish.shangjitoutiao.present;


import com.jish.shangjitoutiao.bean.ShangJi_SouSuoBean;
import com.jish.shangjitoutiao.model.ShangJi_SouSuoModel;
import com.jish.shangjitoutiao.view.ShangJi_SouSuoView;
/**
 * Created by Adminjs on 2018/1/30.
 */

public class ShangJi_SouSuoPresenter {
    private ShangJi_SouSuoModel model;
    private ShangJi_SouSuoView view;

    public ShangJi_SouSuoPresenter(ShangJi_SouSuoView view) {
        this.view = view;
        this.model = new ShangJi_SouSuoModel();
    }
    public void get(String page,String title,String id){
       model.getData(page,title,id,new ShangJi_SouSuoModel.ShangJi_SouSuoModelCallBack() {
           @Override
           public void success(ShangJi_SouSuoBean bean) {
               if(view != null){
                   view.success(bean);
               }
           }
       });
    }
}
