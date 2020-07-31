package com.zlt.service;

import com.zlt.pojo.EduPaperSingle;

import java.util.List;

public interface EduPaperSingleService {
    public List<EduPaperSingle> findAll();
    public List<EduPaperSingle> findPaperSingleById(String id);
    public int addPaperSingle(EduPaperSingle paperSingle);
    public int deletePaperSingleById(String id);
    public int updatePaperSingle(EduPaperSingle paperSingle);
}
