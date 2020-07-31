package com.zlt.service;

import com.zlt.pojo.EduUserExam;

import java.util.List;

public interface EduUserExamService {
    List<EduUserExam> findExamByUserId(String id);
    List<EduUserExam> findUserByExamId(String id);
    int addUserExam(EduUserExam eduUserExam);
    int delUserExam(EduUserExam eduUserExam);
    int updUserExam(EduUserExam eduUserExam);
}
