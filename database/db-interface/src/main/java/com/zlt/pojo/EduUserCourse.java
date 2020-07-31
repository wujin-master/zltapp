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

    public EduUserCourse() {
    }

    public EduUserCourse(String id, String userId, String courseId, Integer percent, Integer score, String reverse1, String reverse2) {
        this.id = id;
        this.userId = userId;
        this.courseId = courseId;
        this.percent = percent;
        this.score = score;
        this.reverse1 = reverse1;
        this.reverse2 = reverse2;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public void setPercent(Integer percent) {
        this.percent = percent;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public void setReverse1(String reverse1) {
        this.reverse1 = reverse1;
    }

    public void setReverse2(String reverse2) {
        this.reverse2 = reverse2;
    }

    public String getId() {
        return id;
    }

    public String getUserId() {
        return userId;
    }

    public String getCourseId() {
        return courseId;
    }

    public Integer getPercent() {
        return percent;
    }

    public Integer getScore() {
        return score;
    }

    public String getReverse1() {
        return reverse1;
    }

    public String getReverse2() {
        return reverse2;
    }
}
