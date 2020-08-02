package com.zlt.mapper;

import com.zlt.pojo.EduTeacher;
import com.zlt.pojo.EduTeacherExam;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EduTeacherExamMapper {
    int addTeacherExam(EduTeacherExam eduTeacherExam);
    int updateTeacherExam(EduTeacherExam eduTeacherExam);
    int deleteTeacherExam(String teacherId,String examId);
    List<EduTeacherExam> findByTeacherId(String teacherId);
}
