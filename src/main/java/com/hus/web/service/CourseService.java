package com.hus.web.service;

import com.hus.common.consts.App;
import com.hus.common.consts.Url;
import com.hus.common.consts.View;
import com.hus.web.entity.Course;
import com.hus.web.mapper.CourseMapper;
import com.hus.web.mapper.UserMapper;
import org.springframework.beans.factory.NamedBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by zhh on 2017/5/5.
 */
@Service
public class CourseService {

    @Autowired
    private CourseMapper courseMapper;

    @Autowired
    private UserMapper userMapper;

    public ModelAndView list(HttpServletRequest request, Integer teacherId){
        request.setAttribute("course_lists", courseMapper.selectByteacherId(teacherId));
        return new ModelAndView(View.Course.COURSE_LIST_VIEW);
    }


    public ModelAndView studentlist(HttpServletRequest request, Integer studentId){
        request.setAttribute("unchoosed_course_lists", courseMapper.selectAllStudentUnChoosed(studentId));
        request.setAttribute("choosed_course_lists", courseMapper.selectAllStudentChoosed(studentId));
        return new ModelAndView(View.Student.COURSE_LIST_VIEW);
    }

    public ModelAndView addCourse(Course course){
        course.setSno(courseMapper.generateCourseSno());
        courseMapper.insert(course);
        return new ModelAndView("redirect:/"+ Url.Course.COURSE_LIST_URL);
    }

    public Integer updateCourse(Course course){
        return courseMapper.update(course);
    }

    public Course getCourseInfoById(Integer id){
        return courseMapper.selectByPrimaryKey(id);
    }

    public ModelAndView deleteCourseById(Integer id){
        courseMapper.delete(id);
        return new ModelAndView("redirect:/"+ Url.Course.COURSE_LIST_URL);
    }

    @Transactional
    public ModelAndView studentChoosedCourse(Integer studentId, Integer courseId){
        courseMapper.addChoosedQuota(1, courseId);
        courseMapper.studentChoosedCourse(studentId, courseId);
        return new ModelAndView("redirect:/"+Url.Course.COURSE_LIST_URL_FOR_STU);
    }
    @Transactional
    public ModelAndView studentUnChoosedCourse(Integer scId, Integer courseId){
        courseMapper.addChoosedQuota(-1, courseId);
        courseMapper.deleteStudentCourseByStudentIdAndCourseId(scId, courseId);
        return new ModelAndView("redirect:/"+Url.Course.COURSE_LIST_URL_FOR_STU);
    }

}
