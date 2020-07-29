package com.zlt.service;

import com.zlt.pojo.EduTask;

import java.util.List;

public interface EduTaskService {
    int addTask(EduTask eduTask);
    int updateTask(EduTask eduTask);
    int deleteTask(String id);
    List<EduTask> findById(String id);
}
