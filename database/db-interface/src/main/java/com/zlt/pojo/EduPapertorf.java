package com.zlt.pojo;

import java.sql.Timestamp;

public class EduPapertorf {
    private String id;
    private String paperId;
    private String torfId;
    private java.sql.Timestamp createTime;
    private java.sql.Timestamp updateTime;
    private String reserv1;
    private String reserv2;

    public EduPapertorf() {
    }

    public EduPapertorf(String id, String paperId, String torfId, Timestamp createTime, Timestamp updateTime, String reserv1, String reserv2) {
        this.id = id;
        this.paperId = paperId;
        this.torfId = torfId;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.reserv1 = reserv1;
        this.reserv2 = reserv2;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPaperId() {
        return paperId;
    }

    public void setPaperId(String paperId) {
        this.paperId = paperId;
    }

    public String getTorfId() {
        return torfId;
    }

    public void setTorfId(String torfId) {
        this.torfId = torfId;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
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

    @Override
    public String toString() {
        return "EduPapertorf{" +
                "id='" + id + '\'' +
                ", paperId='" + paperId + '\'' +
                ", torfId='" + torfId + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", reserv1='" + reserv1 + '\'' +
                ", reserv2='" + reserv2 + '\'' +
                '}';
    }
}
