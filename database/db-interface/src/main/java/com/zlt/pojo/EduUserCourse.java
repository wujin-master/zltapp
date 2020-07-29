package com.zlt.pojo;

import lombok.Data;

@Data
public class EduUserCourse {
    private String id;
    private String userId;
    private String courseId;
    private Integer percent;
    private Integer score;
    private String reverse1;
    private String reverse2;
}
