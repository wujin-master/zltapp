package com.zlt.service;

import com.zlt.pojo.EduTaskMulti;

import java.util.List;

public interface EduTaskMultiService {
    int addTaskMulti(EduTaskMulti eduTaskMulti);
    List<EduTaskMulti> findByMultiId(String id);
    List<EduTaskMulti> findByTaskId(String id);
    int updateTaskMulti(EduTaskMulti eduTaskMulti);
    int deleteTaskMulti(String id);
}
