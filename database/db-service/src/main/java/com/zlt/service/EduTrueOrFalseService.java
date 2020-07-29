package com.zlt.service;

import com.zlt.pojo.EduTrueOrFalse;

import java.util.List;

public interface EduTrueOrFalseService {
    public List<EduTrueOrFalse> selectAll();//查找所有题
    public EduTrueOrFalse selectById(String id);//试题id查找题目
    public int insertOne(EduTrueOrFalse sel);//插入一道题目
    public int deleteById(String id);//通过id删除试题
    public int updateTF(EduTrueOrFalse sel);//更改试题
}
