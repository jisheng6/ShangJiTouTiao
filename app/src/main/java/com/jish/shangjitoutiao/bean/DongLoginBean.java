package com.jish.shangjitoutiao.bean;

/**
 * Created by Adminjs on 2018/2/9.
 */

public class DongLoginBean {

    /**
     * status : 1
     * msg : 登录成功！
     * data : {"url":"/App/Members/index.html","yunxin":{"token":"702fc591d39ba1ef404fa1ce4e64dc16","account":"149"},"user":{"uid":"149","nickname":"t3308mmdl","realname":"","phone":"13120253308","age":"0","sex":"1","sex_cn":"男","signature":"","residence":"","fans":"0","follow":"0","favorite":"0","publish":"0","share":"0","cate_pid":"0","avatar":"/data/upload/resource/no_photo_male.png","utype":"2","username":"t3308mmdl","is_enterprise_auth_user":"0","unclaimed_boc":"1","inspect_count":"0"}}
     * dialog : 8asopok4mfeu8crd40ar11ise6
     */

    private int status;
    private String msg;
    private DataBean data;
    private String dialog;

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

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getDialog() {
        return dialog;
    }

    public void setDialog(String dialog) {
        this.dialog = dialog;
    }

    public static class DataBean {
        /**
         * url : /App/Members/index.html
         * yunxin : {"token":"702fc591d39ba1ef404fa1ce4e64dc16","account":"149"}
         * user : {"uid":"149","nickname":"t3308mmdl","realname":"","phone":"13120253308","age":"0","sex":"1","sex_cn":"男","signature":"","residence":"","fans":"0","follow":"0","favorite":"0","publish":"0","share":"0","cate_pid":"0","avatar":"/data/upload/resource/no_photo_male.png","utype":"2","username":"t3308mmdl","is_enterprise_auth_user":"0","unclaimed_boc":"1","inspect_count":"0"}
         */

        private String url;
        private YunxinBean yunxin;
        private UserBean user;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public YunxinBean getYunxin() {
            return yunxin;
        }

        public void setYunxin(YunxinBean yunxin) {
            this.yunxin = yunxin;
        }

        public UserBean getUser() {
            return user;
        }

        public void setUser(UserBean user) {
            this.user = user;
        }

        public static class YunxinBean {
            /**
             * token : 702fc591d39ba1ef404fa1ce4e64dc16
             * account : 149
             */

            private String token;
            private String account;

            public String getToken() {
                return token;
            }

            public void setToken(String token) {
                this.token = token;
            }

            public String getAccount() {
                return account;
            }

            public void setAccount(String account) {
                this.account = account;
            }
        }

        public static class UserBean {
            /**
             * uid : 149
             * nickname : t3308mmdl
             * realname :
             * phone : 13120253308
             * age : 0
             * sex : 1
             * sex_cn : 男
             * signature :
             * residence :
             * fans : 0
             * follow : 0
             * favorite : 0
             * publish : 0
             * share : 0
             * cate_pid : 0
             * avatar : /data/upload/resource/no_photo_male.png
             * utype : 2
             * username : t3308mmdl
             * is_enterprise_auth_user : 0
             * unclaimed_boc : 1
             * inspect_count : 0
             */

            private String uid;
            private String nickname;
            private String realname;
            private String phone;
            private String age;
            private String sex;
            private String sex_cn;
            private String signature;
            private String residence;
            private String fans;
            private String follow;
            private String favorite;
            private String publish;
            private String share;
            private String cate_pid;
            private String avatar;
            private String utype;
            private String username;
            private String is_enterprise_auth_user;
            private String unclaimed_boc;
            private String inspect_count;

            public String getUid() {
                return uid;
            }

            public void setUid(String uid) {
                this.uid = uid;
            }

            public String getNickname() {
                return nickname;
            }

            public void setNickname(String nickname) {
                this.nickname = nickname;
            }

            public String getRealname() {
                return realname;
            }

            public void setRealname(String realname) {
                this.realname = realname;
            }

            public String getPhone() {
                return phone;
            }

            public void setPhone(String phone) {
                this.phone = phone;
            }

            public String getAge() {
                return age;
            }

            public void setAge(String age) {
                this.age = age;
            }

            public String getSex() {
                return sex;
            }

            public void setSex(String sex) {
                this.sex = sex;
            }

            public String getSex_cn() {
                return sex_cn;
            }

            public void setSex_cn(String sex_cn) {
                this.sex_cn = sex_cn;
            }

            public String getSignature() {
                return signature;
            }

            public void setSignature(String signature) {
                this.signature = signature;
            }

            public String getResidence() {
                return residence;
            }

            public void setResidence(String residence) {
                this.residence = residence;
            }

            public String getFans() {
                return fans;
            }

            public void setFans(String fans) {
                this.fans = fans;
            }

            public String getFollow() {
                return follow;
            }

            public void setFollow(String follow) {
                this.follow = follow;
            }

            public String getFavorite() {
                return favorite;
            }

            public void setFavorite(String favorite) {
                this.favorite = favorite;
            }

            public String getPublish() {
                return publish;
            }

            public void setPublish(String publish) {
                this.publish = publish;
            }

            public String getShare() {
                return share;
            }

            public void setShare(String share) {
                this.share = share;
            }

            public String getCate_pid() {
                return cate_pid;
            }

            public void setCate_pid(String cate_pid) {
                this.cate_pid = cate_pid;
            }

            public String getAvatar() {
                return avatar;
            }

            public void setAvatar(String avatar) {
                this.avatar = avatar;
            }

            public String getUtype() {
                return utype;
            }

            public void setUtype(String utype) {
                this.utype = utype;
            }

            public String getUsername() {
                return username;
            }

            public void setUsername(String username) {
                this.username = username;
            }

            public String getIs_enterprise_auth_user() {
                return is_enterprise_auth_user;
            }

            public void setIs_enterprise_auth_user(String is_enterprise_auth_user) {
                this.is_enterprise_auth_user = is_enterprise_auth_user;
            }

            public String getUnclaimed_boc() {
                return unclaimed_boc;
            }

            public void setUnclaimed_boc(String unclaimed_boc) {
                this.unclaimed_boc = unclaimed_boc;
            }

            public String getInspect_count() {
                return inspect_count;
            }

            public void setInspect_count(String inspect_count) {
                this.inspect_count = inspect_count;
            }
        }
    }
}
