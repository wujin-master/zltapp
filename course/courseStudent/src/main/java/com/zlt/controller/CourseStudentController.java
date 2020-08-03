package com.zlt.controller;

import com.zlt.pojo.EduCourse;
import com.zlt.pojo.EduTeacherCourse;
import com.zlt.pojo.EduUser;
import com.zlt.pojo.EduUserCourse;
import com.zlt.service.EduCourseService;
import com.zlt.service.EduUserCourseService;
import com.zlt.service.TeacherCourseService;
import com.zlt.utils.Result;
import com.zlt.utils.ResultCode;
import com.zlt.utils.UUIDUtil;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//用户-课程表的增删查
@RestController
@RequestMapping("edu_usrCou")
public class CourseStudentController {

    private EduUserCourseService eduUserCourseService;
    //添加学生-课程
    @PostMapping("/addUserCourse")
    @ResponseBody
    public Result addUserCourse(@RequestBody EduUserCourse eduUserCourse){
        List<EduUserCourse> list1 = eduUserCourseService.findByUserId(eduUserCourse.getUserId());
        for(EduUserCourse eduUserCourse1:list1){
            if(eduUserCourse.getCourseId().equals(eduUserCourse1.getCourseId())){
                return Result.failure(ResultCode.ID_HAS_EXIST);//已存在相同关系
            }
        }
        eduUserCourse.setId(UUIDUtil.getUUID());
        eduUserCourseService.addUserCourse(eduUserCourse);
        return Result.success();
    }

    //更新学生-课程
    @PostMapping(value="/upDateUserCourse")
    @ResponseBody
    public Result upDateUserCourse(@RequestBody EduUserCourse eduUserCourse){
        EduUserCourse eduUserCourse1 = eduUserCourseService.findUserCourse(eduUserCourse.getUserId(),eduUserCourse.getCourseId());
        if(eduUserCourse1 != null){
            eduUserCourseService.updateUserCourse(eduUserCourse);
            return Result.success();
        }else {
            return Result.failure(ResultCode.PARAM_ERROR);
        }
    }


    //根据学生id查课表
    @RequestMapping(value="/findCoursesByUId",method={RequestMethod.GET})
    @ResponseBody
    public Result findCoursesByUId(String uid){
        return Result.success(eduUserCourseService.findByUserId(uid));
    }

    //根据课表id查学生
    @RequestMapping(value="/findUsersByCoId",method={RequestMethod.GET})
    @ResponseBody
    public Result findUsersByCoId(String cid){
        return Result.success(eduUserCourseService.findByCourseId(cid));
    }

    //根据学生id和课程id删除关系
    @PostMapping("/delUserCourse")
    @ResponseBody
    public Result delTeacherCourse(String uid,String cid){
        return  Result.success(eduUserCourseService.deleteUserCourse(uid,cid));
    }

}






