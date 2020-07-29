package com.zlt.service;

import com.zlt.pojo.EduUserCourse;

import java.util.List;

public interface EduUserCourseService {
    int addUserCourse(EduUserCourse eduUserCourse);
    List<EduUserCourse> findByUserId(String id);
    List<EduUserCourse> findByCourseId(String id);
    int updateUserCourse(EduUserCourse eduUserCourse);
    int deleteUserCourse(String id);
}
