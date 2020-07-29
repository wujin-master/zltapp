package com.zlt.mapper;

import com.zlt.pojo.EduTask;
import javafx.concurrent.Task;

import java.util.List;

public interface EduTaskMapper {
    int addTask(EduTask eduTask);
    int updateTask(EduTask eduTask);
    int deleteTask(String id);
    List<EduTask> findById(String id);
}
