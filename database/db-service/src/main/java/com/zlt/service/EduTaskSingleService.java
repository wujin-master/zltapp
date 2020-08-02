package com.zlt.service;

import com.zlt.pojo.EduTaskSingle;

import java.util.List;

public interface EduTaskSingleService {
    public List<EduTaskSingle> findAll();
    public List<EduTaskSingle> findEduTaskSingleById(String id);
    public int addEduTaskSingle(EduTaskSingle taskSingle);
    public int deleteEduTaskSingleById(String id);
    public int updateEduTaskSingle(EduTaskSingle taskSingle);
}
