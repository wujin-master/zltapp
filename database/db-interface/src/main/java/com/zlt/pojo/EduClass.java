package com.zlt.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class EduClass {
    private String classId;
    private String className;
    private Integer classNumber;
    private Date createTime;
    private Date updateTime;
    private String reverse1;
    private String reverse2;
}
