package com.zlt.service.impl;

import com.zlt.mapper.EduExamMapper;
import com.zlt.pojo.EduExam;
import com.zlt.service.EduExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EduExamServiceImpl implements EduExamService {
    @Autowired(required = false)
    EduExamMapper eduExamMapper;

    @Override//查所有考试
    public List<EduExam> queryUsers(){
        return eduExamMapper.findAllExam();
    }
    @Override //根据id查考试
    public EduExam findById(String examId){
        return eduExamMapper.findByExamId(examId);
    }
}
