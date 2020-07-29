package com.zlt.service.impl;

import com.zlt.mapper.EduClassMapper;
import com.zlt.mapper.EduCourseMapper;
import com.zlt.pojo.EduCourse;
import com.zlt.service.EduCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EduCourseServiceImpl implements EduCourseService {
    @Autowired(required = false)
    private EduCourseMapper eduCourseMapper;
    @Override
    public List<EduCourse> findAll() {
        return eduCourseMapper.findAll();
    }

    @Override
    public int addCourse(EduCourse course) {
        return eduCourseMapper.addCourse(course);
    }

    @Override
    public EduCourse findById(String id) {
        return eduCourseMapper.findById(id);
    }

    @Override
    public EduCourse getCourseByNameMaster(String courseName, String courseMaster) {
        return eduCourseMapper.getCourseByNameMaster(courseName,courseMaster);
    }

    @Override
    public int deleteCourse(String id) {
        return eduCourseMapper.deleteCourse(id);
    }

    @Override
    public int updateCourse(EduCourse eduCourse) {
        return eduCourseMapper.updateCourse(eduCourse);
    }
}
