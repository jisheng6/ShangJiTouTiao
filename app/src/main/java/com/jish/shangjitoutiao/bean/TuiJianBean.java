package com.jish.shangjitoutiao.bean;

import java.util.List;

/**
 * Created by Adminjs on 2018/2/2.
 */

public class TuiJianBean {

    /**
     * status : 1
     * msg : success
     * data : [{"id":"58","uid":"82","cate_id":"338","logo":"https://toutiao.28.com/data/upload/personal_avatars//171127/5a1bd08e21039.png_thumb.png","title":"纤思韵产后修复","sign":"产后恢复调理中心-展现辣妈曲线身型","cate_name":"美容保健"},{"id":"35","uid":"61","cate_id":"334","logo":"https://toutiao.28.com/data/upload/personal_avatars//180201/5a72e294b0dbc.png_thumb.png","title":"洁希亚洗衣","sign":"更强净争力","cate_name":"环保机械"},{"id":"29","uid":"54","cate_id":"339","logo":"https://toutiao.28.com/data/upload/personal_avatars//171127/5a1bae1aea3ea.png_thumb.png","title":"VR主题公园","sign":"VR乐园 畅玩挣不停","cate_name":"特色项目"},{"id":"14","uid":"39","cate_id":"332","logo":"https://toutiao.28.com/data/upload/personal_avatars//171127/5a1b8524586ba.png_thumb.png","title":"乔东家排骨大包","sign":"秘制排骨大包 2人开店挣","cate_name":"餐饮小吃"},{"id":"1","uid":"1","cate_id":"337","logo":"https://toutiao.28.com/data/upload/personal_avatars//171125/5a195bd1066b7.png_thumb.png","title":"商机头条","sign":"创业保障 签约付费","cate_name":"教育网络"}]
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
         * id : 58
         * uid : 82
         * cate_id : 338
         * logo : https://toutiao.28.com/data/upload/personal_avatars//171127/5a1bd08e21039.png_thumb.png
         * title : 纤思韵产后修复
         * sign : 产后恢复调理中心-展现辣妈曲线身型
         * cate_name : 美容保健
         */

        private String id;
        private String uid;
        private String cate_id;
        private String logo;
        private String title;
        private String sign;
        private String cate_name;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getUid() {
            return uid;
        }

        public void setUid(String uid) {
            this.uid = uid;
        }

        public String getCate_id() {
            return cate_id;
        }

        public void setCate_id(String cate_id) {
            this.cate_id = cate_id;
        }

        public String getLogo() {
            return logo;
        }

        public void setLogo(String logo) {
            this.logo = logo;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getSign() {
            return sign;
        }

        public void setSign(String sign) {
            this.sign = sign;
        }

        public String getCate_name() {
            return cate_name;
        }

        public void setCate_name(String cate_name) {
            this.cate_name = cate_name;
        }
    }
}
