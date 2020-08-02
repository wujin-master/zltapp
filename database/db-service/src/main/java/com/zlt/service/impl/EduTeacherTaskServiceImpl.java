package com.zlt.service.impl;

import com.zlt.pojo.EduTeacherTask;
import com.zlt.service.EduTeacherTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EduTeacherTaskServiceImpl implements EduTeacherTaskService {
    @Autowired(required = false)
    private EduTeacherTaskService eduTeacherTaskService;
    @Override
    public int addTeacherTask(EduTeacherTask eduTeacherTask) {
        return eduTeacherTaskService.addTeacherTask(eduTeacherTask);
    }

    @Override
    public int updateTeacherTask(EduTeacherTask eduTeacherTask) {
        return eduTeacherTaskService.updateTeacherTask(eduTeacherTask);
    }

    @Override
    public int deleteTeacherTask(String teacherId,String taskId) {
        return eduTeacherTaskService.deleteTeacherTask(teacherId,taskId);
    }

    @Override
    public List<EduTeacherTask> findById(String teacherId) {
        return eduTeacherTaskService.findById(teacherId);
    }
}
