package com.zlt.service.impl;

import com.zlt.mapper.PaperMapper;
import com.zlt.pojo.EduPaper;
import com.zlt.service.PaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaperServiceImpl implements PaperService {
    @Autowired
    private PaperMapper paperMapper;

    @Override
    public List<EduPaper> findAllPaper() {
        return paperMapper.findAllPaper();
    }

    @Override
    public EduPaper findPaperByPaperId(String paperId) {
        return paperMapper.findPaperByPaperId(paperId);
    }

    @Override
    public int addPaper(EduPaper eduPaper) {
        return paperMapper.addPaper(eduPaper);
    }

    @Override
    public int updatePaper(EduPaper eduPaper) {
        return paperMapper.updatePaper(eduPaper);
    }

    @Override
    public int deletePaper(String paperId) {
        return paperMapper.deletePaper(paperId);
    }
}
