package com.hus.web.entity;

/**
 * Created by zhh on 2017/5/5.
 */
public class Course {

    private Integer id;

    private String sno;

    private Integer teacherId;

    private Integer studyScore;

    private Integer studySlot;

    private String address;

    private Integer status;

    public Course() {
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

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    public Integer getStudyScore() {
        return studyScore;
    }

    public void setStudyScore(Integer studyScore) {
        this.studyScore = studyScore;
    }

    public Integer getStudySlot() {
        return studySlot;
    }

    public void setStudySlot(Integer studySlot) {
        this.studySlot = studySlot;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
