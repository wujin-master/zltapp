package com.zlt.controller;

import com.zlt.pojo.*;
import com.zlt.service.*;
import com.zlt.utils.Result;
import com.zlt.utils.ResultCode;
import com.zlt.utils.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("taskTeacher")
public class TaskTeacherController {

    @Autowired(required = false)
    private EduTaskService eduTaskService;
    @Autowired(required = false)
    private EduTaskSingleService eduTaskSingleService;
    @Autowired(required = false)
    private EduTaskMultiService eduTaskMultiService;
    @Autowired(required = false)
    private EduTaskTorfService eduTaskTorfService;
    @Autowired(required = false)
    private EduUserCourseService eduUserCourseService;
    @Autowired(required = false)
    private EduUserTaskService eduUserTaskService;

    //生成一份作业
    @PostMapping("/createTask")
    @ResponseBody
    public Result createTask(@RequestBody EduTask eduTask){
        int result = eduTaskService.addTask(eduTask);
        if(result == 1)
            return Result.success();
        else
            return Result.failure(ResultCode.TASK_CREATE_FAILED);
    }

    //教师往作业里添加题目
    @PostMapping("/organizeTaskSingle")
    @ResponseBody
    public Result organizeTaskSingle(@RequestBody List<String> idList, @RequestBody String taskId){
        EduTaskSingle eduTaskSingle = new EduTaskSingle();
        eduTaskSingle.setTaskId(taskId);
        for(String id:idList){
            eduTaskSingle.setId(UUIDUtil.getUUID());
            eduTaskSingle.setSingleId(id);
            eduTaskSingleService.addEduTaskSingle(eduTaskSingle);
        }
        return Result.success();
    }
    @PostMapping("/organizeTaskMulti")
    @ResponseBody
    public Result organizeTaskMulti(@RequestBody List<String> idList, @RequestBody String taskId){
        EduTaskMulti eduTaskMulti = new EduTaskMulti();
        eduTaskMulti.setTaskId(taskId);
        for(String id:idList){
            eduTaskMulti.setId(UUIDUtil.getUUID());
            eduTaskMulti.setMultiId(id);
            eduTaskMultiService.addTaskMulti(eduTaskMulti);
        }
        return Result.success();
    }
    @PostMapping("/organizeTaskTorf")
    @ResponseBody
    public Result organizeTaskTorf(@RequestBody List<String> idList, @RequestBody String taskId){
        EduTaskTorf eduTaskTorf = new EduTaskTorf();
        eduTaskTorf.setTaskId(taskId);
        for(String id:idList){
            eduTaskTorf.setId(UUIDUtil.getUUID());
            eduTaskTorf.setTaskId(id);
            eduTaskTorfService.addTaskTorf(eduTaskTorf);
        }
        return Result.success();
    }

    //发布作业给选择了该门课程的同学
    @PostMapping("/setTaskInfo")
    @ResponseBody
    public Result setTaskInfo(@RequestBody EduTask eduTask){
        //发布给选择了该门课程的学生
        List<EduUserCourse> eduUserCourseList = eduUserCourseService.findByCourseId(eduTask.getCourseId());
        List<String> idUserList = eduUserCourseList.stream().map(e->e.getUserId())
                .collect(Collectors.toList());
        //添加考试到学生考试表
        EduUserTask eduUserTask = new EduUserTask();
        eduUserTask.setTaskId(eduTask.getTaskId());
        for(String idUser:idUserList){
            eduUserTask.setId(UUIDUtil.getUUID());
            eduUserTask.setUserId(idUser);
            eduUserTaskService.addUserTask(eduUserTask);
        }
        return Result.success();
    }
}
