package com.zlt.mapper;


import com.zlt.pojo.EduTaskSingle;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface EduTaskSingleMapper {
    public List<EduTaskSingle> findAll();
    public List<EduTaskSingle> findEduTaskSingleById(String id);
    public int addEduTaskSingle(EduTaskSingle taskSingle);
    public int deleteEduTaskSingleById(String id);
    public int updateEduTaskSingle(EduTaskSingle taskSingle);
}
