package com.zlt.pojo;


public class EduPaper {

  private String paperId;
  private String paperName;
  private String questionNumber;
  private String courseName;
  private long paperState;
  private String paperGrade;
  private java.sql.Timestamp createTime;
  private java.sql.Timestamp updateTime;
  private String reserve1;
  private String reserve2;


  public String getPaperId() {
    return paperId;
  }

  public void setPaperId(String paperId) {
    this.paperId = paperId;
  }


  public String getPaperName() {
    return paperName;
  }

  public void setPaperName(String paperName) {
    this.paperName = paperName;
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


  public long getPaperState() {
    return paperState;
  }

  public void setPaperState(long paperState) {
    this.paperState = paperState;
  }


  public String getPaperGrade() {
    return paperGrade;
  }

  public void setPaperGrade(String paperGrade) {
    this.paperGrade = paperGrade;
  }


  public java.sql.Timestamp getCreateTime() {
    return createTime;
  }

  public void setCreateTime(java.sql.Timestamp createTime) {
    this.createTime = createTime;
  }


  public java.sql.Timestamp getUpdateTime() {
    return updateTime;
  }

  public void setUpdateTime(java.sql.Timestamp updateTime) {
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

}
