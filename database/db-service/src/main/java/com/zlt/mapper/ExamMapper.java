package com.zlt.mapper;

import com.zlt.pojo.EduExam;
import org.apache.ibatis.annotations.Mapper;


import java.util.List;
@Mapper
public interface ExamMapper {

    List<EduExam> findAllExam();
    EduExam findExamByExamId(String examId);
    int addExam(EduExam eduExam);
    int updateExam(EduExam eduExam);
    int deleteExam(String examId);
}
