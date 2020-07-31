package com.zlt.service.impl;

import com.zlt.mapper.TeacherCourseMapper;
import com.zlt.pojo.EduTeacher;
import com.zlt.pojo.EduTeacherCourse;
import com.zlt.service.TeacherCourseService;
import com.zlt.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TeacherCourseServiceImpl implements TeacherCourseService {
    @Autowired(required = false)
    private TeacherCourseMapper teacherCourseMapper;


    @Override
    public int addTeacherCourse(EduTeacherCourse eduTeacherCourse) {
        return teacherCourseMapper.addTeacherCourse(eduTeacherCourse);
    }

    @Override
    public List<EduTeacherCourse> findByTeacherId(String id) {
        return teacherCourseMapper.findByTeacherId(id);
    }

    @Override
    public List<EduTeacherCourse> findByCourseId(String id) {
        return teacherCourseMapper.findByCourseId(id);
    }

    @Override
    public int updateTeacherCourse(EduTeacherCourse eduTeacherCourse) {
        return teacherCourseMapper.updateTeacherCourse(eduTeacherCourse);
    }

    @Override
    public int deleteTeacherCourse(String teacherId,String courseId) {
        return teacherCourseMapper.deleteTeacherCourse(teacherId,courseId);
    }

    @Override
    public int deleteTeacherCourseById(String id){
        return teacherCourseMapper.deleteTeacherCourseById(id);
    }

}
