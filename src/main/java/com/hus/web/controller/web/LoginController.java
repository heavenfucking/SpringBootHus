package com.hus.web.controller.web;

import com.hus.common.consts.Url;
import com.hus.common.consts.View;
import com.hus.web.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * 登录控制器
 * Created by zhh on 2017/5/4.
 */
@Controller
public class LoginController {

    @Autowired
    private LoginService loginService;

    /**
     * 显示登录界面
     * @return
     */
    @RequestMapping(value = Url.Login.SHOW_LOGIN_PAGE, method = RequestMethod.GET)
    public ModelAndView login(HttpServletRequest request) {
        return new ModelAndView(View.Index.LOGIN_PAGE);
    }

    @RequestMapping(value = Url.Login.USER_LOGIN_URL, method = RequestMethod.POST)
    public ModelAndView userLogin(HttpServletRequest request, String sno, String password){
        return loginService.userLogin(request, sno, password);
    }
}
