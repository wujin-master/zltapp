package com.zlt.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class EduTask {
    private String taskId;
    private String taskName;
    private String teacherId;
    private Integer taskNum;
    private float taskGrade;
    private String paperId;
    private String courseId;
    private Date createTime;
    private Date updateTime;
    private String reverse1;
    private String reverse2;
}
