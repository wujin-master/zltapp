package com.zlt.service;

import com.zlt.pojo.EduClassTask;

import java.util.List;

public interface EduClassTaskService {
    int addClassTask(EduClassTask eduClassTask);
    List<EduClassTask> findByClassId(String id);
    List<EduClassTask> findByTaskId(String id);
    int updateClassTask(EduClassTask eduClassTask);
    int deleteClassTask(String id);
}
