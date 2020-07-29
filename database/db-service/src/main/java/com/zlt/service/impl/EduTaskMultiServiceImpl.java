package com.zlt.service.impl;

import com.zlt.mapper.EduTaskMapper;
import com.zlt.mapper.EduTaskMultiMapper;
import com.zlt.pojo.EduTaskMulti;
import com.zlt.service.EduTaskMultiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EduTaskMultiServiceImpl implements EduTaskMultiService {
    @Autowired(required = false)
    private EduTaskMultiMapper eduTaskMultiMapper;
    @Override
    public int addTaskMulti(EduTaskMulti eduTaskMulti) {
        return eduTaskMultiMapper.addTaskMulti(eduTaskMulti);
    }

    @Override
    public List<EduTaskMulti> findByMultiId(String id) {
        return eduTaskMultiMapper.findByMultiId(id);
    }

    @Override
    public List<EduTaskMulti> findByTaskId(String id) {
        return eduTaskMultiMapper.findByTaskId(id);
    }

    @Override
    public int updateTaskMulti(EduTaskMulti eduTaskMulti) {
        return eduTaskMultiMapper.updateTaskMulti(eduTaskMulti);
    }

    @Override
    public int deleteTaskMulti(String id) {
        return eduTaskMultiMapper.deleteTaskMulti(id);
    }
}
