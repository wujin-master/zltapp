package com.zlt.service.impl;

import com.zlt.mapper.ChapterMapper;
import com.zlt.pojo.EduChapter;
import com.zlt.service.ChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChapterServiceImpl implements ChapterService {
    @Autowired(required = false)
    private ChapterMapper chapterMapper;


    @Override
    public List<EduChapter> findAllChapter() {
        return chapterMapper.findAllChapter();
    }

    @Override
    public EduChapter findChapterByChapterId(String chapterId) {
        return chapterMapper.findChapterByChapterId(chapterId);
    }

    @Override
    public int updateChapter(EduChapter eduChapter) {
        return chapterMapper.updateChapter(eduChapter);
    }

    @Override
    public int deleteChapter(String chapterId) {
        return chapterMapper.deleteChapter(chapterId);
    }

    @Override
    public int addChapter(EduChapter eduChapter) {
        return chapterMapper.addChapter(eduChapter);
    }
}
