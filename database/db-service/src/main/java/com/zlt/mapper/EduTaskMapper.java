package com.zlt.mapper;

import com.zlt.pojo.EduTask;
import javafx.concurrent.Task;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EduTaskMapper {
    int addTask(EduTask eduTask);
    int updateTask(EduTask eduTask);
    int deleteTask(String id);
    EduTask findById(String id);
}
