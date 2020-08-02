package com.zlt.service.impl;

import com.zlt.pojo.EduUserTask;
import com.zlt.service.EduUserTaskService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EduUserTaskServiceImplTest {
    @Autowired(required = false)
    private EduUserTaskService eduUserTaskService;
    @Test
    public void findByUITI() {
        EduUserTask eduUserTask1 = eduUserTaskService.findByUITI("94f6846df78548d48d0325babe5b1d02","01");
        System.out.println(eduUserTask1.getId());
    }
}