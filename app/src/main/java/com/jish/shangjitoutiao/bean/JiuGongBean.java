package com.jish.shangjitoutiao.bean;

import java.util.List;

/**
 * Created by Adminjs on 2018/2/2.
 */

public class JiuGongBean {

    /**
     * status : 1
     * msg : success
     * data : [{"c_id":"332","images":"http://app206.28.com/static/images/uploads/class/20161008/57f850c779390.png","c_name":"餐饮小吃"},{"c_id":"333","images":"http://app206.28.com/static/images/uploads/class/20161008/57f850d4dd911.png","c_name":"服装鞋帽"},{"c_id":"334","images":"http://app206.28.com/static/images/uploads/class/20161008/57f850dd8c830.png","c_name":"环保机械"},{"c_id":"336","images":"http://app206.28.com/static/images/uploads/class/20161008/57f850ef01830.png","c_name":"家居建材"},{"c_id":"337","images":"http://app206.28.com/static/images/uploads/class/20161008/57f850f96a9c3.png","c_name":"教育网络"},{"c_id":"338","images":"http://app206.28.com/static/images/uploads/class/20161008/57f851018a4f5.png","c_name":"美容保健"},{"c_id":"339","images":"http://app206.28.com/static/images/uploads/class/20161008/57f851441a203.png","c_name":"特色项目"},{"c_id":"0","images":"http://app206.28.com/static/images/uploads/class/20161008/57f850e66a79d.png","c_name":"所有项目"}]
     * dialog : 702fc591d39ba1ef404fa1ce4e64dc16
     */

    private int status;
    private String msg;
    private String dialog;
    private List<DataBean> data;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getDialog() {
        return dialog;
    }

    public void setDialog(String dialog) {
        this.dialog = dialog;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * c_id : 332
         * images : http://app206.28.com/static/images/uploads/class/20161008/57f850c779390.png
         * c_name : 餐饮小吃
         */

        private String c_id;
        private String images;
        private String c_name;

        public String getC_id() {
            return c_id;
        }

        public void setC_id(String c_id) {
            this.c_id = c_id;
        }

        public String getImages() {
            return images;
        }

        public void setImages(String images) {
            this.images = images;
        }

        public String getC_name() {
            return c_name;
        }

        public void setC_name(String c_name) {
            this.c_name = c_name;
        }
    }
}
