package com.zlt.pojo;

import lombok.Data;

import java.util.Date;

public class EduClass {
    private String classId;
    private String className;
    private Integer classNumber;
    private Date createTime;
    private Date updateTime;
    private String reverse1;
    private String reverse2;

    public EduClass() {
    }

    public EduClass(String classId, String className, Integer classNumber, Date createTime, Date updateTime, String reverse1, String reverse2) {
        this.classId = classId;
        this.className = className;
        this.classNumber = classNumber;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.reverse1 = reverse1;
        this.reverse2 = reverse2;
    }

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Integer getClassNumber() {
        return classNumber;
    }

    public void setClassNumber(Integer classNumber) {
        this.classNumber = classNumber;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getReverse1() {
        return reverse1;
    }

    public void setReverse1(String reverse1) {
        this.reverse1 = reverse1;
    }

    public String getReverse2() {
        return reverse2;
    }

    public void setReverse2(String reverse2) {
        this.reverse2 = reverse2;
    }
}
