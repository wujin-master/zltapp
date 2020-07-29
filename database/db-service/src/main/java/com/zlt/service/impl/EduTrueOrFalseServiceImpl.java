package com.zlt.service.impl;

import com.zlt.mapper.EduTrueOrFalseMapper;
import com.zlt.pojo.EduTrueOrFalse;
import com.zlt.service.EduTrueOrFalseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EduTrueOrFalseServiceImpl implements EduTrueOrFalseService {

    @Autowired(required = false)
    EduTrueOrFalseMapper trueOrFalseMapper;
    @Override
    public List<EduTrueOrFalse> selectAll() {
        return trueOrFalseMapper.selectAll();
    }

    @Override
    public EduTrueOrFalse selectById(String id) {
        return trueOrFalseMapper.selectById(id);
    }

    @Override
    public int insertOne(EduTrueOrFalse sel) {
        return trueOrFalseMapper.insertOne(sel);
    }

    @Override
    public int deleteById(String id) {
        return trueOrFalseMapper.deleteById(id);
    }

    @Override
    public int updateTF(EduTrueOrFalse sel) {
        return trueOrFalseMapper.updateTF(sel);
    }
}
