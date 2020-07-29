package com.zlt.service;

import com.zlt.pojo.EduMultiSel;

import java.util.List;

public interface EduMultiSelService {
    public List<EduMultiSel> selectAllMulti();//查找所有单选题
    public EduMultiSel selectMultiById(String id);//试题id查找题目
    public int insertOne(EduMultiSel sel);//插入一道题目
    public int deleteMultyiById(String id);//通过id删除试题
    public int updateMulti(EduMultiSel sel);//更改试题
}
