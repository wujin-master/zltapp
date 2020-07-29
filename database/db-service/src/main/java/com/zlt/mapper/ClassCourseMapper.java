package com.zlt.mapper;

import com.zlt.pojo.EduClasscourse;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ClassCourseMapper {
    List<EduClasscourse> findAllClassCourse();
    int addClassCourse(EduClasscourse eduClasscourse);
    int updateClassCourse(EduClasscourse eduClasscourse);
    EduClasscourse findClassCourseById(String id);
    int deleteClassCourse(String id);
}
