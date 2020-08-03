package com.zlt.pojo;

import lombok.Data;

public class EduTeacherExam {
    private String id;
    private String teacherId;
    private String examId;
    private String reverse1;
    private String reverse2;

    public EduTeacherExam() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
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

    public EduTeacherExam(String id, String teacherId, String examId, String reverse1, String reverse2) {
        this.id = id;
        this.teacherId = teacherId;
        this.examId = examId;
        this.reverse1 = reverse1;
        this.reverse2 = reverse2;
    }

    @Override
    public String toString() {
        return "EduTeacherExam{" +
                "id='" + id + '\'' +
                ", teacherId='" + teacherId + '\'' +
                ", examId='" + examId + '\'' +
                ", reverse1='" + reverse1 + '\'' +
                ", reverse2='" + reverse2 + '\'' +
                '}';
    }
}
