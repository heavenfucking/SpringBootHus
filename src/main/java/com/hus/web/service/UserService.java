package com.hus.web.service;

import com.hus.web.entity.User;
import com.hus.web.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by zhh on 2017/3/3.
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;
    public Integer save(User u){
       return userMapper.insert(u);
    }
}
