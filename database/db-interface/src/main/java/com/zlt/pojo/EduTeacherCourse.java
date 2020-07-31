package com.zlt.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class EduTeacherCourse {
    private String id;
    private String teacherId;
    private String courseId;
    private String reverse1;
    private String reverse2;

    public EduTeacherCourse() {
    }

    public EduTeacherCourse(String id, String teacherId, String courseId, String reverse1, String reverse2) {
        this.id = id;
        this.teacherId = teacherId;
        this.courseId = courseId;
        this.reverse1 = reverse1;
        this.reverse2 = reverse2;
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

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
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
}
