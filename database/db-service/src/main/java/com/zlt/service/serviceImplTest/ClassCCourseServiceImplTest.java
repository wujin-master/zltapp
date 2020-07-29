//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.zlt.service.serviceImplTest;

import com.zlt.pojo.EduClasscourse;
import com.zlt.service.ClassCourseService;
import com.zlt.utils.UUIDUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ClassCCourseServiceImplTest {
    @Autowired(required = false )
    private ClassCourseService classCourseService;


    @Test
    public void all() {
        EduClasscourse eduClasscourse = new EduClasscourse();
        eduClasscourse.setClassId("01");
        eduClasscourse.setCourseId("001");
        eduClasscourse.setId(UUIDUtil.getUUID());
        this.classCourseService.addClassCourse(eduClasscourse);
        System.out.println(this.classCourseService.findAllClassCourse());
        eduClasscourse = this.classCourseService.findClassCourseById("e8497b26670146b8810fff6c8cde29b5");
        System.out.println(eduClasscourse);
        eduClasscourse.setClassId("02");
        System.out.println(this.classCourseService.updateClassCourse(eduClasscourse));
        System.out.println(this.classCourseService.deleteClassCourse("001"));
    }
}
