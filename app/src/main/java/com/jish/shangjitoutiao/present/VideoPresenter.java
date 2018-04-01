package com.jish.shangjitoutiao.present;


import com.jish.shangjitoutiao.bean.VideoBean;
import com.jish.shangjitoutiao.model.VideoModel;
import com.jish.shangjitoutiao.view.VideoView;

/**
 * Created by Adminjs on 2018/1/30.
 */

public class VideoPresenter {
    private VideoModel model;
    private VideoView view;

    public VideoPresenter(VideoView view) {
        this.view = view;
        this.model = new VideoModel();
    }
    public void get(String page,String id){
       model.getData(page, id, new VideoModel.VideoModelCallBack() {
           @Override
           public void success(VideoBean bean) {
               if(view != null){
                   view.success(bean);
               }
           }
       });
    }
}
