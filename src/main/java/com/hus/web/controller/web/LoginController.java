package com.hus.web.controller.web;

import com.hus.common.consts.App;
import com.hus.common.consts.Url;
import com.hus.common.consts.View;
import com.hus.web.entity.User;
import com.hus.web.service.LoginService;
import com.hus.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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

    /**
     * PC端登录逻辑
     * @param request
     * @param sno
     * @param password
     * @return
     */
    @RequestMapping(value = Url.Login.USER_LOGIN_URL, method = RequestMethod.POST)
    public ModelAndView userLogin(HttpServletRequest request, String sno, String password){
        return loginService.userLogin(request, sno, password);
    }

    /**
     * 微信端登录
     * @param request
     * @return
     */
    @RequestMapping(value = Url.Login.WECHAT_USER_LOGIN_URL, method = RequestMethod.GET)
    public ModelAndView wechatLogin(HttpServletRequest request) {
        return loginService.WechatuserLogin(request);
    }

    @RequestMapping(value = "wechat/enter", method = RequestMethod.GET)
    public void wechatenter(HttpServletResponse response) throws IOException {
        response.sendRedirect("https://open.weixin.qq.com/connect/oauth2/authorize" +
                "?appid=wxa4cc0a202b65477c&redirect_uri=http://17157bv023.51mypc.cn/hus/wechat/callback" +
                "&response_type=code&scope=snsapi_userinfo&state=123#wechat_redirect");
    }

}
