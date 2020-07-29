package com.zlt.service.impl;

import com.zlt.mapper.EduTaskTorfMapper;
import com.zlt.pojo.EduTaskTorf;
import com.zlt.service.EduTaskTorfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EduTaskTorfServiceImpl implements EduTaskTorfService {
    @Autowired(required = false)
    private EduTaskTorfMapper eduTaskTorfMapper;
    @Override
    public int addTaskTorf(EduTaskTorf eduTaskTorf) {
        return eduTaskTorfMapper.addTaskTorf(eduTaskTorf);
    }

    @Override
    public List<EduTaskTorf> findByTorfId(String id) {
        return eduTaskTorfMapper.findByTorfId(id);
    }

    @Override
    public List<EduTaskTorf> findByTaskId(String id) {
        return eduTaskTorfMapper.findByTaskId(id);
    }

    @Override
    public int updateTaskTorf(EduTaskTorf eduTaskTorf) {
        return eduTaskTorfMapper.updateTaskTorf(eduTaskTorf);
    }

    @Override
    public int deleteTaskTorf(String id) {
        return eduTaskTorfMapper.deleteTaskTorf(id);
    }
}
