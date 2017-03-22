package com.hus.web.controller.web;

import com.hus.common.consts.App;
import com.hus.common.consts.Url;
import com.hus.web.entity.User;
import com.hus.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by zhh on 2017/3/3.
 */
@Controller
public class DemoController {


    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public Object test()
    {
        //String AuthUrl =App.Wechat.APPID+App.Wechat.APPSECRET;
        return "index";
    }
}
