package com.zlt.service.impl;

import com.zlt.mapper.EduSingleSelMapper;
import com.zlt.pojo.EduSingleSel;
import com.zlt.service.EduSingleSelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EduSingleSelServiceImpl implements EduSingleSelService {
    @Autowired(required = false)
    EduSingleSelMapper selMapper;

    @Override
    public List<EduSingleSel> selectAllSingle() {
        return selMapper.selectAllSingle();
    }

    @Override
    public EduSingleSel selectSingleById(String id) {
        return selMapper.selectSingleById(id);
    }

    @Override
    public int insertOne(EduSingleSel sel) {
        return selMapper.insertOne(sel);
    }

    @Override
    public int deleteSingleById(String id) {
        return selMapper.deleteSingleById(id);
    }

    @Override
    public int updateSingle(EduSingleSel sel) {
        return selMapper.updateSingle(sel);
    }
}
