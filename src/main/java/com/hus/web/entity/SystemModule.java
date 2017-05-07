package com.hus.web.entity;

import java.util.List;

/**
 * Created by zhh on 2017/5/4.
 */
public class SystemModule {

    private Integer id;

    private Integer type;

    private String name;

    private String url;

    private Integer parentId;

    private List<SystemModule> childrenModule;

    public SystemModule() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public List<SystemModule> getChildrenModule() {
        return childrenModule;
    }

    public void setChildrenModule(List<SystemModule> childrenModule) {
        this.childrenModule = childrenModule;
    }
}
