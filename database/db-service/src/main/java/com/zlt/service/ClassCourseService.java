package com.zlt.service;

import com.zlt.pojo.EduClasscourse;

import java.util.List;

public interface ClassCourseService {
    List<EduClasscourse> findAllClassCourse();
    int addClassCourse(EduClasscourse eduClasscourse);
    int updateClassCourse(EduClasscourse eduClasscourse);
    EduClasscourse findClassCourseById(String id);
    List<EduClasscourse> findAllCourseByClassId(String cid);
    int deleteClassCourse(String id);
}
