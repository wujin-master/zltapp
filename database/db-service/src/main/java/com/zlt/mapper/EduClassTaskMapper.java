package com.zlt.mapper;

import com.zlt.pojo.EduClassTask;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EduClassTaskMapper {
    int addClassTask(EduClassTask eduClassTask);
    List<EduClassTask> findByClassId(String id);
    List<EduClassTask> findByTaskId(String id);
    int updateClassTask(EduClassTask eduClassTask);
    int deleteClassTask(String id);
}
