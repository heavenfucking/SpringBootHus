package com.hus.web.entity;

/**
 * 用户信息实体
 * Created by zhh on 2017/5/4.
 */
public class User {

    /**
     * 用户唯一标识
     */
    private Integer id;

    /**
     * 用户角色 1 学生 2 管理员
     */
    private Integer type;

    /**
     * 用户名
     */
    private String sno;

    /**
     * 姓名
     */
    private String name;

    /**
     * 系别
     */
    private Integer departmentId;

    /**
     * 微信用户唯一标识
     */
    private String openId;

    private String password;

    public User() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }


    public String getPassword() {
        return password;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
