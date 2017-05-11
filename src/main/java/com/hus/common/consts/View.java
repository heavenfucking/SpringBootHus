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

        /** WX　登陆主页 */
        public static final String WX_LOGIN_HOME_PAGE = "mobile/index";


        /**登录页面 **/
        public static final String LOGIN_PAGE = "login/index";
    }

    class Course{

        /** 课程课表 */
        public static final String COURSE_LIST_VIEW = "course/index";

        /** 管理员看到的课程列表 */
        public static final String ADMIN_COURSE_LIST_VIEW = "course/admin_index";


    }

    class Student{

        public static final String STUDENt_LIST_VIEW = "student/index";

        /** 学生选课时看到的课程列表 */
        public static final String COURSE_LIST_VIEW = "student/choosed_course";

        /** 微信端 学生选课时看到的课程列表 */
        public static final String COURSE_LIST_VIEW2 = "mobile/student_choosed_page";
    }

    class Teacher{

        public static final String TEACHER_LIST_VIEW = "teacher/index";

    }

    class Error {
        public static final String ERROR_PAGE_VIEW = "teacher/index";
    }


}
