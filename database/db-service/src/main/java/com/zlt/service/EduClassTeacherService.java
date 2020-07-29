package com.zlt.service;

import com.zlt.pojo.EduClassTeacher;

import java.util.List;

public interface EduClassTeacherService {
    public List<EduClassTeacher> findAll();
    public EduClassTeacher findClassTeacherById(String id);
    public int addClassTeacher(EduClassTeacher classTeacher);
    public int deleteClassTeacherById(String id);
    public int updateClassTeacher(EduClassTeacher classTeacher);
}
