package com.zlt.service;

import com.zlt.pojo.EduChapter;

import java.util.List;

public interface ChapterService {
    List<EduChapter> findAllChapter();
    EduChapter findChapterByChapterId(String chapterId);
    int updateChapter(EduChapter eduChapter);
    int deleteChapter(String chapterId);
    int addChapter(EduChapter eduChapter);
}
