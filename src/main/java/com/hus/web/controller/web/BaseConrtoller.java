package com.hus.web.controller.web;

import com.hus.common.consts.App;
import com.hus.web.entity.User;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by zhh on 2017/5/8.
 */
public class BaseConrtoller {

    public Integer getUserId(HttpServletRequest request){
        User  user = (User) request.getSession().getAttribute(App.Session.CURRENT_USER_OBJECT);
        if(user==null){
          return -1;
        }
        return user.getId();
    }
}
