package com.zlt.service.impl;

import com.zlt.mapper.EduClassTaskMapper;
import com.zlt.pojo.EduClassTask;
import com.zlt.service.EduClassTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EduClassTaskServiceImpl implements EduClassTaskService {
    @Autowired(required = false)
    private EduClassTaskMapper eduClassTaskMapper;
    @Override
    public int addClassTask(EduClassTask eduClassTask) {
        return eduClassTaskMapper.addClassTask(eduClassTask);
    }

    @Override
    public List<EduClassTask> findByClassId(String id) {
        return eduClassTaskMapper.findByClassId(id);
    }

    @Override
    public List<EduClassTask> findByTaskId(String id) {
        return eduClassTaskMapper.findByTaskId(id);
    }

    @Override
    public int updateClassTask(EduClassTask eduClassTask) {
        return eduClassTaskMapper.updateClassTask(eduClassTask);
    }

    @Override
    public int deleteClassTask(String id) {
        return eduClassTaskMapper.deleteClassTask(id);
    }
}
