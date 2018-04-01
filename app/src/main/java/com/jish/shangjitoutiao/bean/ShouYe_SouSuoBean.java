package com.jish.shangjitoutiao.bean;

import java.util.List;

/**
 * Created by Adminjs on 2018/2/5.
 */

public class ShouYe_SouSuoBean {

    /**
     * status : 1
     * msg :
     * data : [{"id":"6003","title":"《习近平谈治国理政》：这本书，全世界都在学习","view":"106","reply":"0","cate_pid":"309","cdate":"2018-01-30","showtime":"1517281865","is_top":"0","ArticleImg":[{"id":"15339","article_id":"6003","cdatetime":"2018-01-30 11:10:15","cdate":"2018-01-30","path":"https://toutiao.28.com/data/upload/article_img/1801/30/aceb1f64c9b93fc00a66c03dbc99ea70.jpg_150x150.jpg"}],"cate_name":"名人"}]
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
         * id : 6003
         * title : 《习近平谈治国理政》：这本书，全世界都在学习
         * view : 106
         * reply : 0
         * cate_pid : 309
         * cdate : 2018-01-30
         * showtime : 1517281865
         * is_top : 0
         * ArticleImg : [{"id":"15339","article_id":"6003","cdatetime":"2018-01-30 11:10:15","cdate":"2018-01-30","path":"https://toutiao.28.com/data/upload/article_img/1801/30/aceb1f64c9b93fc00a66c03dbc99ea70.jpg_150x150.jpg"}]
         * cate_name : 名人
         */

        private String id;
        private String title;
        private String view;
        private String reply;
        private String cate_pid;
        private String cdate;
        private String showtime;
        private String is_top;
        private String cate_name;
        private List<ArticleImgBean> ArticleImg;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getView() {
            return view;
        }

        public void setView(String view) {
            this.view = view;
        }

        public String getReply() {
            return reply;
        }

        public void setReply(String reply) {
            this.reply = reply;
        }

        public String getCate_pid() {
            return cate_pid;
        }

        public void setCate_pid(String cate_pid) {
            this.cate_pid = cate_pid;
        }

        public String getCdate() {
            return cdate;
        }

        public void setCdate(String cdate) {
            this.cdate = cdate;
        }

        public String getShowtime() {
            return showtime;
        }

        public void setShowtime(String showtime) {
            this.showtime = showtime;
        }

        public String getIs_top() {
            return is_top;
        }

        public void setIs_top(String is_top) {
            this.is_top = is_top;
        }

        public String getCate_name() {
            return cate_name;
        }

        public void setCate_name(String cate_name) {
            this.cate_name = cate_name;
        }

        public List<ArticleImgBean> getArticleImg() {
            return ArticleImg;
        }

        public void setArticleImg(List<ArticleImgBean> ArticleImg) {
            this.ArticleImg = ArticleImg;
        }

        public static class ArticleImgBean {
            /**
             * id : 15339
             * article_id : 6003
             * cdatetime : 2018-01-30 11:10:15
             * cdate : 2018-01-30
             * path : https://toutiao.28.com/data/upload/article_img/1801/30/aceb1f64c9b93fc00a66c03dbc99ea70.jpg_150x150.jpg
             */

            private String id;
            private String article_id;
            private String cdatetime;
            private String cdate;
            private String path;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getArticle_id() {
                return article_id;
            }

            public void setArticle_id(String article_id) {
                this.article_id = article_id;
            }

            public String getCdatetime() {
                return cdatetime;
            }

            public void setCdatetime(String cdatetime) {
                this.cdatetime = cdatetime;
            }

            public String getCdate() {
                return cdate;
            }

            public void setCdate(String cdate) {
                this.cdate = cdate;
            }

            public String getPath() {
                return path;
            }

            public void setPath(String path) {
                this.path = path;
            }
        }
    }
}
