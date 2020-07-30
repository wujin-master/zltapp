package com.zlt.mapper;

import com.zlt.pojo.EduTaskTorf;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EduTaskTorfMapper {
    int addTaskTorf(EduTaskTorf eduTaskTorf);
    List<EduTaskTorf> findByTorfId(String id);
    List<EduTaskTorf> findByTaskId(String id);
    int updateTaskTorf(EduTaskTorf eduTaskTorf);
    int deleteTaskTorf(String id);
}
