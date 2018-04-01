package com.jish.shangjitoutiao.bean;

import java.util.List;

/**
 * Created by Adminjs on 2018/2/1.
 */

public class ShangJiBannerBean {

    /**
     * status : 1
     * msg :
     * data : [{"type":"project","target":"33","title":"汤姆之家","img_src":"https://toutiao.28.com/data/upload/business/banner/tangmuzhijia.jpg"},{"type":"project","target":"59","title":"美家美邦","img_src":"https://toutiao.28.com/data/upload/business/banner/meijiameibang.png"},{"type":"article","target":"71","title":"创业10条必看心得","img_src":"https://toutiao.28.com/data/upload/business/banner/chuangyetip.jpg"}]
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
         * type : project
         * target : 33
         * title : 汤姆之家
         * img_src : https://toutiao.28.com/data/upload/business/banner/tangmuzhijia.jpg
         */

        private String type;
        private String target;
        private String title;
        private String img_src;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getTarget() {
            return target;
        }

        public void setTarget(String target) {
            this.target = target;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getImg_src() {
            return img_src;
        }

        public void setImg_src(String img_src) {
            this.img_src = img_src;
        }
    }
}
