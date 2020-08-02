package com.zlt.service.impl;

import com.zlt.mapper.EduUserTaskMapper;
import com.zlt.pojo.EduUserTask;
import com.zlt.service.EduUserTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EduUserTaskServiceImpl implements EduUserTaskService {
    @Autowired(required = false)
    private EduUserTaskMapper eduUserTaskMapper;
    @Override
    public List<EduUserTask> findTaskByUserId(String id) {
        return eduUserTaskMapper.findTaskByUserId(id);
    }

    @Override
    public List<EduUserTask> findUserByTaskId(String id) {
        return eduUserTaskMapper.findUserByTaskId(id);
    }

    @Override
    public int addUserTask(EduUserTask eduUserTask) {
        return eduUserTaskMapper.addUserTask(eduUserTask);
    }

    @Override
    public int delUserTask(EduUserTask eduUserTask) {
        return eduUserTaskMapper.delUserTask(eduUserTask);
    }

    @Override
    public int updUserTask(EduUserTask eduUserTask) {
        return eduUserTaskMapper.updUserTask(eduUserTask);
    }

    @Override
    public EduUserTask findByUITI(String userId, String taskId) {
        return eduUserTaskMapper.findByUITI(userId,taskId);
    }

}
