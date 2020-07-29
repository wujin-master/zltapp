package com.zlt.service.impl;

import com.zlt.mapper.EduMultiSelMapper;
import com.zlt.pojo.EduMultiSel;
import com.zlt.service.EduMultiSelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EduMultiSelServiceImpl implements EduMultiSelService {
    @Autowired(required = false)
    EduMultiSelMapper multiSelMapper;
    @Override
    public List<EduMultiSel> selectAllMulti() {
        return multiSelMapper.selectAllMulti();
    }

    @Override
    public EduMultiSel selectMultiById(String id) {
        return multiSelMapper.selectMultiById(id);
    }

    @Override
    public int insertOne(EduMultiSel sel) {
        return multiSelMapper.insertOne(sel);
    }

    @Override
    public int deleteMultyiById(String id) {
        return multiSelMapper.deleteMultyiById(id);
    }

    @Override
    public int updateMulti(EduMultiSel sel) {
        return multiSelMapper.updateMulti(sel);
    }
}
