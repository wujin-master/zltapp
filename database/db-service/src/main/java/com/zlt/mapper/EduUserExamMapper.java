package com.zlt.mapper;

import com.zlt.pojo.EduUserExam;

import java.util.List;

public interface EduUserExamMapper {
    List<EduUserExam> findExamByUserId(String id);
    List<EduUserExam> findUserByExamId(String id);
    int addUserExam(EduUserExam eduUserExam);
    int delUserExam(EduUserExam eduUserExam);
    int updUserExam(EduUserExam eduUserExam);
}
