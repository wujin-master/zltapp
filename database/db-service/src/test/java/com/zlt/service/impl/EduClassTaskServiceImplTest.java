package com.zlt.service.impl;

import com.zlt.pojo.EduClassTask;
import com.zlt.service.EduClassTaskService;
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
public class EduClassTaskServiceImplTest {
    @Autowired(required = false)
    private EduClassTaskService eduClassTaskService;

    @Test
    public void addClassTask() {
        EduClassTask eduClassTask = new EduClassTask();
        eduClassTask.setId("123456");
        eduClassTask.setClassId("01");
        eduClassTask.setTaskId("01");
        int result = eduClassTaskService.addClassTask(eduClassTask);
        Assert.assertEquals(1,result);
    }

    @Test
    public void findByClassId() {
        List<EduClassTask> eduClassTask = eduClassTaskService.findByClassId("01");
        Assert.assertNotNull(eduClassTask);
    }

    @Test
    public void findByTaskId() {
        List<EduClassTask> eduClassTask = eduClassTaskService.findByTaskId("01");
        Assert.assertNotNull(eduClassTask);
    }

    @Test
    public void updateClassTask() {
        EduClassTask eduClassTask = new EduClassTask();
        eduClassTask.setId("123456");
        eduClassTask.setClassId("01");
        eduClassTask.setTaskId("123456");
        int result = eduClassTaskService.updateClassTask(eduClassTask);
        Assert.assertEquals(1,result);
    }

    @Test
    public void deleteClassTask() {
        int result = eduClassTaskService.deleteClassTask("123456");
        Assert.assertEquals(1,result);
    }
}