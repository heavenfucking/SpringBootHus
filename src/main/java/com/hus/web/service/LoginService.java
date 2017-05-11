package com.hus.web.service;

import com.hus.common.consts.App;
import com.hus.common.consts.Url;
import com.hus.common.consts.View;
import com.hus.web.entity.SystemModule;
import com.hus.web.entity.User;
import com.hus.web.mapper.SystemModuleMapper;
import com.hus.web.mapper.UserMapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


/**
 * Created by zhh on 2017/5/4.
 */
@Service
public class LoginService {

    /** 日志记录对象 */
    private Logger logger = LoggerFactory.getLogger(LoginService.class);

    @Autowired
    private SystemModuleMapper systemModuleMapper;

    @Autowired
    private UserMapper userMapper;

    public ModelAndView userLogin(HttpServletRequest request, String sno, String password){

        User user = userMapper.selectUserBySno(sno);
        if(user==null){
            //用户不存在
            logger.error("用户不存在");
            return new ModelAndView(View.Index.LOGIN_PAGE);
        }
        if(!user.getPassword().equals(password)){
            //用户不存在
            logger.error("密码错误");
            return new ModelAndView(View.Index.LOGIN_PAGE);
        }
        String openId = (String) request.getSession().getAttribute(App.Session.WECHAT_USER_OPEN_ID);
        if(openId!=null){
            user.setOpenId(openId);
            userMapper.update(user);
        }
        request.getSession().setAttribute(App.Session.CURRENT_USER_OBJECT, user);
        List<SystemModule> list = systemModuleMapper.selectParentModuleByType(user.getType());
        list.stream().forEach((m)->{
            m.setChildrenModule(systemModuleMapper.selectChildModuleByParentId(m.getId()));
        });
        request.getSession().setAttribute(App.Session.SYSTEM_MENU_ALL, list);
        return new ModelAndView(View.Index.LOGIN_HOME_PAGE);
    }

    public ModelAndView WechatuserLogin(HttpServletRequest request){
        String openId = (String) request.getSession().getAttribute(App.Session.WECHAT_USER_OPEN_ID);
        User user = userMapper.selectUserByOpenId(openId);
        if(user==null){
            return new ModelAndView("redirect:/"+ Url.Login.SHOW_LOGIN_PAGE);
        }
        request.getSession().setAttribute(App.Session.CURRENT_USER_OBJECT, user);
        List<SystemModule> list = systemModuleMapper.selectParentModuleByType(user.getType());
        list.stream().forEach((m)->{
            m.setChildrenModule(systemModuleMapper.selectChildModuleByParentId(m.getId()));
        });
        request.getSession().setAttribute(App.Session.SYSTEM_MENU_ALL, list);
        return new ModelAndView(View.Index.WX_LOGIN_HOME_PAGE);
    }
}
