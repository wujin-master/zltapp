package com.zlt.mapper;

import com.zlt.pojo.EduPapertorf;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PaperTorfMapper {
    List<EduPapertorf> findAllPaperTorf();
    EduPapertorf findPaperTorfById(String id);
    int addPaperTorf(EduPapertorf eduPapertorf);
    int updatePaperTorf(EduPapertorf eduPapertorf);
    int deletePaperTorf(String id);
}
