package com.zlt.service.impl;

import com.zlt.mapper.ChapterDetailMapper;
import com.zlt.pojo.EduChapterdetail;
import com.zlt.service.ChapterDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChapterDetailServiceImpl implements ChapterDetailService {
    @Autowired(required = false)
    private ChapterDetailMapper chapterDetailMapper;

    @Override
    public List<EduChapterdetail> findAllChapterDetail() {
        return chapterDetailMapper.findAllChapterDetail();
    }

    @Override
    public EduChapterdetail findChapterDetailByChaptDeId(String chaptDeId) {
        return chapterDetailMapper.findChapterDetailByChaptDeId(chaptDeId);
    }

    @Override
    public int updateChapterDetail(EduChapterdetail eduChapterdetail) {
        return chapterDetailMapper.updateChapterDetail(eduChapterdetail);
    }

    @Override
    public int deleteChapterDetail(String chaptDeId) {
        return chapterDetailMapper.deleteChapterDetail(chaptDeId);
    }

    @Override
    public int addChapterDetail(EduChapterdetail eduChapterdetail) {
        return chapterDetailMapper.addChapterDetail(eduChapterdetail);
    }
}
