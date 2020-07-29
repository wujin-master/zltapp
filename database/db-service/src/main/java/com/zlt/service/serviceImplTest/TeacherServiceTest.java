package com.zlt.service.serviceImplTest;


import com.zlt.pojo.EduTeacher;
import com.zlt.service.TeacherService;
import com.zlt.utils.UUIDUtil;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TeacherServiceTest {
    @Autowired(required = false)
    private TeacherService eduTeacher;

//    @Test
//    public void addUser(){
//        EduTeacher eduExam = new EduTeacher();
//        eduExam.setExamId(UUIDUtil.getUUID());
//        eduExam.setPaperId("111111");
//        eduExam.setCourseId("教师测试用");
//        int result = examService.addExam(eduExam);
//        Assert.assertEquals(1,result);
//    }

//    @Test
//    public  void findExamByid(){
//        EduTeacher eduExam = EduTeacher.findByTeacherId("01");
//        System.out.println(eduExam.getTeacherEmail());
//    }

//    @Test
//    public  void update(){
//        EduTeacher eduExam = eduTeacher.findByTeacherId("01");
//        eduExam.setTeacherNickname("测试用");
//    }
}
