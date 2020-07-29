package com.zlt.pojo;

import java.sql.Date;
import java.sql.Timestamp;

public class EduTrueOrFalse {
    private String id;
    private String question;
    private String answer;
    private String score;
    private Date createTime;
    private Date updateTime;
    private String reserv1;
    private String reserv2;

    public EduTrueOrFalse() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
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

    public String getReserv1() {
        return reserv1;
    }

    public void setReserv1(String reserv1) {
        this.reserv1 = reserv1;
    }

    public String getReserv2() {
        return reserv2;
    }

    public void setReserv2(String reserv2) {
        this.reserv2 = reserv2;
    }
}
