package com.zlt.service.serviceImplTest;

import com.zlt.mapper.PaperMapper;
import com.zlt.pojo.EduPaper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PaperServiceTest {
    @Autowired(required = false)
    private PaperMapper eduTeacher;

    @Test
    public  void update(){
        EduPaper eduExam = eduTeacher.findPaperByPaperId("01");
        eduExam.setReserve1("测试用");
        int result = eduTeacher.updatePaper(eduExam);

    }
}
