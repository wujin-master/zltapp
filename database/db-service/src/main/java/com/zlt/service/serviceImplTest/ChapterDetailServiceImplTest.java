package com.zlt.service.serviceImplTest;

import com.zlt.pojo.EduChapterdetail;
import com.zlt.service.ChapterDetailService;
import com.zlt.utils.UUIDUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ChapterDetailServiceImplTest {
    @Autowired(
            required = false
    )
    private ChapterDetailService chapterDetailService;

    public ChapterDetailServiceImplTest() {
    }

    @Test
    public void add() {
        EduChapterdetail chapterdetail = new EduChapterdetail();
        chapterdetail.setChaptDeId(UUIDUtil.getUUID());
        chapterdetail.setChaptDeName("test-sqf");
        chapterdetail.setChaptDeUrl("www.shiqifan.com");
        chapterdetail.setChapterId("01");
        int result = this.chapterDetailService.addChapterDetail(chapterdetail);
        System.out.println(result);
    }

    @Test
    public void selectAll() {
        System.out.println(this.chapterDetailService.findAllChapterDetail());
    }

    @Test
    public void all() {
        EduChapterdetail eduChapterdetail = this.chapterDetailService.findChapterDetailByChaptDeId("01");
        System.out.println(eduChapterdetail);
        eduChapterdetail.setChaptDeName("111");
        System.out.println(this.chapterDetailService.updateChapterDetail(eduChapterdetail));
        System.out.println(this.chapterDetailService.deleteChapterDetail("01"));
    }
}
