package com.zlt.service;

import com.zlt.pojo.EduTeacher;

import java.util.List;

public interface EduTeacherService {
    public List<EduTeacher> queryUsers();   //查所有教师
    public EduTeacher findById(String teacherId);     //根据id查教师
    public EduTeacher findByMobile(String teacherMobile);  //根据手机号查id

}
