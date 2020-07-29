package com.zlt.pojo;

import java.util.Date;

public class EduClassExam {
    private String id;
    private String classId;
    private String examId;;
    private String reserve1;
    private String reserve2;

    public EduClassExam() {
    }

    public EduClassExam(String id, String classId, String examId, String reserve1, String reserve2) {
        this.id = id;
        this.classId = classId;
        this.examId = examId;
        this.reserve1 = reserve1;
        this.reserve2 = reserve2;
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

    public String getReserve1() {
        return reserve1;
    }

    public void setReserve1(String reserve1) {
        this.reserve1 = reserve1;
    }

    public String getReserve2() {
        return reserve2;
    }

    public void setReserve2(String reserve2) {
        this.reserve2 = reserve2;
    }

    @Override
    public String toString() {
        return "EduClassExam{" +
                "id='" + id + '\'' +
                ", classId='" + classId + '\'' +
                ", examId='" + examId + '\'' +
                ", reserve1='" + reserve1 + '\'' +
                ", reserve2='" + reserve2 + '\'' +
                '}';
    }
}
