package com.jish.shangjitoutiao.retrofit;

import com.jish.shangjitoutiao.bean.CaiBean;
import com.jish.shangjitoutiao.bean.DongLoginBean;
import com.jish.shangjitoutiao.bean.SJ_classBean;
import com.jish.shangjitoutiao.bean.ShangJi_SouSuoBean;
import com.jish.shangjitoutiao.bean.ShouYe_FenleiBean;
import com.jish.shangjitoutiao.bean.JiuGongBean;
import com.jish.shangjitoutiao.bean.LoginBean;
import com.jish.shangjitoutiao.bean.ShangJiBannerBean;
import com.jish.shangjitoutiao.bean.ShouYe_SouSuoBean;
import com.jish.shangjitoutiao.bean.ShouYe_XinXiBean;
import com.jish.shangjitoutiao.bean.ShouYe_XiangQingBean;
import com.jish.shangjitoutiao.bean.TuiJianBean;
import com.jish.shangjitoutiao.bean.VideoBean;
import com.jish.shangjitoutiao.bean.YanZma_loginBean;
import com.jish.shangjitoutiao.bean.ZiXunBean;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by Adminjs on 2018/1/29.
 */

public interface APIn {
    //首页列表
    @FormUrlEncoded
    @POST("/App/Index/article_list")
    Observable<ShouYe_XinXiBean> postShouYe(@Field("page") String page, @Field("sign") String sign, @Field("cate_id") String id, @Field("timestamp") String timestamp, @Field("token") String token);
   //首页分类
    @FormUrlEncoded
    @POST("/App/Index/article_category")
    Observable<ShouYe_FenleiBean> postFenLei(@Field("sign") String sign, @Field("timestamp") String timestamp, @Field("token") String token);
    //首页获取文章详情
    @FormUrlEncoded
    @POST("/App/Index/article_view")
    Observable<ShouYe_XiangQingBean> postWenZh(@Field("id") String id,@Field("sign") String sign, @Field("timestamp") String timestamp);
    //首页文章搜索
    @FormUrlEncoded
    @POST("/App/Index/article_search")
    Observable<ShouYe_SouSuoBean> postSouSuo(@Field("page") String page,@Field("title") String title, @Field("sign") String sign, @Field("timestamp") String timestamp);
    //视频列表
    @FormUrlEncoded
    @POST("/App/Video/video_list")
    Observable<VideoBean> postVideo(@Field("page") String page, @Field("sign") String sign, @Field("cate_id") String id, @Field("timestamp") String timestamp, @Field("token") String token);
    //商机轮播图
    @FormUrlEncoded
    @POST("/App/BusinessOpportunity/banner_list")
    Observable<ShangJiBannerBean> postBanner(@Field("sign") String sign, @Field("timestamp") String timestamp);
   //商机列表搜索
   @FormUrlEncoded
   @POST("/App/Business/business_search")
   Observable<ShangJi_SouSuoBean> postSJSouSuo(@Field("page") String page, @Field("title") String title,@Field("cate_id") String id, @Field("sign") String sign, @Field("timestamp") String timestamp);
    //账号密码登录
    @FormUrlEncoded
    @POST("/App/Public/login")
    Observable<LoginBean> postLogin(@Field("mobile") String mobile,@Field("password") String password,@Field("sign") String sign, @Field("timestamp") String timestamp,@Field("type") String type);
    //动态登录
    @FormUrlEncoded
    @POST("/App/Public/login_sms")
    Observable<DongLoginBean> postdong_login(@Field("mobile") String mobile,@Field("smscode") String smscode, @Field("sign") String sign, @Field("timestamp") String timestamp,@Field("Token") String token,@Field("type") String type);
    //获取短信
    @FormUrlEncoded
    @POST("/App/Public/send_sms_code")
    Observable<YanZma_loginBean> postDuanXin_login(@Field("mobile") String mobile, @Field("sign") String sign, @Field("timestamp") String timestamp, @Field("type") String type);
    //九宫格
    @FormUrlEncoded
    @POST("/App/BusinessOpportunity/category")
    Observable<JiuGongBean> postJiuGong(@Field("sign") String sign, @Field("timestamp") String timestamp);
   //资讯
   @FormUrlEncoded
   @POST("/App/BusinessOpportunity/news_list")
   Observable<ZiXunBean> postZiXun(@Field("sign") String sign, @Field("timestamp") String timestamp);
    //推荐项目
    @FormUrlEncoded
    @POST("/App/Business/recommended_list")
    Observable<TuiJianBean> postTuiJian(@Field("sign") String sign, @Field("timestamp") String timestamp);
    //猜你喜欢
    @FormUrlEncoded
    @POST("/App/Business/business_list")
    Observable<CaiBean> postCai(@Field("sign") String sign, @Field("timestamp") String timestamp);
    //九宫分类
    @FormUrlEncoded
    @POST("/App/Business/business_list")
    Observable<SJ_classBean> postSJClass(@Field("page") String page,@Field("cate_id") String id,@Field("sign") String sign, @Field("timestamp") String timestamp);
}
