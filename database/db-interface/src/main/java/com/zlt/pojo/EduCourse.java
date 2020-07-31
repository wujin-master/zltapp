package com.zlt.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class EduCourse {
    private String courseId;
    private String courseName;
    private String courseMaster;
    private String courseDescription;
    private String coverImg;
    private String liveUrl;
    private Date createTime;
    private Date updateTime;
    private String reverse1;
    private String reverse2;

    public EduCourse() {
    }

    public EduCourse(String courseId, String courseName, String courseMaster, String courseDescription, String coverImg, String liveUrl, Date createTime, Date updateTime, String reverse1, String reverse2) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.courseMaster = courseMaster;
        this.courseDescription = courseDescription;
        this.coverImg = coverImg;
        this.liveUrl = liveUrl;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.reverse1 = reverse1;
        this.reverse2 = reverse2;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseMaster() {
        return courseMaster;
    }

    public void setCourseMaster(String courseMaster) {
        this.courseMaster = courseMaster;
    }

    public String getCourseDescription() {
        return courseDescription;
    }

    public void setCourseDescription(String courseDescription) {
        this.courseDescription = courseDescription;
    }

    public String getCoverImg() {
        return coverImg;
    }

    public void setCoverImg(String coverImg) {
        this.coverImg = coverImg;
    }

    public String getLiveUrl() {
        return liveUrl;
    }

    public void setLiveUrl(String liveUrl) {
        this.liveUrl = liveUrl;
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
        return "EduCourse{" +
                "courseId='" + courseId + '\'' +
                ", courseName='" + courseName + '\'' +
                ", courseMaster='" + courseMaster + '\'' +
                ", courseDescription='" + courseDescription + '\'' +
                ", coverImg='" + coverImg + '\'' +
                ", liveUrl='" + liveUrl + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", reverse1='" + reverse1 + '\'' +
                ", reverse2='" + reverse2 + '\'' +
                '}';
    }
}
