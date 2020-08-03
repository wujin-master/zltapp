package com.zlt.service.impl;

import com.zlt.mapper.ClassCourseMapper;
import com.zlt.pojo.EduClasscourse;
import com.zlt.service.ClassCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassCourseServiceImpl implements ClassCourseService {
    @Autowired(required = false)
    private ClassCourseMapper classCourseMapper;

    @Override
    public List<EduClasscourse> findAllClassCourse() {
        return classCourseMapper.findAllClassCourse();
    }

    @Override
    public int addClassCourse(EduClasscourse eduClasscourse) {
        return classCourseMapper.addClassCourse(eduClasscourse);
    }

    @Override
    public int updateClassCourse(EduClasscourse eduClasscourse) {
        return classCourseMapper.updateClassCourse(eduClasscourse);
    }

    @Override
    public EduClasscourse findClassCourseById(String id) {
        return classCourseMapper.findClassCourseById(id);
    }

    @Override
    public int deleteClassCourse(String id) {
        return classCourseMapper.deleteClassCourse(id);
    }


    @Override
    public List<EduClasscourse> findAllCourseByClassId(String cid){
        return classCourseMapper.findAllCourseByClassId(cid);
    }
}
