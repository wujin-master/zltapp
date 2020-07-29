package com.zlt.pojo;

import java.util.Date;

public class EduExam {
    private String examId; //考试Id
    private String courseId; //所属课程
    private String papaerId;   //试卷id
    private String examName; //考试名称
    private Date examStartTime;  //开始时间
    private Date examEndTime;   //更新时间
    private int totalTime;      //持续分钟
    private String examExplain;    //考试说明
    private String joinYear; //届数
    private String grade;  //年级
    private String term;   //学期
    private String major;   //专业
    private Date createTime;  //创建时间
    private Date upDateTimel;   //更新时间
    private String reverse1;    //保留字段1
    private String reverse2;    //保留字段2

    public EduExam() {
    }

    public EduExam(String examId, String courseId, String papaerId, String examName, Date examStartTime, Date examEndTime, int totalTime, String examExplain, String joinYear, String grade, String term, String major, Date createTime, Date upDateTimel, String reverse1, String reverse2) {
        this.examId = examId;
        this.courseId = courseId;
        this.papaerId = papaerId;
        this.examName = examName;
        this.examStartTime = examStartTime;
        this.examEndTime = examEndTime;
        this.totalTime = totalTime;
        this.examExplain = examExplain;
        this.joinYear = joinYear;
        this.grade = grade;
        this.term = term;
        this.major = major;
        this.createTime = createTime;
        this.upDateTimel = upDateTimel;
        this.reverse1 = reverse1;
        this.reverse2 = reverse2;
    }

    public String getExamId() {
        return examId;
    }

    public void setExamId(String examId) {
        this.examId = examId;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getPapaerId() {
        return papaerId;
    }

    public void setPapaerId(String papaerId) {
        this.papaerId = papaerId;
    }

    public String getExamName() {
        return examName;
    }

    public void setExamName(String examName) {
        this.examName = examName;
    }

    public Date getExamStartTime() {
        return examStartTime;
    }

    public void setExamStartTime(Date examStartTime) {
        this.examStartTime = examStartTime;
    }

    public Date getExamEndTime() {
        return examEndTime;
    }

    public void setExamEndTime(Date examEndTime) {
        this.examEndTime = examEndTime;
    }

    public int getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(int totalTime) {
        this.totalTime = totalTime;
    }

    public String getExamExplain() {
        return examExplain;
    }

    public void setExamExplain(String examExplain) {
        this.examExplain = examExplain;
    }

    public String getJoinYear() {
        return joinYear;
    }

    public void setJoinYear(String joinYear) {
        this.joinYear = joinYear;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
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
        return "EduExam{" +
                "examId='" + examId + '\'' +
                ", courseId='" + courseId + '\'' +
                ", papaerId='" + papaerId + '\'' +
                ", examName='" + examName + '\'' +
                ", examStartTime=" + examStartTime +
                ", examEndTime=" + examEndTime +
                ", totalTime=" + totalTime +
                ", examExplain='" + examExplain + '\'' +
                ", joinYear='" + joinYear + '\'' +
                ", grade='" + grade + '\'' +
                ", term='" + term + '\'' +
                ", major='" + major + '\'' +
                ", createTime=" + createTime +
                ", upDateTimel=" + upDateTimel +
                ", reverse1='" + reverse1 + '\'' +
                ", reverse2='" + reverse2 + '\'' +
                '}';
    }
}
