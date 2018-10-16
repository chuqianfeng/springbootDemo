package com.gt.utils;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Administrator on 2018/9/15.
 */

@Configuration
public class PropertiesUtil {


    private static String homeUrl;//本身项目地址

    private static String picUrl;//图片前缀

    public static String getHomeUrl() {
        return homeUrl;
    }
    @Value("${web.homeUrl}")
    public  void setHomeUrl(String homeUrl) {
        PropertiesUtil.homeUrl = homeUrl;
    }

    public static String getPicUrl() {
        return picUrl;
    }
    @Value("${web.picUrl}")
    public  void setPicUrl(String picUrl) {
        PropertiesUtil.picUrl = picUrl;
    }
}