package com.zlt.service.impl;

import com.zlt.pojo.EduTaskSingle;
import com.zlt.service.EduTaskSingleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EduTaskSingleServiceImpl implements EduTaskSingleService {
    @Autowired(required = false)
    EduTaskSingleService taskSingleService;

    @Override
    public List<EduTaskSingle> findAll() {
        return taskSingleService.findAll();
    }

    @Override
    public EduTaskSingle findEduTaskSingleById(String id) {
        return taskSingleService.findEduTaskSingleById(id);
    }

    @Override
    public int addEduTaskSingle(EduTaskSingle taskSingle) {
        return taskSingleService.addEduTaskSingle(taskSingle);
    }

    @Override
    public int deleteEduTaskSingleById(String id) {
        return taskSingleService.deleteEduTaskSingleById(id);
    }

    @Override
    public int updateEduTaskSingle(EduTaskSingle taskSingle) {
        return taskSingleService.updateEduTaskSingle(taskSingle);
    }
}
