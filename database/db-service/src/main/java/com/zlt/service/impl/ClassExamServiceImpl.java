package com.zlt.service.impl;

import com.zlt.mapper.ClassExamMapper;
import com.zlt.pojo.EduClassExam;
import com.zlt.service.ClassExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ClassExamServiceImpl implements ClassExamService {

    @Autowired(required = false)
    private ClassExamMapper classExamMapper;

    @Override
    public List<EduClassExam> findAllClassExam() {
        return classExamMapper.findAllClassExam();
    }

    @Override
    public int addClassExam(EduClassExam eduClassExam) {
        return classExamMapper.addClassExam(eduClassExam);
    }

    @Override
    public int updateClassExam(EduClassExam eduClassExam) {
        return classExamMapper.updateClassExam(eduClassExam);
    }

    @Override
    public EduClassExam findClassExamById(String id) {
        return classExamMapper.findClassExamById(id);
    }

    @Override
    public int deleteClassExam(String id) {
        return classExamMapper.deleteClassExam(id);
    }
}
