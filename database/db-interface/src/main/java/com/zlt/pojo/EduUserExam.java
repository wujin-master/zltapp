package com.zlt.pojo;

import lombok.Data;


public class EduUserExam {
    private String id;
    private String userId;
    private String examId;
    private String reverse1;
    private String reverse2;

    public EduUserExam() {
    }

    public EduUserExam(String id, String userId, String examId, String reverse1, String reverse2) {
        this.id = id;
        this.userId = userId;
        this.examId = examId;
        this.reverse1 = reverse1;
        this.reverse2 = reverse2;
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
}
