package com.zlt.service;

import com.zlt.pojo.EduExam;
import java.util.List;

public interface ExamService {

    List<EduExam> findAllExam(String id);
    EduExam findExamByExamId(String examId);
    int addExam(EduExam eduExam);
    int updateExam(EduExam eduExam);
    int deleteExam(String examId);
}
