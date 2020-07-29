package com.zlt.service.impl;

import com.zlt.mapper.EduPaperSingleMapper;
import com.zlt.pojo.EduPaperSingle;
import com.zlt.service.EduPaperSingleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EduPaperSingleServiceImpl implements EduPaperSingleService {
    @Autowired(required = false)
    EduPaperSingleMapper eduPaperSingleMapper;

    @Override
    public List<EduPaperSingle> findAll() {
        return eduPaperSingleMapper.findAll();
    }

    @Override
    public EduPaperSingle findPaperSingleById(String id) {
        return eduPaperSingleMapper.findPaperSingleById(id);
    }

    @Override
    public int addPaperSingle(EduPaperSingle paperSingle) {
        return eduPaperSingleMapper.addPaperSingle(paperSingle);
    }

    @Override
    public int deletePaperSingleById(String id) {
        return eduPaperSingleMapper.deletePaperSingleById(id);
    }

    @Override
    public int updatePaperSingle(EduPaperSingle paperSingle) {
        return eduPaperSingleMapper.updatePaperSingle(paperSingle);
    }
}
