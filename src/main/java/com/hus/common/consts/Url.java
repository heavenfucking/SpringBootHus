package com.hus.common.consts;

public interface Url {

	/** 微信接口 */
    class Wechat {
        /** 微信开发者接口 */
        public static final String CORE_SERVICE = "coreService";
        /** 微信授权回调接口 */
        public static final String CALL_BACK = "wechat/callback";
        /** 获取用户授权access_token的url */
        public static final String AUTH_ACCESS_TOKEN_URL = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=%s&secret=%s&code=%s&grant_type=authorization_code";
    }
}
