package com.zlt.service.impl;

import com.zlt.mapper.EduTeacherExamMapper;
import com.zlt.pojo.EduTeacherExam;
import com.zlt.service.EduTeacherExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EduTeacherExamServiceImpl implements EduTeacherExamService {
    @Autowired(required = false)
    private EduTeacherExamMapper eduTeacherExamMapper;
    @Override
    public int addTeacherExam(EduTeacherExam eduTeacherExam) {
        return eduTeacherExamMapper.addTeacherExam(eduTeacherExam);
    }

    @Override
    public int updateTeacherExam(EduTeacherExam eduTeacherExam) {
        return eduTeacherExamMapper.updateTeacherExam(eduTeacherExam);
    }

    @Override
    public int deleteTeacherExam(String teacherId, String examId) {
        return eduTeacherExamMapper.deleteTeacherExam(teacherId,examId);
    }

    @Override
    public List<EduTeacherExam> findByTeacherId(String teacherId) {
        return eduTeacherExamMapper.findByTeacherId(teacherId);
    }
}
