package com.zlt.mapper;

import com.zlt.pojo.EduChapter;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ChapterMapper {
    List<EduChapter> findAllChapter();
    EduChapter findChapterByChapterId(String chapterId);
    int updateChapter(EduChapter eduChapter);
    int deleteChapter(String chapterId);
    int addChapter(EduChapter eduChapter);
}
