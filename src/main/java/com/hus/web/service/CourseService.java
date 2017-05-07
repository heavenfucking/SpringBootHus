package com.hus.web.service;

import com.hus.common.consts.App;
import com.hus.common.consts.View;
import com.hus.web.mapper.CourseMapper;
import org.springframework.beans.factory.NamedBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by zhh on 2017/5/5.
 */
@Service
public class CourseService {

    @Autowired
    private CourseMapper courseMapper;

    public ModelAndView list(HttpServletRequest request){
        request.setAttribute("course_lists", courseMapper.selectAll());
        return new ModelAndView(View.Course.COURSE_LIST_VIEW);
    }
}
