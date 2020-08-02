package com.zlt.mapper;

import com.zlt.pojo.EduTeacherTask;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EduTeacherTaskMapper {
    int addTeacherTask(EduTeacherTask eduTeacherTask);
    int updateTeacherTask(EduTeacherTask eduTeacherTask);
    int deleteTeacherTask(String teacherId,String taskId);
    List<EduTeacherTask> findById(String teacherId);
}
