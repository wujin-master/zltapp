package com.zlt.service;

import com.zlt.pojo.EduClass;

import java.util.List;

public interface EduClassService {
    int addClass(EduClass eduUser);
    List<EduClass> queryClasses();
    int deleteClass(String id);
    int updateClass(EduClass eduClass);
    EduClass findById(String id);
    int batchDelete(List<Integer> idList);
}
