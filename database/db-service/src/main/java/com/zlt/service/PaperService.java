package com.zlt.service;

import com.zlt.pojo.EduPaper;

import java.util.List;

public interface PaperService {
    List<EduPaper> findAllPaper();
    EduPaper findPaperByPaperId(String paperId);
    int addPaper(EduPaper eduPaper);
    int updatePaper(EduPaper eduPaper);
    int deletePaper(String paperId);
}
