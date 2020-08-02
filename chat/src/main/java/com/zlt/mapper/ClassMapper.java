package com.zlt.mapper;

import com.zlt.pojo.EduClass;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ClassMapper {
    List<EduClass> findAllClass();
    EduClass findClassByClassId(String classId);
    int addClass(EduClass eduClass);
    int updateClass(EduClass eduClass);
    int deleteClass(String classId);
}
