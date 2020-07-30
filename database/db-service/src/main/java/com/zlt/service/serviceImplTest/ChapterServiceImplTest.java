//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.zlt.service.serviceImplTest;

import com.zlt.pojo.EduChapter;
import com.zlt.service.ChapterService;
import com.zlt.utils.UUIDUtil;
import java.sql.Timestamp;
import java.util.Date;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ChapterServiceImplTest {
    @Autowired(
            required = false
    )
    private ChapterService chapterService;

    public ChapterServiceImplTest() {
    }

    @Test
    public void all() {
        EduChapter eduChapter = new EduChapter();
        eduChapter.setChapterId(UUIDUtil.getUUID());
        eduChapter.setChapterName("test-sqf1");
        eduChapter.setCourseId("001");
        eduChapter.setCreateTime(new Timestamp((new Date()).getTime()));
        eduChapter.setUpdateTime(new Timestamp((new Date()).getTime()));
        this.chapterService.addChapter(eduChapter);
        System.out.println(this.chapterService.findAllChapter());
        EduChapter eduChapter1 = this.chapterService.findChapterByChapterId("23a14106251d46beb503f225b9fa7238");
        System.out.println(eduChapter1);
        eduChapter1.setChapterName("test-sqf2");
        System.out.println(this.chapterService.updateChapter(eduChapter1));
        System.out.println(this.chapterService.deleteChapter("e72fca8671ca415d917530a038985fac"));
    }
}
