package com.zlt.service;

import com.zlt.pojo.EduTeacherExam;

import java.util.List;

public interface EduTeacherExamService {
    int addTeacherExam(EduTeacherExam eduTeacherExam);
    int updateTeacherExam(EduTeacherExam eduTeacherExam);
    int deleteTeacherExam(String teacherId,String examId);
    List<EduTeacherExam> findByTeacherId(String teacherId);
}
