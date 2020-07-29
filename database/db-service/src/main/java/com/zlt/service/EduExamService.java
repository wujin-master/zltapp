package com.zlt.service;

import com.zlt.pojo.EduExam;

import java.util.List;

public interface EduExamService {
    public List<EduExam> queryUsers();   //查所有考试
    public EduExam findById(String examId);     //根据id查考试
}
