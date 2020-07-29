package com.zlt.mapper;

import com.zlt.pojo.EduPaper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PaperMapper {
    List<EduPaper> findAllPaper();
    EduPaper findPaperByPaperId(String paperId);
    int addPaper(EduPaper eduPaper);
    int updatePaper(EduPaper eduPaper);
    int deletePaper(String paperId);
}
