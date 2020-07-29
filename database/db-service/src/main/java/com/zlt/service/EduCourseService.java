package com.zlt.service;

import com.zlt.pojo.EduCourse;

import java.util.List;

public interface EduCourseService {
    List<EduCourse> findAll();
    int addCourse(EduCourse course);
    EduCourse findById(String id);
    EduCourse getCourseByNameMaster(String courseName,String courseMaster);
    int deleteCourse(String id);
    int updateCourse(EduCourse eduCourse);
}
