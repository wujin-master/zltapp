package com.zlt.mapper;

import com.zlt.pojo.EduChapterdetail;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ChapterDetailMapper {
    List<EduChapterdetail> findAllChapterDetail();
    EduChapterdetail findChapterDetailByChaptDeId(String chaptDeId);
    int addChapterDetail(EduChapterdetail eduChapterdetail);
    int updateChapterDetail(EduChapterdetail eduChapterdetail);
    int deleteChapterDetail(String chaptDeId);
}
