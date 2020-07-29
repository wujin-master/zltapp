package com.zlt.mapper;

import com.zlt.pojo.EduClassExam;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ClassExamMapper {
    List<EduClassExam> findAllClassExam();
    int addClassExam(EduClassExam eduClassExam);
    int updateClassExam(EduClassExam eduClassExam);
    EduClassExam findClassExamById(String id);
    int deleteClassExam(String id);
}
