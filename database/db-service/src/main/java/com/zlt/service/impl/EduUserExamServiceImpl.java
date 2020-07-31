package com.zlt.service.impl;

import com.zlt.mapper.EduUserExamMapper;
import com.zlt.pojo.EduUserExam;
import com.zlt.service.EduUserExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EduUserExamServiceImpl implements EduUserExamService {
    @Autowired(required = false)
    private EduUserExamMapper eduUserExamMapper;
    @Override
    public List<EduUserExam> findExamByUserId(String id) {
        return eduUserExamMapper.findExamByUserId(id);
    }

    @Override
    public List<EduUserExam> findUserByExamId(String id) {
        return eduUserExamMapper.findUserByExamId(id);
    }

    @Override
    public int addUserExam(EduUserExam eduUserExam) {
        return eduUserExamMapper.addUserExam(eduUserExam);
    }

    @Override
    public int delUserExam(EduUserExam eduUserExam) {
        return eduUserExamMapper.delUserExam(eduUserExam);
    }

    @Override
    public int updUserExam(EduUserExam eduUserExam) {
        return eduUserExamMapper.updUserExam(eduUserExam);
    }
}
