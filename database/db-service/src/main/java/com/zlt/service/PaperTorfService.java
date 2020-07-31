package com.zlt.service;

import com.zlt.pojo.EduPapertorf;

import java.util.List;

public interface PaperTorfService {

    List<EduPapertorf> findAllPaperTorf();
    List<EduPapertorf> findPaperTorfById(String id);
    int addPaperTorf(EduPapertorf eduPapertorf);
    int updatePaperTorf(EduPapertorf eduPapertorf);
    int deletePaperTorf(String id);
}
