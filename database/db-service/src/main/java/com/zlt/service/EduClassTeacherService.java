package com.zlt.service;

import com.zlt.pojo.EduClassTeacher;

import java.util.List;

public interface EduClassTeacherService {
    List<EduClassTeacher> findAll();
    EduClassTeacher findClassTeacherById(String id);
    int addClassTeacher(EduClassTeacher classTeacher);
    int deleteClassTeacherById(String id);
    int updateClassTeacher(EduClassTeacher classTeacher);
}
