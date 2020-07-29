package com.zlt.pojo;

import java.util.Date;

public class EduTeacher {
    private Integer teacherId; //教师Id
    private String teacherPortrait; //教师头像
    private String teacherNickName; //教师昵称
    private String teacherMobile;   //教师手机号
    private String teacherEmail;    //教师邮箱
    private String teacherPassword; //教师密码
    private String teacherTno;  //教师工号
    private String teacherSchool;   //任职学校
    private Date createTime;  //注册时间
    private Date upDateTimel;   //更新时间
    private String reverse1;    //保留字段1
    private String reverse2;    //保留字段2

    public EduTeacher() {
    }

    public EduTeacher(Integer teacherId, String teacherPortrait, String teacherNickName, String teacherMobile, String teacherEmail, String teacherPassword, String teacherTno, String teacherSchool, Date createTime, Date upDateTimel, String reverse1, String reverse2) {
        this.teacherId = teacherId;
        this.teacherPortrait = teacherPortrait;
        this.teacherNickName = teacherNickName;
        this.teacherMobile = teacherMobile;
        this.teacherEmail = teacherEmail;
        this.teacherPassword = teacherPassword;
        this.teacherTno = teacherTno;
        this.teacherSchool = teacherSchool;
        this.createTime = createTime;
        this.upDateTimel = upDateTimel;
        this.reverse1 = reverse1;
        this.reverse2 = reverse2;
    }

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    public String getTeacherPortrait() {
        return teacherPortrait;
    }

    public void setTeacherPortrait(String teacherPortrait) {
        this.teacherPortrait = teacherPortrait;
    }

    public String getTeacherNickName() {
        return teacherNickName;
    }

    public void setTeacherNickName(String teacherNickName) {
        this.teacherNickName = teacherNickName;
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

    public Date getUpDateTimel() {
        return upDateTimel;
    }

    public void setUpDateTimel(Date upDateTimel) {
        this.upDateTimel = upDateTimel;
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
        return "eduTeacher{" +
                "teacherId=" + teacherId +
                ", teacherPortrait='" + teacherPortrait + '\'' +
                ", teacherNickName='" + teacherNickName + '\'' +
                ", teacherMobile='" + teacherMobile + '\'' +
                ", teacherEmail='" + teacherEmail + '\'' +
                ", teacherPassword='" + teacherPassword + '\'' +
                ", teacherTno='" + teacherTno + '\'' +
                ", teacherSchool='" + teacherSchool + '\'' +
                ", createTime=" + createTime +
                ", upDateTimel=" + upDateTimel +
                ", reverse1='" + reverse1 + '\'' +
                ", reverse2='" + reverse2 + '\'' +
                '}';
    }
}
