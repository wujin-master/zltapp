package com.zlt.mapper;

import com.zlt.pojo.EduTaskTorf;

import java.util.List;

public interface EduTaskTorfMapper {
    int addTaskTorf(EduTaskTorf eduTaskTorf);
    List<EduTaskTorf> findByTorfId(String id);
    List<EduTaskTorf> findByTaskId(String id);
    int updateTaskTorf(EduTaskTorf eduTaskTorf);
    int deleteTaskTorf(String id);
}
