package com.hus.web.mapper;

import com.hus.common.consts.Url;

import java.util.List;
import java.util.Map;

/**
 * Created by zhh on 2017/5/5.
 */
public interface CourseMapper {
    List<Map<String, String>> selectAll();
}
