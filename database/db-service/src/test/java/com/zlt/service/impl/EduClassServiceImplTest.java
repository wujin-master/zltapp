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

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
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
    @Test
    public void Test(){
        Date day=new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String days = "2020-07-31 11:36:07.536";
        System.out.println(day);
        //System.out.println(df.format(day).compareTo(df.format(days)));
    }
}