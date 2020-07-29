package com.zlt.service;

import com.zlt.pojo.EduChapterdetail;

import java.util.List;

public interface ChapterDetailService {
    List<EduChapterdetail> findAllChapterDetail();
    EduChapterdetail findChapterDetailByChaptDeId(String chaptDeId);
    int updateChapterDetail(EduChapterdetail eduChapterdetail);
    int deleteChapterDetail(String chaptDeId);
    int addChapterDetail(EduChapterdetail eduChapterdetail);
}
