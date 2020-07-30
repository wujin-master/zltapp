package com.zlt.controller;

import com.zlt.pojo.EduTeacher;
import com.zlt.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("")
public class ProsenStudentComtroller {

    @Autowired(required=false)
    private TeacherService teacherService;

    @RequestMapping(value="/findAll",method={RequestMethod.GET})
    @ResponseBody
    public List<EduTeacher> queryUsers(){
        return teacherService.findAllTeacher();
    }

    @RequestMapping(value="/upDate",method={RequestMethod.GET})
    @ResponseBody
    public void upDateTeacher(){
        EduTeacher eduTeacher =  teacherService.findByTeacherId("01");
        System.out.println(eduTeacher.getTeacherMobile());
    }
}
