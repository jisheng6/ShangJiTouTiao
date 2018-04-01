package com.jish.shangjitoutiao.bean;

import java.util.List;

/**
 * Created by Adminjs on 2018/2/2.
 */

public class JiuBean {

    /**
     * status : 1
     * msg : success
     * data : [{"id":"69","uid":"98","cate_id":"339","logo":"https://toutiao.28.com/data/upload/personal_avatars//171206/5a2755bc7e1a9.png_thumb.png","title":"智能揽客系统","sign":"一个简单、快速、高效的广告投放系统！","cate_name":"特色项目"},{"id":"66","uid":"89","cate_id":"338","logo":"https://toutiao.28.com/data/upload/personal_avatars//171127/5a1bdcf2d2226.png_thumb.png","title":"健来福养生古方","sign":"立足古方 自创祖方 百余产品送健康","cate_name":"美容保健"},{"id":"65","uid":"88","cate_id":"338","logo":"https://toutiao.28.com/data/upload/personal_avatars//171127/5a1bda161cf39.png_thumb.png","title":"御膏房","sign":"私房配置 古方膏滋养生","cate_name":"美容保健"},{"id":"63","uid":"87","cate_id":"333","logo":"https://toutiao.28.com/data/upload/personal_avatars//171127/5a1bd7ba52cc3.png_thumb.png","title":"可萌迪雅 潮流女装","sign":"欧意轻奢范 时尚女装","cate_name":"服装鞋帽"},{"id":"62","uid":"86","cate_id":"338","logo":"https://toutiao.28.com/data/upload/personal_avatars//171127/5a1bd60fa5f4b.png_thumb.png","title":"御和堂养生馆","sign":"养生 集大成者","cate_name":"美容保健"},{"id":"61","uid":"84","cate_id":"338","logo":"https://toutiao.28.com/data/upload/personal_avatars//171127/5a1bd3e075cf5.png_thumb.png","title":"中艾堂养生","sign":"千年艾灸，自有艾草园和加工基地","cate_name":"美容保健"},{"id":"60","uid":"85","cate_id":"333","logo":"https://toutiao.28.com/data/upload/personal_avatars//171127/5a1bd46126a6b.png_thumb.png","title":"时尚精致童装","sign":"时尚精致童装","cate_name":"服装鞋帽"},{"id":"59","uid":"83","cate_id":"333","logo":"https://toutiao.28.com/data/upload/personal_avatars//171127/5a1bd0544f45a.png_thumb.png","title":"欧韩时尚 女装品牌","sign":"欧韩时尚 女装品牌","cate_name":"服装鞋帽"},{"id":"56","uid":"81","cate_id":"338","logo":"https://toutiao.28.com/data/upload/personal_avatars//171127/5a1bcccba2543.png_thumb.png","title":"众孝中老年生活馆","sign":"一孝值千金 创业薪趋势","cate_name":"美容保健"},{"id":"55","uid":"80","cate_id":"333","logo":"https://toutiao.28.com/data/upload/personal_avatars//171127/5a1bcc1406f39.png_thumb.png","title":"创意涂鸦童装生活馆","sign":"创意涂鸦童装生活馆","cate_name":"服装鞋帽"},{"id":"54","uid":"78","cate_id":"338","logo":"https://toutiao.28.com/data/upload/personal_avatars//171127/5a1bc9743d05b.png_thumb.png","title":"玫可儿美容护肤","sign":"殿堂般洁面美肤","cate_name":"美容保健"},{"id":"53","uid":"79","cate_id":"338","logo":"https://toutiao.28.com/data/upload/personal_avatars//171127/5a1bc96d02817.png_thumb.png","title":"黛诗菲尔","sign":"美容护理 养生馆","cate_name":"美容保健"},{"id":"51","uid":"76","cate_id":"339","logo":"https://toutiao.28.com/data/upload/personal_avatars//171127/5a1bc728c89e5.png_thumb.png","title":"泊之利乐进口超市","sign":"嗨购全球 营收得利","cate_name":"特色项目"},{"id":"50","uid":"75","cate_id":"337","logo":"https://toutiao.28.com/data/upload/personal_avatars//171127/5a1bc63a0de15.png_thumb.png","title":"清大网校","sign":"清大网校 在线学习","cate_name":"教育网络"},{"id":"49","uid":"74","cate_id":"333","logo":"https://toutiao.28.com/data/upload/personal_avatars//171127/5a1bc549bae0a.png_thumb.png","title":"京城印象老北京布鞋","sign":"时尚平价 人人爱","cate_name":"服装鞋帽"}]
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
         * id : 69
         * uid : 98
         * cate_id : 339
         * logo : https://toutiao.28.com/data/upload/personal_avatars//171206/5a2755bc7e1a9.png_thumb.png
         * title : 智能揽客系统
         * sign : 一个简单、快速、高效的广告投放系统！
         * cate_name : 特色项目
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
