package com.zlt.service.impl;

import com.zlt.mapper.ExamMapper;
import com.zlt.mapper.PaperMapper;
import com.zlt.pojo.EduExam;
import com.zlt.pojo.EduPaper;
import com.zlt.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExamServiceImpl implements ExamService {

    @Autowired(required = false)
    private ExamMapper examMapper;

    @Override
    public List<EduExam> findAllExam(){
        return examMapper.findAllExam();
    }

    @Override
    public EduExam findExamByExamId(String examId) {
        return examMapper.findExamByExamId(examId);
    }

    @Override
    public int addExam(EduExam eduExam) {
        return examMapper.addExam(eduExam);
    }

    @Override
    public int updateExam(EduExam eduExam) {
        return examMapper.updateExam(eduExam);
    }

    @Override
    public int deleteExam(String examId) {
        return examMapper.deleteExam(examId);
    }


}
