package com.zlt.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class EduUser {
    private String userId;
    private String userPortrait;
    private String userNickname;
    private String userMobile;
    private String userEmail;
    private String userPassword;
    private String userSchool;
    private String userSno;
    private Date createTime;
    private String classId;
    private Date updateTime;
    private String reverse1;
    private String reverse2;

    public EduUser() {
    }

    public EduUser(String userId, String userPortrait, String userNickname, String userMobile, String userEmail, String userPassword, String userSchool, String userSno, Date createTime, String classId, Date updateTime, String reverse1, String reverse2) {
        this.userId = userId;
        this.userPortrait = userPortrait;
        this.userNickname = userNickname;
        this.userMobile = userMobile;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.userSchool = userSchool;
        this.userSno = userSno;
        this.createTime = createTime;
        this.classId = classId;
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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserPortrait() {
        return userPortrait;
    }

    public void setUserPortrait(String userPortrait) {
        this.userPortrait = userPortrait;
    }

    public String getUserNickname() {
        return userNickname;
    }

    public void setUserNickname(String userNickname) {
        this.userNickname = userNickname;
    }

    public String getUserMobile() {
        return userMobile;
    }

    public void setUserMobile(String userMobile) {
        this.userMobile = userMobile;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserSchool() {
        return userSchool;
    }

    public void setUserSchool(String userSchool) {
        this.userSchool = userSchool;
    }

    public String getUserSno() {
        return userSno;
    }

    public void setUserSno(String userSno) {
        this.userSno = userSno;
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
        return "EduUser{" +
                "userId='" + userId + '\'' +
                ", userPortrait='" + userPortrait + '\'' +
                ", userNickname='" + userNickname + '\'' +
                ", userMobile='" + userMobile + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userSchool='" + userSchool + '\'' +
                ", userSno='" + userSno + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", reverse1='" + reverse1 + '\'' +
                ", reverse2='" + reverse2 + '\'' +
                '}';
    }
}
