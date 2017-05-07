package com.hus.web.controller.web;

import com.hus.common.consts.Url;
import com.hus.web.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by zhh on 2017/5/5.
 */
@Controller
public class CourseController {

    @Autowired
    private CourseService courseService;
    @RequestMapping(value = Url.Course.COURSE_LIST_URL, method = RequestMethod.GET)
    public ModelAndView list(HttpServletRequest request){
        return courseService.list(request);
    }
}
