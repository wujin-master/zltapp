package com.zlt.pojo;

import java.util.Date;

public class EduClassExam {
    private String id;
    private String classId;
    private String examId;;
    private String reverse1;
    private String reverse2;

    public EduClassExam() {
    }

    public EduClassExam(String id, String classId, String examId, String reverse1, String reverse2) {
        this.id = id;
        this.classId = classId;
        this.examId = examId;
        this.reverse1 = reverse1;
        this.reverse1 = reverse2;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
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

    @Override
    public String toString() {
        return "EduClassExam{" +
                "id='" + id + '\'' +
                ", classId='" + classId + '\'' +
                ", examId='" + examId + '\'' +
                ", reverse1='" + reverse1 + '\'' +
                ", reverse2='" + reverse2 + '\'' +
                '}';
    }
}
