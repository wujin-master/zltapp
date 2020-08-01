package com.zlt.service;

import com.zlt.pojo.EduUserTask;

import java.util.List;

public interface EduUserTaskService {
    List<EduUserTask> findTaskByUserId(String id);
    List<EduUserTask> findUserByTaskId(String id);
    int addUserTask(EduUserTask eduUserTask);
    int delUserTask(EduUserTask eduUserTask);
    int updUserTask(EduUserTask eduUserTask);
    EduUserTask findByUITI(String userId,String taskId);
}
