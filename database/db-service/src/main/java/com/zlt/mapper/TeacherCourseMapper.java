package com.zlt.mapper;

import com.zlt.pojo.EduTeacherCourse;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TeacherCourseMapper {
    int addTeacherCourse(EduTeacherCourse eduTeacherCourse);
    List<EduTeacherCourse> findByTeacherId(String id);
    List<EduTeacherCourse> findByCourseId(String id);
    int updateTeacherCourse(EduTeacherCourse eduTeacherCourse);
    int deleteTeacherCourseById(String id);
    int deleteTeacherCourse(String teacherId,String courseId);
}
