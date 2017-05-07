package com.hus.web.service;

import com.hus.common.consts.Url;
import com.hus.common.consts.View;
import com.hus.web.entity.User;
import com.hus.web.mapper.DepartmentMapper;
import com.hus.web.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by zhh on 2017/5/5.
 */
@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private DepartmentMapper departmentMapper;

    public ModelAndView studentList(HttpServletRequest request){
        request.setAttribute("student_lists", userMapper.selectStudentInfo());
        request.setAttribute("department_lists", departmentMapper.selectIdAndDP());
        return new ModelAndView(View.Student.STUDENt_LIST_VIEW);
    }

    public ModelAndView addStudent(HttpServletRequest request, User user){
        userMapper.insert(user);
        return new ModelAndView("redirect:/"+ Url.Student.STUDENt_LIST_URL);
    }

    public Map<String, String> getStudentInfo(Integer id){
        return userMapper.selectStudentInfoByPrimaryKey(id);
    }

    public Integer updateStudent(User user){
        return  userMapper.update(user);
    }

    public ModelAndView delateStudent(Integer id){
        userMapper.delete(id);
        return new ModelAndView("redirect:/"+ Url.Student.STUDENt_LIST_URL);
    }
}
