package com.zlt.mapper;

import com.zlt.pojo.EduUserCourse;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EduUserCourseMapper{
    int addUserCourse(EduUserCourse eduUserCourse);
    List<EduUserCourse> findByUserId(String id);
    List<EduUserCourse> findByCourseId(String id);
    EduUserCourse findUserCourse(String userId,String courseId);
    int updateUserCourse(EduUserCourse eduUserCourse);
    int deleteUserCourseById(String id);
    int deleteUserCourse(String userId,String courseId);
}
