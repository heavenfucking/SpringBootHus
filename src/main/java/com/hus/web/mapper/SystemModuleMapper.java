package com.hus.web.mapper;

import com.hus.web.entity.SystemModule;

import java.util.List;


/**
 * Created by zhh on 2017/5/4.
 */
public interface SystemModuleMapper {


    List<SystemModule> selectParentModuleByType(Integer type);

    List<SystemModule> selectChildModuleByParentId(Integer parentId);

}
