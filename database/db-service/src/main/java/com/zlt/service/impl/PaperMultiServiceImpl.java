package com.zlt.service.impl;

import com.zlt.mapper.PaperMultiMapper;
import com.zlt.pojo.EduPapermulti;
import com.zlt.service.PaperMultiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaperMultiServiceImpl implements PaperMultiService {
    @Autowired(required = false)
    private PaperMultiMapper paperMultiMapper;

    @Override
    public List<EduPapermulti> findAllPaperMulti() {
        return paperMultiMapper.findAllPaperMulti();
    }

    @Override
    public EduPapermulti findPaperMultiById(String id) {
        return paperMultiMapper.findPaperMultiById(id);
    }

    @Override
    public int addPaperMulti(EduPapermulti eduPapermulti) {
        return paperMultiMapper.addPaperMulti(eduPapermulti);
    }

    @Override
    public int updatePaperMulti(EduPapermulti eduPapermulti) {
        return paperMultiMapper.updatePaperMulti(eduPapermulti);
    }

    @Override
    public int deletePaperMulti(String id) {
        return paperMultiMapper.deletePaperMulti(id);
    }
}
