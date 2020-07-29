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
    private Date updateTime;
    private String reverse1;
    private String reverse2;
}
