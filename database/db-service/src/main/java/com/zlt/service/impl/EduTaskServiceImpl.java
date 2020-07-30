package com.zlt.service.impl;

import com.zlt.mapper.EduTaskMapper;
import com.zlt.pojo.EduTask;
import com.zlt.service.EduTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EduTaskServiceImpl implements EduTaskService {
    @Autowired(required = false)
    private EduTaskMapper eduTaskMapper;
    @Override
    public int addTask(EduTask eduTask) {
        return eduTaskMapper.addTask(eduTask);
    }

    @Override
    public int updateTask(EduTask eduTask) {
        return eduTaskMapper.updateTask(eduTask);
    }

    @Override
    public int deleteTask(String id) {
        return eduTaskMapper.deleteTask(id);
    }

    @Override
    public EduTask findById(String id) {
        return eduTaskMapper.findById(id);
    }
}
