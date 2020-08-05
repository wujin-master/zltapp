package com.zlt.controller;
//教师-课程表的增删查


import com.zlt.pojo.EduTeacherCourse;
import com.zlt.service.TeacherCourseService;
import com.zlt.utils.Result;
import com.zlt.utils.ResultCode;
import com.zlt.utils.UUIDUtil;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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
    public Result findCoursesByTeId(String tid){
        return Result.success(teacherCourseService.findByTeacherId(tid));
    }

    //根据课表id查教师
    @RequestMapping(value="/findTeachersByCoId",method={RequestMethod.GET})
    @ResponseBody
    public Result findTeachersByCoId(String cid){
        return Result.success(teacherCourseService.findByCourseId(cid));
    }

    //根据教师id和课程id删除关系
    @PostMapping("/delTeacherCourse")
    @ResponseBody
    public Result delTeacherCourse(String tid,String cid){
            return Result.success(teacherCourseService.deleteTeacherCourse(tid,cid));
    }

    //添加课程到班级
    @PostMapping("/addCouToCla")
    @ResponseBody
    public Result addCouToClas(@RequestBody Map<String,Object> map){
        String classId = map.get("classId").toString();
        List<Integer> courseIdList = (List<Integer>) map.get("courseIdList");
        for(Integer courseId:courseIdList){

        }
        return Result.success();
    }

}
