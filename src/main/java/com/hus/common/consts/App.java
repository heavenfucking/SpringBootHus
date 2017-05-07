package com.hus.common.consts;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by zhu on 2017/3/15.
 */
public interface App {

    @Component
    class Wechat {
        /** 微信公众号唯一标识*/
        public static String APPID;
        /** 微信公众号的appsecret */
        public static String APPSECRET;

        @Value("${spring.wechat.appID}")
        public void setAPPID(String APPID) {
            Wechat.APPID = APPID;
        }
        @Value("${spring.wechat.appsecret}")
        public  void setAPPSECRET(String APPSECRET) {
            Wechat.APPSECRET = APPSECRET;
        }
    }

    class Session {
        /** 当前用户的ACCESS_TOKEN */
        public static final String WECHAT_USER_ACCESS_TOKEN = "session_key_wechat_user_access_token";
        /** 当前用户的openid */
        public static final String WECHAT_USER_OPEN_ID = "session_key_user_open_id";
        /** 当前用户对象 */
        public static final String CURRENT_USER_OBJECT = "session_key_current_user_object";
        /** 系统菜单 */
        public static final String SYSTEM_MENU_ALL = "session_key_system_menu_all";
    }

}
