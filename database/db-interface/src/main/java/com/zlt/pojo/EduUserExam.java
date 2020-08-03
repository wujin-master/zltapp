package com.zlt.pojo;

import lombok.Data;


public class EduUserExam {
    private String id;
    private String userId;
    private String examId;
    private Integer score;
    private String reverse2;

    public EduUserExam() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getExamId() {
        return examId;
    }

    public void setExamId(String examId) {
        this.examId = examId;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getReverse2() {
        return reverse2;
    }

    public void setReverse2(String reverse2) {
        this.reverse2 = reverse2;
    }
}
