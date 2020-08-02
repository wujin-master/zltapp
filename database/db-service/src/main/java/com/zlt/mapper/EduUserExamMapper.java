package com.zlt.mapper;

import com.zlt.pojo.EduUserExam;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface EduUserExamMapper {
    List<EduUserExam> findExamByUserId(String id);
    List<EduUserExam> findUserByExamId(String id);
    int addUserExam(EduUserExam eduUserExam);
    int delUserExam(EduUserExam eduUserExam);
    int updUserExam(EduUserExam eduUserExam);
}
