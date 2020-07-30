package com.zlt.mapper;


import com.zlt.pojo.EduTeacher;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface TeacherMapper {
    List<EduTeacher> findAllTeacher();
    EduTeacher findByTeacherId(String teacherId);
    EduTeacher findTeacherByMobile(String teacherMobile);
    EduTeacher findByEmail(String teacherEmail);
    int addTeacher(EduTeacher eduTeacher);
    int updateTeacher(EduTeacher eduTeacher);
    int deleteTeacher(String teacherId);
}
