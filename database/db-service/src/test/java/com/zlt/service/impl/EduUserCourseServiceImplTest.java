package com.zlt.service.impl;

import com.zlt.pojo.EduUserCourse;
import com.zlt.service.EduUserCourseService;
import com.zlt.service.EduUserService;
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
public class EduUserCourseServiceImplTest {

    @Autowired(required = false)
    private EduUserCourseService eduUserCourseService;
    @Test
    public void addUserCourse() {
        EduUserCourse eduUserCourse = new EduUserCourse();
        eduUserCourse.setId("123456");
        eduUserCourse.setUserId("2746b44ad1cf4f6db3fc87ff8626fdf9");
        eduUserCourse.setCourseId("123456");
        int result = eduUserCourseService.addUserCourse(eduUserCourse);
        Assert.assertEquals(1,result);
    }

    @Test
    public void findByUserId() {
        List<EduUserCourse> eduUserCourse = eduUserCourseService.findByUserId("2746b44ad1cf4f6db3fc87ff8626fdf9");
        Assert.assertNotNull(eduUserCourse);
    }

    @Test
    public void findByCourseId() {
        List<EduUserCourse> eduUserCourse = eduUserCourseService.findByCourseId("123456");
        Assert.assertNotNull(eduUserCourse);
    }

    @Test
    public void updateUserCourse() {
        EduUserCourse eduUserCourse = new EduUserCourse();
        eduUserCourse.setId("123456");
        eduUserCourse.setUserId("8b669bf80e8b4924a6994fdbc3e95b0d");
        int result = eduUserCourseService.updateUserCourse(eduUserCourse);
        Assert.assertEquals(1,result);
    }

    @Test
    public void deleteUserCourse() {
        int result = eduUserCourseService.deleteUserCourse("123456");
        Assert.assertEquals(1,result);
    }
}