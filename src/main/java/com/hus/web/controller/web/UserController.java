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


    // 教师
    @RequestMapping(value = Url.Teacher.TEACHER_LIST_URL, method = RequestMethod.GET)
    public ModelAndView teaherlist(HttpServletRequest request){
        return  userService.teacherList(request);
    }

    @RequestMapping(value = Url.Teacher.TEACHER_ADD_URL, method = RequestMethod.POST)
    public ModelAndView addTeacher(HttpServletRequest request, User user){
        return  userService.addTeacher(request, user);
    }

    @RequestMapping(value = Url.Teacher.TEACHER_UPDATE_URL, method = RequestMethod.POST)
    @ResponseBody
    public Object updateTeacher(User user){
        return  userService.updateTeacher(user);
    }
    @RequestMapping(value = Url.Teacher.TEACHER_DELETE_URL, method = RequestMethod.GET)
    public ModelAndView deleteTeacher(@PathVariable Integer id){
        return  userService.delateTeacher(id);
    }
    @RequestMapping(value = Url.Teacher.TEACHER_INFO_URL, method = RequestMethod.GET)
    @ResponseBody
    public Map<String, String> getTeacherInfo(@PathVariable Integer id){
        return  userService.getTeacherInfo(id);
    }

}
