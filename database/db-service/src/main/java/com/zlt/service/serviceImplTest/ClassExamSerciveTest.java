package com.zlt.service.serviceImplTest;

import com.zlt.mapper.ClassExamMapper;
import com.zlt.pojo.EduClassExam;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ClassExamSerciveTest {

    @Autowired(required = false)
    private ClassExamMapper eduTeacher;
//    @Test
//    public  void findExamByid(){
//        EduClassExam eduExam = eduTeacher.findClassExamById("01");
//        System.out.println(eduExam.getClassId());
//    }

    @Test
    public  void update(){
        EduClassExam eduExam = eduTeacher.findClassExamById("01");
        eduExam.setReverse1("测试用");
        int result = eduTeacher.updateClassExam(eduExam);

    }
}
