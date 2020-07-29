package com.zlt.mapper;



import com.zlt.pojo.EduPaperSingle;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface EduPaperSingleMapper {
    public List<EduPaperSingle> findAll();
    public EduPaperSingle findPaperSingleById(String id);
    public int addPaperSingle(EduPaperSingle paperSingle);
    public int deletePaperSingleById(String id);
    public int updatePaperSingle(EduPaperSingle paperSingle);
}
