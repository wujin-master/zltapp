package com.zlt.service.impl;

import com.zlt.pojo.EduTaskMulti;
import com.zlt.service.EduTaskMultiService;
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
public class EduTaskMultiServiceImplTest {
    @Autowired(required = false)
    private EduTaskMultiService eduTaskMultiService;
    @Test
    public void addTaskMulti() {
        EduTaskMulti eduTaskMulti = new EduTaskMulti();
        eduTaskMulti.setId("123456");
        eduTaskMulti.setTaskId("01");
        eduTaskMulti.setMultiId("01");
        int result = eduTaskMultiService.addTaskMulti(eduTaskMulti);
        Assert.assertEquals(1,result);
    }

    @Test
    public void findByMultiId() {
        List<EduTaskMulti> eduTaskMultis = eduTaskMultiService.findByMultiId("01");
        Assert.assertNotNull(eduTaskMultis);
    }

    @Test
    public void findByTaskId() {
        List<EduTaskMulti> eduTaskMultis = eduTaskMultiService.findByTaskId("01");
        Assert.assertNotNull(eduTaskMultis);
    }

    @Test
    public void updateTaskMulti() {
        EduTaskMulti eduTaskMulti = new EduTaskMulti();
        eduTaskMulti.setId("123456");
        eduTaskMulti.setTaskId("123456");
        eduTaskMulti.setMultiId("01");
        int result = eduTaskMultiService.updateTaskMulti(eduTaskMulti);
        Assert.assertEquals(1,result);
    }

    @Test
    public void deleteTaskMulti() {
        int result = eduTaskMultiService.deleteTaskMulti("123456");
        Assert.assertEquals(1,result);
    }
}