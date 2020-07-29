package com.zlt.mapper;


import com.zlt.pojo.EduExam;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EduExamMapper {
    List<EduExam> findAllExam();
    EduExam findByExamId(String examId);
}
