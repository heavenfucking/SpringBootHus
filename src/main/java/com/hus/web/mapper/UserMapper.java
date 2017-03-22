package com.hus.web.mapper;

import com.hus.web.entity.User;
import org.springframework.stereotype.Repository;

/**
 * Created by zhh on 2017/3/3.
 */

public interface UserMapper {
    Integer insert(User u);
}
