package com.zlt.pojo;

import java.util.Date;

public class EduExam {
    private String examId;
    private String courseId;
    private String paperId;
    private String examname;
    private Date examStartTime;
    private Date examEndTime;
    private int totalTime;
    private String examExplain;
    private String joinYear;
    private String grade;
    private String term;
    private String major;
    private Date createTime;
    private Date updateTime;
    private String reserve1;
    private String reserve2;

    public EduExam() {
    }

    public EduExam(String examId, String courseId, String paperId, String examname, Date examStartTime, Date examEndTime, int totalTime, String examExplain, String joinYear, String grade, String term, String major, Date createTime, Date updateTime, String reserve1, String reserve2) {
        this.examId = examId;
        this.courseId = courseId;
        this.paperId = paperId;
        this.examname = examname;
        this.examStartTime = examStartTime;
        this.examEndTime = examEndTime;
        this.totalTime = totalTime;
        this.examExplain = examExplain;
        this.joinYear = joinYear;
        this.grade = grade;
        this.term = term;
        this.major = major;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.reserve1 = reserve1;
        this.reserve2 = reserve2;
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

    public String getPaperId() {
        return paperId;
    }

    public void setPaperId(String paperId) {
        this.paperId = paperId;
    }

    public String getExamname() {
        return examname;
    }

    public void setExamname(String examname) {
        this.examname = examname;
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

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
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
        return "EduExam{" +
                "examId='" + examId + '\'' +
                ", courseId='" + courseId + '\'' +
                ", paperId='" + paperId + '\'' +
                ", examname='" + examname + '\'' +
                ", examStartTime=" + examStartTime +
                ", examEndTime=" + examEndTime +
                ", totalTime=" + totalTime +
                ", examExplain='" + examExplain + '\'' +
                ", joinYear='" + joinYear + '\'' +
                ", grade='" + grade + '\'' +
                ", term='" + term + '\'' +
                ", major='" + major + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", reserve1='" + reserve1 + '\'' +
                ", reserve2='" + reserve2 + '\'' +
                '}';
    }
}