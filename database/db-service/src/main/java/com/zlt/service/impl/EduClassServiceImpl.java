package com.zlt.service.impl;

import com.zlt.mapper.EduClassMapper;
import com.zlt.pojo.EduClass;
import com.zlt.service.EduClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EduClassServiceImpl implements EduClassService {
    @Autowired(required = false)
    private EduClassMapper eduClassMapper;
    @Override
    public int addClass(EduClass eduClass) {
        return eduClassMapper.addClass(eduClass);
    }

    @Override
    public List<EduClass> queryClasses() {
        return eduClassMapper.queryClasses();
    }

    @Override
    public int deleteClass(String id) {
        return eduClassMapper.deleteClass(id);
    }

    @Override
    public int updateClass(EduClass eduClass) {
        return eduClassMapper.updateClass(eduClass);
    }

    @Override
    public EduClass findById(String id) {
        return null;
    }

    @Override
    public int batchDelete(List<Integer> idList) {
        return eduClassMapper.batchDelete(idList);
    }
}
