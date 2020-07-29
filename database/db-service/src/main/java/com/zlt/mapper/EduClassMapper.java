package com.zlt.mapper;

import com.zlt.pojo.EduClass;

import java.util.List;

public interface EduClassMapper {
    int addClass(EduClass eduUser);
    List<EduClass> queryClasses();
    int deleteClass(String id);
    int updateClass(EduClass eduClass);
    EduClass findById(String id);
}