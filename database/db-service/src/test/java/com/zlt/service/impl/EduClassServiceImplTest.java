package com.zlt.service.impl;

import com.zlt.pojo.EduClass;
import com.zlt.service.EduClassService;
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
public class EduClassServiceImplTest {
    @Autowired(required = false)
    private EduClassService eduClassService;

    @Test
    public void addClass() {
        EduClass eduClass = new EduClass();
        eduClass.setClassId("1234567");
        int result = eduClassService.addClass(eduClass);
        Assert.assertEquals(1,result);
    }

    @Test
    public void queryClasses() {
        List<EduClass> eduClasses = eduClassService.queryClasses();
        Assert.assertNotNull(eduClasses);
    }

    @Test
    public void deleteClass() {
        int result = eduClassService.deleteClass("123456");
        Assert.assertEquals(1,result);
    }

    @Test
    public void updateClass() {
        EduClass eduClass = new EduClass();
        eduClass.setClassId("123456");
        eduClass.setClassName("软工1班");
        int result = eduClassService.updateClass(eduClass);
        Assert.assertEquals(1,result);
    }

    @Test
    public void findById() {
        int result = eduClassService.deleteClass("123456");
        Assert.assertEquals(1,result);
    }
}