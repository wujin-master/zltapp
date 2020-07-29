package com.zlt.pojo;

import java.util.Date;

public class EduTeacher {
    private String teacherId;
    private String teacherPortrait;
    private String teacherNickname;
    private String teacherMobile;
    private String teacherEmail;
    private String teacherPassword;
    private String teacherTno;
    private String teacherSchool;
    private Date createTime;
    private Date updateTime;
    private String reserve1;
    private String reserve2;

    public EduTeacher() {
    }

    public EduTeacher(String teacherId, String teacherPortrait, String teacherNickname, String teacherMobile, String teacherEmail, String teacherPassword, String teacherTno, String teacherSchool, Date createTime, Date updateTime, String reserve1, String reserve2) {
        this.teacherId = teacherId;
        this.teacherPortrait = teacherPortrait;
        this.teacherNickname = teacherNickname;
        this.teacherMobile = teacherMobile;
        this.teacherEmail = teacherEmail;
        this.teacherPassword = teacherPassword;
        this.teacherTno = teacherTno;
        this.teacherSchool = teacherSchool;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.reserve1 = reserve1;
        this.reserve2 = reserve2;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public String getTeacherPortrait() {
        return teacherPortrait;
    }

    public void setTeacherPortrait(String teacherPortrait) {
        this.teacherPortrait = teacherPortrait;
    }

    public String getTeacherNickname() {
        return teacherNickname;
    }

    public void setTeacherNickname(String teacherNickname) {
        this.teacherNickname = teacherNickname;
    }

    public String getTeacherMobile() {
        return teacherMobile;
    }

    public void setTeacherMobile(String teacherMobile) {
        this.teacherMobile = teacherMobile;
    }

    public String getTeacherEmail() {
        return teacherEmail;
    }

    public void setTeacherEmail(String teacherEmail) {
        this.teacherEmail = teacherEmail;
    }

    public String getTeacherPassword() {
        return teacherPassword;
    }

    public void setTeacherPassword(String teacherPassword) {
        this.teacherPassword = teacherPassword;
    }

    public String getTeacherTno() {
        return teacherTno;
    }

    public void setTeacherTno(String teacherTno) {
        this.teacherTno = teacherTno;
    }

    public String getTeacherSchool() {
        return teacherSchool;
    }

    public void setTeacherSchool(String teacherSchool) {
        this.teacherSchool = teacherSchool;
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

    public String getReserve1() {
        return reserve1;
    }

    public void setReserve1(String reserve1) {
        this.reserve1 = reserve1;
    }

    public String getReserve2() {
        return reserve2;
    }

    public void setReserve2(String reserve2) {
        this.reserve2 = reserve2;
    }

    @Override
    public String toString() {
        return "EduTeacher{" +
                "teacherId='" + teacherId + '\'' +
                ", teacherPortrait='" + teacherPortrait + '\'' +
                ", teacherNickname='" + teacherNickname + '\'' +
                ", teacherMobile='" + teacherMobile + '\'' +
                ", teacherEmail='" + teacherEmail + '\'' +
                ", teacherPassword='" + teacherPassword + '\'' +
                ", teacherTno='" + teacherTno + '\'' +
                ", teacherSchool='" + teacherSchool + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", reserve1='" + reserve1 + '\'' +
                ", reserve2='" + reserve2 + '\'' +
                '}';
    }
}
