package com.zlt.pojo;


import java.sql.Timestamp;

public class EduUser {

  private String userId;
  private String userPortrait;
  private String userNickname;
  private String userMobile;
  private String userEmail;
  private String userPassword;
  private String userSchool;
  private String userSno;
  private String classId;
  private Timestamp createTime;
  private Timestamp updateTime;
  private String reverse1;
  private String reverse2;


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


  public String getClassId() {
    return classId;
  }

  public void setClassId(String classId) {
    this.classId = classId;
  }


  public Timestamp getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Timestamp createTime) {
    this.createTime = createTime;
  }


  public Timestamp getUpdateTime() {
    return updateTime;
  }

  public void setUpdateTime(Timestamp updateTime) {
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

  public EduUser(String userId, String userPortrait, String userNickname, String userMobile, String userEmail, String userPassword, String userSchool, String userSno, String classId, Timestamp createTime, Timestamp updateTime, String reverse1, String reverse2) {
    this.userId = userId;
    this.userPortrait = userPortrait;
    this.userNickname = userNickname;
    this.userMobile = userMobile;
    this.userEmail = userEmail;
    this.userPassword = userPassword;
    this.userSchool = userSchool;
    this.userSno = userSno;
    this.classId = classId;
    this.createTime = createTime;
    this.updateTime = updateTime;
    this.reverse1 = reverse1;
    this.reverse2 = reverse2;
  }

  public EduUser() {
  }
}
