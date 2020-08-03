package com.zlt.service.impl;

import com.zlt.mapper.ClassMapper;
import com.zlt.pojo.EduClass;
import com.zlt.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassServiceImpl implements ClassService {
    @Autowired(required = false)
    private ClassMapper classMapper;

    @Override
    public List<EduClass> findAllClass() {
        return classMapper.findAllClass();
    }

    @Override
    public EduClass findClassByClassId(String classId) {
        return classMapper.findClassByClassId(classId);
    }

    @Override
    public int addClass(EduClass eduClass) {
        return classMapper.addClass(eduClass);
    }

    @Override
    public int updateClass(EduClass eduClass) {
        return classMapper.updateClass(eduClass);
    }

    @Override
    public int deleteClass(String classId) {
        return classMapper.deleteClass(classId);
    }
}
