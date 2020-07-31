package com.zlt.service;

import com.zlt.pojo.EduTeacherCourse;

import java.util.List;

public interface TeacherCourseService {
    int addTeacherCourse(EduTeacherCourse eduTeacherCourse);
    List<EduTeacherCourse> findByTeacherId(String id);
    List<EduTeacherCourse> findByCourseId(String id);
    int updateTeacherCourse(EduTeacherCourse eduTeacherCourse);
    int deleteTeacherCourseById(String id);
    int deleteTeacherCourse(String teacherId,String courseId);
}
