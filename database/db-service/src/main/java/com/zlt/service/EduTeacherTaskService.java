package com.zlt.service;

import com.zlt.pojo.EduTeacherTask;

import java.util.List;

public interface EduTeacherTaskService {
    int addTeacherTask(EduTeacherTask eduTeacherTask);
    int updateTeacherTask(EduTeacherTask eduTeacherTask);
    int deleteTeacherTask(String teacherId,String taskId);
    List<EduTeacherTask> findById(String teacherId);
}
