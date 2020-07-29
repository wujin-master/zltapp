package com.zlt.service.impl;

import com.zlt.pojo.EduCourse;
import com.zlt.service.EduCourseService;
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
public class EduCourseServiceImplTest {
    @Autowired(required = false)
    private EduCourseService eduCourseService;
    @Test
    public void findAll() {
        List<EduCourse> eduCourses = eduCourseService.findAll();
        Assert.assertNotNull(eduCourses);
    }

    @Test
    public void addCourse() {
        EduCourse eduCourse = new EduCourse();
        eduCourse.setCourseId("123456");
        eduCourse.setCourseName("中文");
        eduCourse.setCourseMaster("李老师");
        int result = eduCourseService.addCourse(eduCourse);
        Assert.assertEquals(1,result);
    }

    @Test
    public void findById() {
        EduCourse eduCourse= eduCourseService.findById("123456");
        Assert.assertNotNull(eduCourse);
    }

    @Test
    public void getCourseByNameMaster() {
        EduCourse eduCourse = eduCourseService.getCourseByNameMaster("java实训课","aaaa");
        Assert.assertNotNull(eduCourse);
    }

    @Test
    public void deleteCourse() {
        int result = eduCourseService.deleteCourse("123456");
        Assert.assertEquals(1,result);
    }

    @Test
    public void updateCourse() {
        EduCourse eduCourse = new EduCourse();
        eduCourse.setCourseId("123456");
        eduCourse.setCourseName("英文");
        int result = eduCourseService.updateCourse(eduCourse);
        Assert.assertEquals(2,result);
    }
}