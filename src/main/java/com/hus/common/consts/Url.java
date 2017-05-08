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

    class Login{

        public static final String SHOW_LOGIN_PAGE = "";


        public static final String USER_LOGIN_URL = "user/login";
    }

    class Course{

        public static final String COURSE_LIST_URL = "course/list";

        public static final String COURSE_ADD_URL = "course/add";

        public static final String COURSE_UPDATE_URL = "course/update";

        public static final String COURSE_INFO_URL = "course/info/{id}";

        public static final String COURSE_DELETE_URL = "course/delete/{id}";

        public static final String COURSE_LIST_URL_FOR_STU = "course/stulist";


    }

    class Student{

        public static final String STUDENt_LIST_URL = "student/list";

        public static final String STUDENt_ADD_URL = "student/add";

        public static final String STUDENT_UPDATE_URL = "student/update";

        public static final String STUDENT_DELETE_URL = "student/delete/{id}";

        public static final String STUDENT_INFO_URL = "student/info/{id}";

        public static final String STUDENT_CHOOSED_COURSE = "student/choose/course";

        public static final String STUDENT_UNCHOOSED_COURSE = "student/unchoose/course";
    }
}
