package com.hus.web.controller.web;

import com.hus.web.mapper.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zhh on 2017/3/3.
 */
@Controller
public class DemoController {

    @Autowired
    private DepartmentMapper departmentMapper;
    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String test()
    {

        return "mobile/index";
    }
}
