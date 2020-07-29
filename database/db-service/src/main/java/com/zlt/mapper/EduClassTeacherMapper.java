package com.zlt.mapper;

import com.zlt.pojo.EduClassTeacher;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;
@Mapper
public interface EduClassTeacherMapper {
    List<EduClassTeacher> findAll();
    EduClassTeacher findClassTeacherById(String id);
    int addClassTeacher(EduClassTeacher classTeacher);
    int deleteClassTeacherById(String id);
    int updateClassTeacher(EduClassTeacher classTeacher);
}
