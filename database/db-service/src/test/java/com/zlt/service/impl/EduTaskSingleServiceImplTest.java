package com.zlt.service.impl;

import com.zlt.pojo.EduTaskSingle;
import com.zlt.service.EduTaskSingleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EduTaskSingleServiceImplTest {
    @Autowired(required = false)
    private EduTaskSingleService eduTaskSingleService;
    @Test
    public void findEduTaskSingleById() {
        List<EduTaskSingle> eduTaskSingleList = eduTaskSingleService.findEduTaskSingleById("01");
    }
}