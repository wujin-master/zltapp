package com.zlt.mapper;

import com.zlt.pojo.EduUserTask;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EduUserTaskMapper {
    List<EduUserTask> findTaskByUserId(String id);
    List<EduUserTask> findUserByTaskId(String id);
    int addUserTask(EduUserTask eduUserTask);
    int delUserTask(EduUserTask eduUserTask);
    int updUserTask(EduUserTask eduUserTask);
    EduUserTask findByUITI(String userId,String taskId);
}
