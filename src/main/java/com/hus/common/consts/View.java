package com.hus.common.consts;

/**
 * Created by zhh on 2017/5/4.
 */
public interface View {

    /**
     * 首页
     */
    class Index{

        /** 登陆主页 */
        public static final String LOGIN_HOME_PAGE = "home/index";

        /**登录页面 **/
        public static final String LOGIN_PAGE = "login/index";
    }

    class Course{

        /** 课程课表 */
        public static final String COURSE_LIST_VIEW = "course/index";


    }

    class Student{

        public static final String STUDENt_LIST_VIEW = "student/index";

        /** 学生选课时看到的课程列表 */
        public static final String COURSE_LIST_VIEW = "student/choosed_course";
    }
}
