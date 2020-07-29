package com.zlt.service.impl;

import com.zlt.mapper.EduClassTeacherMapper;
import com.zlt.pojo.EduClassTeacher;
import com.zlt.service.EduClassTeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EduClassTeacherServiceImpl implements EduClassTeacherService {
    @Autowired(required = false)
    EduClassTeacherMapper eduClassTeacherMapper;

    @Override
    public List<EduClassTeacher> findAll() {
        return eduClassTeacherMapper.findAll();
    }

    @Override
    public EduClassTeacher findClassTeacherById(String id) {
        return eduClassTeacherMapper.findClassTeacherById(id);
    }

    @Override
    public int addClassTeacher(EduClassTeacher classTeacher) {
        return eduClassTeacherMapper.addClassTeacher(classTeacher);
    }

    @Override
    public int deleteClassTeacherById(String id) {
        return eduClassTeacherMapper.deleteClassTeacherById(id);
    }

    @Override
    public int updateClassTeacher(EduClassTeacher classTeacher) {
        return eduClassTeacherMapper.updateClassTeacher(classTeacher);
    }
}
