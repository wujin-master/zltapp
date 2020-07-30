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
    private String reverse1;
    private String reverse2;

    public EduTeacher() {
    }

    public EduTeacher(String teacherId, String teacherPortrait, String teacherNickname, String teacherMobile, String teacherEmail, String teacherPassword, String teacherTno, String teacherSchool, Date createTime, Date updateTime, String reverse1, String reverse2) {
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
        this.reverse1 = reverse1;
        this.reverse2 = reverse2;
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
                ", reserve1='" + reverse1 + '\'' +
                ", reserve2='" + reverse2 + '\'' +
                '}';
    }
}
