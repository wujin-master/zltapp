package com.zlt.service.impl;

import com.zlt.mapper.PaperTorfMapper;
import com.zlt.pojo.EduPapertorf;
import com.zlt.service.PaperTorfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaperTorfServiceImpl implements PaperTorfService {
    @Autowired(required = false)
    PaperTorfMapper paperTorfMapper;

    @Override
    public List<EduPapertorf> findAllPaperTorf() {
        return paperTorfMapper.findAllPaperTorf();
    }

    @Override
    public EduPapertorf findPaperTorfById(String id) {
        return paperTorfMapper.findPaperTorfById(id);
    }

    @Override
    public int addPaperTorf(EduPapertorf eduPapertorf) {
        return paperTorfMapper.addPaperTorf(eduPapertorf);
    }

    @Override
    public int updatePaperTorf(EduPapertorf eduPapertorf) {
        return paperTorfMapper.updatePaperTorf(eduPapertorf);
    }

    @Override
    public int deletePaperTorf(String id) {
        return paperTorfMapper.deletePaperTorf(id);
    }
}
