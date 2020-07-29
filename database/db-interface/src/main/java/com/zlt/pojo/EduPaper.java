package com.zlt.pojo;

import java.util.Date;

public class EduPaper {
    private String paperId; //试卷Id
    private String papaername; //试卷名
    private String questionNumber;   //题目数量
    private String courseName; //课程名
    private int paperState; //试卷状态
    private String papaerGrade;//分数

    private Date createTime;  //创建时间
    private Date upDateTimel;   //更新时间
    private String reverse1;    //保留字段1
    private String reverse2;    //保留字段2

    public EduPaper() {
    }

    public EduPaper(String paperId, String papaername, String questionNumber, String courseName, int paperState, String papaerGrade, Date createTime, Date upDateTimel, String reverse1, String reverse2) {
        this.paperId = paperId;
        this.papaername = papaername;
        this.questionNumber = questionNumber;
        this.courseName = courseName;
        this.paperState = paperState;
        this.papaerGrade = papaerGrade;
        this.createTime = createTime;
        this.upDateTimel = upDateTimel;
        this.reverse1 = reverse1;
        this.reverse2 = reverse2;
    }

    public String getPaperId() {
        return paperId;
    }

    public void setPaperId(String paperId) {
        this.paperId = paperId;
    }

    public String getPapaername() {
        return papaername;
    }

    public void setPapaername(String papaername) {
        this.papaername = papaername;
    }

    public String getQuestionNumber() {
        return questionNumber;
    }

    public void setQuestionNumber(String questionNumber) {
        this.questionNumber = questionNumber;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getPaperState() {
        return paperState;
    }

    public void setPaperState(int paperState) {
        this.paperState = paperState;
    }

    public String getPapaerGrade() {
        return papaerGrade;
    }

    public void setPapaerGrade(String papaerGrade) {
        this.papaerGrade = papaerGrade;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpDateTimel() {
        return upDateTimel;
    }

    public void setUpDateTimel(Date upDateTimel) {
        this.upDateTimel = upDateTimel;
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
        return "EduPaper{" +
                "paperId='" + paperId + '\'' +
                ", papaername='" + papaername + '\'' +
                ", questionNumber='" + questionNumber + '\'' +
                ", courseName='" + courseName + '\'' +
                ", paperState=" + paperState +
                ", papaerGrade='" + papaerGrade + '\'' +
                ", createTime=" + createTime +
                ", upDateTimel=" + upDateTimel +
                ", reverse1='" + reverse1 + '\'' +
                ", reverse2='" + reverse2 + '\'' +
                '}';
    }
}
