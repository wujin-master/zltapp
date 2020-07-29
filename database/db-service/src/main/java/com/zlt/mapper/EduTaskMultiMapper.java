package com.zlt.mapper;

import com.zlt.pojo.EduTaskMulti;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EduTaskMultiMapper {
    int addTaskMulti(EduTaskMulti eduTaskMulti);
    List<EduTaskMulti> findByMultiId(String id);
    List<EduTaskMulti> findByTaskId(String id);
    int updateTaskMulti(EduTaskMulti eduTaskMulti);
    int deleteTaskMulti(String id);
}
