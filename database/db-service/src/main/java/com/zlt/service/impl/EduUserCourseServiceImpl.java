package com.zlt.service.impl;

import com.zlt.mapper.EduUserCourseMapper;
import com.zlt.pojo.EduUserCourse;
import com.zlt.service.EduUserCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EduUserCourseServiceImpl implements EduUserCourseService {
    @Autowired(required = false)
    private EduUserCourseMapper eduUserCourseMapper;
    @Override
    public int addUserCourse(EduUserCourse eduUserCourse) {
        return eduUserCourseMapper.addUserCourse(eduUserCourse);
    }

    @Override
    public List<EduUserCourse> findByUserId(String id) {
        return eduUserCourseMapper.findByUserId(id);
    }

    @Override
    public List<EduUserCourse> findByCourseId(String id) {
        return eduUserCourseMapper.findByCourseId(id);
    }

    @Override
    public int updateUserCourse(EduUserCourse eduUserCourse) {
        return eduUserCourseMapper.updateUserCourse(eduUserCourse);
    }

    @Override
    public int deleteUserCourse(String id) {
        return eduUserCourseMapper.deleteUserCourse(id);
    }
}
