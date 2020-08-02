package com.zlt.controller;

import com.zlt.pojo.*;
import com.zlt.service.*;
import com.zlt.utils.Result;
import com.zlt.utils.ResultCode;
import com.zlt.utils.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
    @Autowired(required = false)
    private EduTeacherTaskService eduTeacherTaskService;

    //作业表增删改查
    @GetMapping("/findAllTask")
    public Result findAllTask(){
        List<EduTask> eduTaskList = eduTaskService.findAll();
        int count = eduTaskList.size();
        if(eduTaskList != null) {
            Map<String,Object> map = new HashMap<>();
            map.put("eduTaskList",eduTaskList);
            map.put("count",count);
            return Result.success(map);
        }
        else
            return Result.failure(ResultCode.TASK_FIND_FAILED);
    }
    @PostMapping("/deleteTask")
    @ResponseBody
    public Result deleteTask(@RequestBody String taskId){
        int result = eduTaskService.deleteTask(taskId);
        if(result == 1)
            return Result.success();
        else
            return Result.failure(ResultCode.TASK_DELETE_FAILED);
    }
    @PostMapping("/updateTask")
    @ResponseBody
    public Result updateTask(@RequestBody EduTask eduTask){
        int result = eduTaskService.updateTask(eduTask);
        if (result == 1){
            return Result.success();
        }
        else
            return Result.failure(ResultCode.TASK_UPDATE_FAILED);
    }
    @PostMapping("/addTask")
    @ResponseBody
    public Result addTask(@RequestBody EduTask eduTask){
        int result = eduTaskService.addTask(eduTask);
        if (result == 1)
            return Result.success();
        else
            return Result.failure(ResultCode.TASK_ADD_FAILED);
    }

    //教师-作业表增删改查
    @GetMapping("/findAllTeacherTask/{teacherId}")
    public Result findAllExam(@PathVariable("teacherId") String teacherId){
        List<EduTeacherTask> eduTeacherTaskList = eduTeacherTaskService.findById(teacherId);
        List<String> idList = eduTeacherTaskList.stream().map(e->e.getTaskId())
                                .collect(Collectors.toList());
        List<EduTask> eduTaskList = new ArrayList<>();
        EduTask eduTask = null;
        for(String id : idList){
            eduTask = eduTaskService.findById(id);
            eduTaskList.add(eduTask);
        }
        int count = eduTaskList.size();
        Map<String,Object> map = new HashMap<>();
        map.put("eduTaskList",eduTaskList);
        map.put("count",count);
        return Result.success(map);
    }
    @PostMapping("/deleteTeacherTask")
    @ResponseBody
    public Result deleteExam(@RequestBody Map<String,String> map){
        String teacherId = map.get("teacherId");
        String taskId = map.get("taskId");
        int result = eduTeacherTaskService.deleteTeacherTask(teacherId,taskId);
        if(result == 1)
            return Result.success();
        else
            return Result.failure(ResultCode.TEACHERTASK_DELETE_FAILED);
    }
    @PostMapping("/updateTeacherTask")
    @ResponseBody
    public Result updateTeacherTask(@RequestBody EduTeacherTask eduTeacherTask){
        int result = eduTeacherTaskService.updateTeacherTask(eduTeacherTask);
        if (result == 1)
            return Result.success();
        else
            return Result.failure(ResultCode.TEACHERTASK_UPDATE_FAILED);
    }
    @PostMapping("/addTeacherTask")
    @ResponseBody
    public Result addTeacherTask(@RequestBody EduTeacherTask eduTeacherTask){
        int result = eduTeacherTaskService.addTeacherTask(eduTeacherTask);
        if (result == 1)
            return Result.success();
        else
            return Result.failure(ResultCode.TEACHERTASK_ADD_FAILED);
    }

//    @GetMapping("/showTasks/{teacherId}")
//    public Result showTasks(@PathVariable("teacherId") String teacherId){
//        int result = eduUserTaskService.f
//    }

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
