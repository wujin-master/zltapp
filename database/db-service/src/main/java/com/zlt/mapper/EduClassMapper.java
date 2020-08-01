package com.zlt.mapper;

import com.zlt.pojo.EduClass;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EduClassMapper {
    int addClass(EduClass eduUser);
    List<EduClass> queryClasses();
    int deleteClass(String id);
    int updateClass(EduClass eduClass);
    EduClass findById(String id);
    int batchDelete(List<Integer> idList);
}
