package com.hus.web.mapper;

import com.hus.web.entity.User;

import java.util.List;
import java.util.Map;

/**
 * Created by zhh on 2017/3/3.
 */

public interface UserMapper {

    Integer insert(User u);

    Integer update(User u);

    Integer delete(Integer id);

    User selectUserBySno(String sno);

    List<Map<String, String>> selectStudentInfo();

    Map<String, String> selectStudentInfoByPrimaryKey(Integer id);
}
