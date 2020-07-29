package com.zlt.mapper;


import com.zlt.pojo.EduTeacher;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EduTeacherMapper {
    List<EduTeacher> findAllTeacher();
    EduTeacher findByTeacherId(String teacherId);
    EduTeacher findByTeacherMobile(String teacherMobile);

}
