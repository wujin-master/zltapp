package com.zlt.service.impl;

import com.zlt.pojo.EduTaskTorf;
import com.zlt.service.EduTaskTorfService;
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
public class EduTaskTorfServiceImplTest {
    @Autowired(required = false)
    private EduTaskTorfService eduTaskTorfService;
    @Test
    public void addTaskTorf() {
        EduTaskTorf eduTaskTorf = new EduTaskTorf();
        eduTaskTorf.setId("123456");
        eduTaskTorf.setTaskId("01");
        eduTaskTorf.setTorfId("01");
        int result = eduTaskTorfService.addTaskTorf(eduTaskTorf);
        Assert.assertEquals(1,result);
    }

    @Test
    public void findByTorfId() {
        List<EduTaskTorf> eduTaskTorfList = eduTaskTorfService.findByTorfId("01");
        Assert.assertNotNull(eduTaskTorfList);
    }

    @Test
    public void findByTaskId() {
        List<EduTaskTorf> eduTaskTorfList = eduTaskTorfService.findByTaskId("01");
        Assert.assertNotNull(eduTaskTorfList);
    }

    @Test
    public void updateTaskTorf() {
        EduTaskTorf eduTaskTorf = new EduTaskTorf();
        eduTaskTorf.setId("123456");
        eduTaskTorf.setTaskId("123456");
        int result = eduTaskTorfService.updateTaskTorf(eduTaskTorf);
        Assert.assertEquals(1,result);
    }

    @Test
    public void deleteTaskTorf() {
        int result = eduTaskTorfService.deleteTaskTorf("123456");
        Assert.assertEquals(1,result);
    }
}