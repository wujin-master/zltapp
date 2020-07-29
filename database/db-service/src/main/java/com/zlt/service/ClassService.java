package com.zlt.service;

import com.zlt.pojo.EduClass;

import java.util.List;

public interface ClassService {
    List<EduClass> findAllClass();
    EduClass findClassByClassId(String classId);
    int addClass(EduClass eduClass);
    int updateClass(EduClass eduClass);
    int deleteClass(String classId);
}
