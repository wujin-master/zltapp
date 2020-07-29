package com.zlt.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class EduCourse {
    private String courseId;
    private String courseName;
    private String courseMaster;
    private String courseDescription;
    private String coverImg;
    private String liveUrl;
    private Date createTime;
    private Date updateTime;
    private String reverse1;
    private String reverse2;
}
