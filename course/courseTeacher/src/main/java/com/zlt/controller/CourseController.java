package com.zlt.controller;
//课程表管理

import com.zlt.pojo.EduCourse;
import com.zlt.service.EduCourseService;
import com.zlt.utils.Result;
import com.zlt.utils.ResultCode;
import com.zlt.utils.UUIDUtil;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("edu_course")
public class CourseController {
    private EduCourseService eduCourseService;  //课程表管理

    //课程添加
    @PostMapping("/addCourse")
    @ResponseBody
    public Result addCourse(@RequestBody EduCourse eduCourse){
        eduCourse.setCourseId(UUIDUtil.getUUID());
        eduCourseService.addCourse(eduCourse);
        return Result.success();
    }


    //课程查找
    @PostMapping("/findCourse")
    @ResponseBody
    public Result findCourse(String eduCourseId){
        return Result.success(eduCourseService.findById(eduCourseId));
    }

    //课程修改
    @PostMapping(value="/updateCourse")
    @ResponseBody
    public Result upDateTeacher(@RequestBody EduCourse educourse){
        EduCourse eduTeacher =  eduCourseService.findById(educourse.getCourseId());
        //课程不存在
        if(eduTeacher == null ){
            return Result.failure(ResultCode.ID_HAS_EXIST);
        }else {
            //更新用户信息
            int result = eduCourseService.updateCourse(educourse);
            return Result.failure(ResultCode.SUCCESS);
        }
    }
}
