package com.zlt.mapper;

import com.zlt.pojo.EduUserTask;

import java.util.List;

public interface EduUserTaskMapper {
    List<EduUserTask> findTaskByUserId(String id);
    List<EduUserTask> findUserByExamId(String id);
    int addUserTask(EduUserTask eduUserTask);
    int delUserTask(EduUserTask eduUserTask);
    int updUserTask(EduUserTask eduUserTask);
}
