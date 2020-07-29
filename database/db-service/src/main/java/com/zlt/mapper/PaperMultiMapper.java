package com.zlt.mapper;

import com.zlt.pojo.EduPapermulti;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PaperMultiMapper {
    List<EduPapermulti> findAllPaperMulti();
    EduPapermulti findPaperMultiById(String id);
    int addPaperMulti(EduPapermulti eduPapermulti);
    int updatePaperMulti(EduPapermulti eduPapermulti);
    int deletePaperMulti(String id);
}
