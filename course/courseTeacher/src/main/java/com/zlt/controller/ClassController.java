package com.zlt.controller;

import com.zlt.pojo.EduClass;
import com.zlt.pojo.EduClasscourse;
import com.zlt.service.ClassCourseService;
import com.zlt.service.ClassService;
import com.zlt.utils.Result;
import com.zlt.utils.ResultCode;
import com.zlt.utils.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("edu_class")
//教师的班级管理
public class ClassController {
    @Autowired
    private ClassService classService;  //班级表管理
    private ClassCourseService classCourseService; //班级课程表管理

    //添加班级
    @PostMapping("/addClass")
    @ResponseBody
    public Result addCourse(String  className){
        EduClass eduClass = new EduClass();
        eduClass.setClassName(className);
        eduClass.setClassId(UUIDUtil.getUUID());
        classService.addClass(eduClass);
        return Result.success();
    }
    //删除
    @PostMapping("/delClass")
    @ResponseBody
    public Result delClass(String cid){
        return Result.success(classService.deleteClass(cid));
    }

    //根据班级id获取全部课程
    @GetMapping("/findAllCourseByClassId")
    public Result findAllCourseByClassId(String cid ){
        List<EduClasscourse> eduClasscourses =  classCourseService.findAllCourseByClassId(cid);
        return Result.success(eduClasscourses);
    }


    //给班级添加课程
    @PostMapping("/addClassCourse")
    @ResponseBody
    public Result addCourse(@RequestBody EduClasscourse eduClasscourse){
        eduClasscourse.setCourseId(UUIDUtil.getUUID());
        classCourseService.addClassCourse(eduClasscourse);
        return Result.success();
    }

    //展示所有班级
    @GetMapping("/findAllClass")
    public Result findAllClass(){
        List<EduClass> eduClasses =  classService.findAllClass();
        return Result.success(eduClasses);
    }





}
