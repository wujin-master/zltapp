package com.zlt.service.impl;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.zlt.pojo.EduTeacherExam;
import com.zlt.service.EduTeacherExamService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class EduTeacherExamServiceImplTest {
    @Autowired(required = false)
    private EduTeacherExamService eduTeacherExamService;
    @Test
    public void addTeacherExam() {

    }

    @Test
    public void updateTeacherExam() {

    }

    @Test
    public void deleteTeacherExam() {

    }

    @Test
    public void findByTeacherId() {
        List<EduTeacherExam>  eduTeacherExamList = eduTeacherExamService.findByTeacherId("01");
        Assert.assertEquals(1,eduTeacherExamList.size());
    }
}