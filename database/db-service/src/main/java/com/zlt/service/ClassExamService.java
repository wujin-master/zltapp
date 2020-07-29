package com.zlt.service;

import com.zlt.pojo.EduClassExam;

import java.util.List;

public interface ClassExamService {
    List<EduClassExam> findAllClassExam();
    int addClassExam(EduClassExam eduClassExam);
    int updateClassExam(EduClassExam eduClassExam);
    EduClassExam findClassExamById(String id);
    int deleteClassExam(String id);
}
