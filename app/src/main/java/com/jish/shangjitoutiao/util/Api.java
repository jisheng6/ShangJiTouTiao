package com.jish.shangjitoutiao.util;

/**
 * 1.类的用途
 * 2.@authorDell
 * 3.@date2017/12/4 19:25
 */

public class Api {
    public static String PRIVATE_KEY="2074509615ee2557631024d80fd7a1a2";
    //true代表线上 false代表测试
    public static boolean isDebug=true;
    public static String testUrl="http://toutiao.28.com";
    public static String lineUrl="https://toutiao.28.com";
    public static String url=baseUrl();

    public static String baseUrl(){
        return isDebug==true?lineUrl:testUrl;
    }
}
