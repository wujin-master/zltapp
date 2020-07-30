package com.zlt.service.impl;

import com.zlt.mapper.TeacherMapper;
import com.zlt.pojo.EduTeacher;
import com.zlt.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired(required = false)
    private TeacherMapper teacherMapper;

    @Override
    public List<EduTeacher> findAllTeacher() {
        return teacherMapper.findAllTeacher();
    }

    @Override
    public EduTeacher findByTeacherId(String teacherId) {
        return teacherMapper.findByTeacherId(teacherId);
    }

    @Override
    public int addTeacher(EduTeacher eduTeacher) {
        return teacherMapper.addTeacher(eduTeacher);
    }

    @Override
    public int updateTeacher(EduTeacher eduTeacher) {
        return teacherMapper.updateTeacher(eduTeacher);
    }

    @Override
    public int deleteTeacher(String teacherId) {
        return teacherMapper.deleteTeacher(teacherId);
    }

    @Override
    public EduTeacher findTeacherByMobile(String teacherMobile){
        return teacherMapper.findTeacherByMobile(teacherMobile);
    }
}
