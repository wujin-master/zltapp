package com.zlt.service.impl;


import com.zlt.mapper.EduTeacherMapper;
import com.zlt.pojo.EduTeacher;
import com.zlt.service.EduTeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EduTeacherServiceImpl implements EduTeacherService {
    @Autowired(required = false)
    EduTeacherMapper eduTeacherMapper;

    @Override //查所有教师
    public List<EduTeacher> queryUsers(){
        return eduTeacherMapper.findAllTeacher();
    }
    @Override //根据id查教师
    public EduTeacher findById(String teacherId){
        return eduTeacherMapper.findByTeacherId(teacherId);
    }
    @Override//根据手机号查id
    public EduTeacher findByMobile(String teacherMobile){
        return eduTeacherMapper.findByTeacherMobile(teacherMobile);
    }


}
