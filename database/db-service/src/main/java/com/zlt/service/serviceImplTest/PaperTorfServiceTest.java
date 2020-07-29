package com.zlt.service.serviceImplTest;

import com.zlt.mapper.PaperTorfMapper;
import com.zlt.pojo.EduPapertorf;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PaperTorfServiceTest {
    @Autowired(required = false)
    private PaperTorfMapper eduTeacher;

    @Test
    public  void update(){
        EduPapertorf eduExam = eduTeacher.findPaperTorfById("01");
        eduExam.setReserv1("测试用");
        int result = eduTeacher.updatePaperTorf(eduExam);

    }
}
