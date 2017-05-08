package com.hus.web.controller.web;

import com.hus.common.consts.Url;
import com.hus.web.entity.Course;
import com.hus.web.entity.User;
import com.hus.web.mapper.CourseMapper;
import com.hus.web.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by zhh on 2017/5/5.
 */
@Controller
public class CourseController extends BaseConrtoller{

    @Autowired
    private CourseService courseService;

    /**
     * 显示教师自己创建的课程列表
     * @param request
     * @return
     */
    @RequestMapping(value = Url.Course.COURSE_LIST_URL, method = RequestMethod.GET)
    public ModelAndView list(HttpServletRequest request){
        return courseService.list(request, getUserId(request));
    }

    /**
     * 显示学生选课时的看到的课程列表
     * @param request
     * @return
     */
    @RequestMapping(value = Url.Course.COURSE_LIST_URL_FOR_STU, method = RequestMethod.GET)
    public ModelAndView studentlist(HttpServletRequest request){
        return courseService.studentlist(request, getUserId(request));
    }

    /**
     * 添加课程信息
     * @param request
     * @param course
     * @return
     */
    @RequestMapping(value = Url.Course.COURSE_ADD_URL, method = RequestMethod.POST)
    public ModelAndView addCourse(HttpServletRequest request, Course course){
        course.setTeacherId(getUserId(request));
        return courseService.addCourse(course);
    }

    /**
     * 更新课程信息
     * @param course
     * @return
     */
    @RequestMapping(value = Url.Course.COURSE_UPDATE_URL, method = RequestMethod.POST)
    @ResponseBody
    public Object updateCourse(Course course){
        return  courseService.updateCourse(course);
    }

    /**
     * 根据主键获取课程信息
     * @param id
     * @return
     */
    @RequestMapping(value = Url.Course.COURSE_INFO_URL, method = RequestMethod.GET)
    @ResponseBody
    public Object getCourseInfoById(@PathVariable Integer id){
        return  courseService.getCourseInfoById(id);
    }

    /**
     * 根据主键删除课程信息
     * @param id
     * @return
     */
    @RequestMapping(value = Url.Course.COURSE_DELETE_URL, method = RequestMethod.GET)
    public ModelAndView deleteCourseById(@PathVariable Integer id){
        return  courseService.deleteCourseById(id);
    }

    /**
     * 学生选课
     * @param request
     * @param id
     * @return
     */
    @RequestMapping(value = Url.Student.STUDENT_CHOOSED_COURSE, method = RequestMethod.GET)
    public ModelAndView studentChoosedCourse(HttpServletRequest request, Integer id){
        return courseService.studentChoosedCourse(getUserId(request), id);
    }

    /**
     * 学生退选
     * @param scId
     * @param id
     * @return
     */
    @RequestMapping(value = Url.Student.STUDENT_UNCHOOSED_COURSE, method = RequestMethod.GET)
    public ModelAndView studentUnChoosedCourse(HttpServletRequest request, Integer id){
        return courseService.studentUnChoosedCourse(getUserId(request), id);
    }
}
