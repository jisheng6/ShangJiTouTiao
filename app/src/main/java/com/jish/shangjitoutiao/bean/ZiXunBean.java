package com.jish.shangjitoutiao.bean;

import java.util.List;

/**
 * Created by Adminjs on 2018/2/2.
 */

public class ZiXunBean {

    /**
     * status : 1
     * msg :
     * data : [{"title":"2017年中国食品饮料最新消费趋势报告","article_id":"128"},{"title":"一个人的格局有多大，看这三点","article_id":"171"},{"title":"你的死工资，正在拖垮你","article_id":"209"},{"title":"创业开店的财富秘籍是什么？","article_id":"298"},{"title":"西式快餐加盟 源动力汤姆之家选址灵活创业轻松","article_id":"401"}]
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
         * title : 2017年中国食品饮料最新消费趋势报告
         * article_id : 128
         */

        private String title;
        private String article_id;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getArticle_id() {
            return article_id;
        }

        public void setArticle_id(String article_id) {
            this.article_id = article_id;
        }
    }
}
