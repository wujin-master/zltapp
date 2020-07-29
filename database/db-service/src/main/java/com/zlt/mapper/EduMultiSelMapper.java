package com.zlt.mapper;

import com.zlt.pojo.EduMultiSel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EduMultiSelMapper {
    public List<EduMultiSel> selectAllMulti();//查找所有题
    public EduMultiSel selectMultiById(String id);//试题id查找题目
    public int insertOne(EduMultiSel sel);//插入一道题目
    public int deleteMultyiById(String id);//通过id删除试题
    public int updateMulti(EduMultiSel sel);//更改试题
}
