package com.zlt.service.impl;

import com.zlt.mapper.EduTaskSingleMapper;
import com.zlt.pojo.EduTaskSingle;
import com.zlt.service.EduTaskSingleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EduTaskSingleServiceImpl implements EduTaskSingleService {
    @Autowired(required = false)
    EduTaskSingleMapper eduTaskSingleMapper;

    @Override
    public List<EduTaskSingle> findAll() {
        return eduTaskSingleMapper.findAll();
    }

    @Override
    public List<EduTaskSingle> findEduTaskSingleById(String id) {
        return eduTaskSingleMapper.findEduTaskSingleById(id);
    }

    @Override
    public int addEduTaskSingle(EduTaskSingle taskSingle) {
        return eduTaskSingleMapper.addEduTaskSingle(taskSingle);
    }

    @Override
    public int deleteEduTaskSingleById(String id) {
        return eduTaskSingleMapper.deleteEduTaskSingleById(id);
    }

    @Override
    public int updateEduTaskSingle(EduTaskSingle taskSingle) {
        return eduTaskSingleMapper.updateEduTaskSingle(taskSingle);
    }
}
