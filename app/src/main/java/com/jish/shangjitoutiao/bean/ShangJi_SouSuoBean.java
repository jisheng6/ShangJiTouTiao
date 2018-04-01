package com.jish.shangjitoutiao.bean;

import java.util.List;

/**
 * Created by Adminjs on 2018/2/5.
 */

public class ShangJi_SouSuoBean {

    /**
     * status : 1
     * msg :
     * data : [{"id":"66","uid":"89","logo":"https://toutiao.28.com/data/upload/personal_avatars//171127/5a1bdcf2d2226.png_thumb.png","logo_original":"https://toutiao.28.com/data/upload/personal_avatars//171127/5a1bdcf2d2226.png","enterprise_name":"健来福养生古方","enterprise_contacts":"邱女士","enterprise_contact_tel":"010-60846618-2816","enterprise_contact_address":"广州市番禺区大道北555号天安科技园创业中心","enterprise_license":"https://toutiao.28.com/data/upload/article_img/1711/27/5a1bdb64d8b78.jpg","check_status":"1","check_comment":"","check_time":"2017-11-27 17:31:31","add_date":"2017-11-27","add_time":"2017-11-27 17:38:14","sign":"立足古方 自创祖方 百余产品送健康","company_name":"健来福养生古方","cate_id":"338","is_recommended":"0","title":"健来福养生古方"}]
     * dialog : 8asopok4mfeu8crd40ar11ise6
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
         * id : 66
         * uid : 89
         * logo : https://toutiao.28.com/data/upload/personal_avatars//171127/5a1bdcf2d2226.png_thumb.png
         * logo_original : https://toutiao.28.com/data/upload/personal_avatars//171127/5a1bdcf2d2226.png
         * enterprise_name : 健来福养生古方
         * enterprise_contacts : 邱女士
         * enterprise_contact_tel : 010-60846618-2816
         * enterprise_contact_address : 广州市番禺区大道北555号天安科技园创业中心
         * enterprise_license : https://toutiao.28.com/data/upload/article_img/1711/27/5a1bdb64d8b78.jpg
         * check_status : 1
         * check_comment :
         * check_time : 2017-11-27 17:31:31
         * add_date : 2017-11-27
         * add_time : 2017-11-27 17:38:14
         * sign : 立足古方 自创祖方 百余产品送健康
         * company_name : 健来福养生古方
         * cate_id : 338
         * is_recommended : 0
         * title : 健来福养生古方
         */

        private String id;
        private String uid;
        private String logo;
        private String logo_original;
        private String enterprise_name;
        private String enterprise_contacts;
        private String enterprise_contact_tel;
        private String enterprise_contact_address;
        private String enterprise_license;
        private String check_status;
        private String check_comment;
        private String check_time;
        private String add_date;
        private String add_time;
        private String sign;
        private String company_name;
        private String cate_id;
        private String is_recommended;
        private String title;

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

        public String getLogo() {
            return logo;
        }

        public void setLogo(String logo) {
            this.logo = logo;
        }

        public String getLogo_original() {
            return logo_original;
        }

        public void setLogo_original(String logo_original) {
            this.logo_original = logo_original;
        }

        public String getEnterprise_name() {
            return enterprise_name;
        }

        public void setEnterprise_name(String enterprise_name) {
            this.enterprise_name = enterprise_name;
        }

        public String getEnterprise_contacts() {
            return enterprise_contacts;
        }

        public void setEnterprise_contacts(String enterprise_contacts) {
            this.enterprise_contacts = enterprise_contacts;
        }

        public String getEnterprise_contact_tel() {
            return enterprise_contact_tel;
        }

        public void setEnterprise_contact_tel(String enterprise_contact_tel) {
            this.enterprise_contact_tel = enterprise_contact_tel;
        }

        public String getEnterprise_contact_address() {
            return enterprise_contact_address;
        }

        public void setEnterprise_contact_address(String enterprise_contact_address) {
            this.enterprise_contact_address = enterprise_contact_address;
        }

        public String getEnterprise_license() {
            return enterprise_license;
        }

        public void setEnterprise_license(String enterprise_license) {
            this.enterprise_license = enterprise_license;
        }

        public String getCheck_status() {
            return check_status;
        }

        public void setCheck_status(String check_status) {
            this.check_status = check_status;
        }

        public String getCheck_comment() {
            return check_comment;
        }

        public void setCheck_comment(String check_comment) {
            this.check_comment = check_comment;
        }

        public String getCheck_time() {
            return check_time;
        }

        public void setCheck_time(String check_time) {
            this.check_time = check_time;
        }

        public String getAdd_date() {
            return add_date;
        }

        public void setAdd_date(String add_date) {
            this.add_date = add_date;
        }

        public String getAdd_time() {
            return add_time;
        }

        public void setAdd_time(String add_time) {
            this.add_time = add_time;
        }

        public String getSign() {
            return sign;
        }

        public void setSign(String sign) {
            this.sign = sign;
        }

        public String getCompany_name() {
            return company_name;
        }

        public void setCompany_name(String company_name) {
            this.company_name = company_name;
        }

        public String getCate_id() {
            return cate_id;
        }

        public void setCate_id(String cate_id) {
            this.cate_id = cate_id;
        }

        public String getIs_recommended() {
            return is_recommended;
        }

        public void setIs_recommended(String is_recommended) {
            this.is_recommended = is_recommended;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }
}
