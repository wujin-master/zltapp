package com.zlt.service;

import com.zlt.pojo.EduSingleSel;

import java.util.List;

public interface EduSingleSelService {
    public List<EduSingleSel> selectAllSingle();//查找所有单选题
    public EduSingleSel selectSingleById(String id);//试题id查找题目
    public int insertOne(EduSingleSel sel);//插入一道题目
    public int deleteSingleById(String id);//通过id删除试题
    public int updateSingle(EduSingleSel sel);//更改试题
}
