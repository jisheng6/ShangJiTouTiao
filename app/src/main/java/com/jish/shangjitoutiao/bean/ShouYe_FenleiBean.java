package com.jish.shangjitoutiao.bean;

import java.util.List;

/**
 * Created by Adminjs on 2018/1/31.
 */

public class ShouYe_FenleiBean {

    /**
     * status : 1
     * msg :
     * data : [{"cate_id":"310","cate_name":"财经"},{"cate_id":"309","cate_name":"名人"},{"cate_id":"314","cate_name":"科技"},{"cate_id":"312","cate_name":"创业"},{"cate_id":"311","cate_name":"社会"},{"cate_id":"323","cate_name":"环保"},{"cate_id":"330","cate_name":"公益"},{"cate_id":"331","cate_name":"汽车"},{"cate_id":"322","cate_name":"家居"},{"cate_id":"321","cate_name":"美容"},{"cate_id":"320","cate_name":"服装"},{"cate_id":"319","cate_name":"餐饮"},{"cate_id":"318","cate_name":"文化"},{"cate_id":"317","cate_name":"旅游"},{"cate_id":"316","cate_name":"教育"},{"cate_id":"315","cate_name":"健康"},{"cate_id":"313","cate_name":"房产"}]
     * dialog :
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
         * cate_id : 310
         * cate_name : 财经
         */

        private String cate_id;
        private String cate_name;

        public String getCate_id() {
            return cate_id;
        }

        public void setCate_id(String cate_id) {
            this.cate_id = cate_id;
        }

        public String getCate_name() {
            return cate_name;
        }

        public void setCate_name(String cate_name) {
            this.cate_name = cate_name;
        }
    }
}
