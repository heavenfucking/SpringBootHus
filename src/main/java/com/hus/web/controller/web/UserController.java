package com.hus.web.controller.web;

import com.hus.common.consts.Url;
import com.hus.web.entity.User;
import com.hus.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by zhh on 2017/5/5.
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;
    @RequestMapping(value = Url.Student.STUDENt_LIST_URL, method = RequestMethod.GET)
    public ModelAndView studentlist(HttpServletRequest request){
         return  userService.studentList(request);
    }

    @RequestMapping(value = Url.Student.STUDENt_ADD_URL, method = RequestMethod.POST)
    public ModelAndView addStudent(HttpServletRequest request, User user){
        return  userService.addStudent(request, user);
    }


    @RequestMapping(value = Url.Student.STUDENT_INFO_URL, method = RequestMethod.GET)
    @ResponseBody
    public Map<String, String> getStudentInfo(@PathVariable Integer id){
        return  userService.getStudentInfo(id);
    }

    @RequestMapping(value = Url.Student.STUDENT_UPDATE_URL, method = RequestMethod.POST)
    @ResponseBody
    public Object updateStudent(User user){
        return  userService.updateStudent(user);
    }

    @RequestMapping(value = Url.Student.STUDENT_DELETE_URL, method = RequestMethod.GET)
    public ModelAndView deleteStudent(@PathVariable Integer id){
        return  userService.delateStudent(id);
    }

}
