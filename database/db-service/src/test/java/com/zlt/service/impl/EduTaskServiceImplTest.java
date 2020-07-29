package com.zlt.service.impl;

import com.zlt.pojo.EduTask;
import com.zlt.service.EduTaskService;
import com.zlt.utils.UUIDUtil;
import javafx.concurrent.Task;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class EduTaskServiceImplTest {
    @Autowired(required = false)
    private EduTaskService eduTaskService;

    @Test
    public void addTask() {
        EduTask eduTask = new EduTask();
        eduTask.setTaskId("123456");
        int result = eduTaskService.addTask(eduTask);
        Assert.assertEquals(1,result);
    }

    @Test
    public void updateTask() {
        EduTask eduTask = new EduTask();
        eduTask.setTaskId("123456");
        eduTask.setTaskName("汉语");
        int result = eduTaskService.updateTask(eduTask);
        Assert.assertEquals(1,result);
    }

    @Test
    public void deleteTask() {
        int result = eduTaskService.deleteTask("123456");
        Assert.assertEquals(1,result);
    }

    @Test
    public void findById() {
        EduTask eduTask = eduTaskService.findById("123456");
        Assert.assertNotNull(eduTask);
    }
}