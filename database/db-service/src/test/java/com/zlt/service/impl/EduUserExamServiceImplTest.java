package com.zlt.service.impl;

import com.zlt.pojo.EduUser;
import com.zlt.pojo.EduUserExam;
import com.zlt.service.EduUserExamService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EduUserExamServiceImplTest {
    @Autowired(required = false)
    private EduUserExamService eduUserExamService;
    @Test
    public void findExamByUserId() {
        List<EduUserExam> eduUserExamList = eduUserExamService.findExamByUserId("aaaa");
        Assert.assertNotNull(eduUserExamList);
    }

    @Test
    public void findUserByExamId() {
        List<EduUserExam> eduUserExamList = eduUserExamService.findUserByExamId("01");
        Assert.assertNotNull(eduUserExamList);
    }

    @Test
    public void addUserExam() {
        EduUserExam eduUserExam = new EduUserExam();
        eduUserExam.setId("123456789");
        eduUserExam.setUserId("aaaa");
        eduUserExam.setExamId("01");
        int result = eduUserExamService.addUserExam(eduUserExam);
    }

    @Test
    public void delUserExam() {
    }

    @Test
    public void updUserExam() {
    }
}