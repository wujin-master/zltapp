package com.zlt.controller;
//教师-课程表的增删查


import com.zlt.pojo.EduTeacherCourse;
import com.zlt.service.TeacherCourseService;
import com.zlt.utils.Result;
import com.zlt.utils.ResultCode;
import com.zlt.utils.UUIDUtil;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("edu_teacherCourse")
public class CourseTeacherController {
    TeacherCourseService teacherCourseService;

    //添加教师-课程
    @PostMapping("/addTeacherCourse")
    @ResponseBody
    public Result addCourse(@RequestBody EduTeacherCourse eduTeacherCourse){
        List<EduTeacherCourse> list1 = teacherCourseService.findByTeacherId(eduTeacherCourse.getTeacherId());
        for(EduTeacherCourse eduTeacherCourse1:list1){
            if(eduTeacherCourse.getCourseId().equals(eduTeacherCourse1.getCourseId())){
                return Result.failure(ResultCode.ID_HAS_EXIST);//已存在相同关系
            }
        }
        eduTeacherCourse.setId(UUIDUtil.getUUID());
        teacherCourseService.addTeacherCourse(eduTeacherCourse);
        return Result.success();
    }



    //根据教师id查课表
    @RequestMapping(value="/findCoursesByTeId",method={RequestMethod.GET})
    @ResponseBody
    public List<EduTeacherCourse> findCoursesByTeId(String tid){
        return teacherCourseService.findByTeacherId(tid);
    }

    //根据课表id查教师
    @RequestMapping(value="/findTeachersByCoId",method={RequestMethod.GET})
    @ResponseBody
    public List<EduTeacherCourse> findTeachersByCoId(String cid){
        return teacherCourseService.findByCourseId(cid);
    }

    //根据教师id和课程id删除关系
    @PostMapping("/delTeacherCourse")
    @ResponseBody
    public int delTeacherCourse(String tid,String cid){
            return teacherCourseService.deleteTeacherCourse(tid,cid);
    }

}
