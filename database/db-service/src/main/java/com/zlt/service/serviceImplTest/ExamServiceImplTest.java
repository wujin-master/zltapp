package com.zlt.service.serviceImplTest;

import com.zlt.pojo.EduExam;
import com.zlt.service.impl.ExamServiceImpl;
import com.zlt.utils.UUIDUtil;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ExamServiceImplTest {
    @Autowired(required = false)
    private ExamServiceImpl examService;


//    public void addUser(){
//        EduExam eduExam = new EduExam();
//        eduExam.setExamId(UUIDUtil.getUUID());
//        eduExam.setPaperId("111111");
//        eduExam.setCourseId("考试测试用");
//        int result = examService.addExam(eduExam);
//        Assert.assertEquals(1,result);
//    }

    @Test
    public  void findExamByid(){
        EduExam eduExam = examService.findExamByExamId("01");
       System.out.println(eduExam.getExamId());
    }




}
