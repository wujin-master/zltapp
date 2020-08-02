package com.zlt.controller;

import com.sun.org.apache.regexp.internal.RE;
import com.zlt.pojo.*;
import com.zlt.service.*;
import com.zlt.utils.Result;
import com.zlt.utils.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("taskStudent")
public class TaskStudentController {
    @Autowired(required = false)
    private EduTaskSingleService eduTaskSingleService;
    @Autowired(required = false)
    private EduUserTaskService eduUserTaskService;
    @Autowired(required = false)
    private EduTaskMultiService eduTaskMultiService;
    @Autowired(required = false)
    private EduTaskTorfService eduTaskTorfService;
    @Autowired(required = false)
    private EduTrueOrFalseService eduTrueOrFalseService;
    @Autowired(required = false)
    private EduMultiSelService eduMultiSelService;
    @Autowired(required = false)
    private EduSingleSelService eduSingleSelService;

    //显示所有作业
    @GetMapping("/show_allTask/{id}")
    public Result showTask(@PathVariable("id") String id){
        List<EduUserTask> eduUserTaskList = eduUserTaskService.findTaskByUserId(id);
        Map<String,Object> map = new HashMap<>();
        map.put("eduUserTaskList",eduUserTaskList);
        map.put("count",eduUserTaskList.size());
        return Result.success(map);
    }

    //点击列表参与答题
    @GetMapping("/startWriting/{taskId}")
    public Result getTaskContext(@PathVariable("taskId") String taskId){

        List<EduSingleSel> eduSingleSels = new ArrayList<>();
        List<EduMultiSel> eduMultiSels = new ArrayList<>();
        List<EduTrueOrFalse> eduTrueOrFalses = new ArrayList<>();

        List<EduTaskSingle> eduTaskSingleList = eduTaskSingleService.findEduTaskSingleById(taskId);
        System.out.println(eduTaskSingleList);
        List<EduTaskMulti> eduTaskmultiList = eduTaskMultiService.findByTaskId(taskId);
        System.out.println(eduTaskmultiList);
        List<EduTaskTorf> eduTasktorfList = eduTaskTorfService.findByTaskId(taskId);
        System.out.println(eduTasktorfList);

        List<String> idSingle = eduTaskSingleList.stream().map(e->e.getSingleId())
                .collect(Collectors.toList());
        List<String> idMulti = eduTaskmultiList.stream().map(e->e.getMultiId())
                .collect(Collectors.toList());
        List<String> idTorf = eduTasktorfList.stream().map(e->e.getTorfId())
                .collect(Collectors.toList());
        for(String idsingle:idSingle){
            EduSingleSel eduSingleSel = eduSingleSelService.selectSingleById(idsingle);
            eduSingleSels.add(eduSingleSel);
        }
        for(String idmulti:idMulti){
            EduMultiSel eduMultiSel = eduMultiSelService.selectMultiById(idmulti);
            eduMultiSels.add(eduMultiSel);
        }
        for(String idtorf:idTorf){
            EduTrueOrFalse eduTrueOrFalse = eduTrueOrFalseService.selectById(idtorf);
            eduTrueOrFalses.add(eduTrueOrFalse);
        }
        Map<String,Object> map = new HashMap<>();
        map.put("singleList",eduSingleSels);
        map.put("multiList",eduMultiSels);
        map.put("torfList",eduTrueOrFalses);
        return Result.success(map);

    }
//
    //自动阅卷给出分数
    @PostMapping("/correctTask")
    @ResponseBody
    public Result correctPaper(@RequestBody Map<String,Object> eduTaskInfo){

        //学生ID和作业ID
        Map<String,String> userTaskInfo = (Map<String,String>)eduTaskInfo.get("eduUserTaskInfo");
        String userId = userTaskInfo.get("userId");
        String taskId = userTaskInfo.get("taskId");

        //试卷总得分
        int total = 0;
        //各种题型的正确个数
        int trueNumSingle = 0;
        int trueNumMulti = 0;
        int trueNumTorf = 0;
        //三种题型
        EduSingleSel eduSingleSel = new EduSingleSel();
        EduMultiSel eduMultiSel = new EduMultiSel();
        EduTrueOrFalse eduTrueOrFalse = new EduTrueOrFalse();

        //题目Id和学生答案
        String id = "";
        String ans = "";
        //单选题
        List<Map<String,String>> eduSingleSelss = (ArrayList)eduTaskInfo.get("eduSingleSelMap");
        for(Map<String,String> single:eduSingleSelss){
            id = single.get("id");
            ans = single.get("ans");
            System.out.println(id + " " + ans);
            eduSingleSel = eduSingleSelService.selectSingleById(id);
            if(ans.equals(eduSingleSel.getAnswer())){
                //单选题正确数加一
                trueNumSingle += 1;
                //总得分加5
                total += 5;
            }
        }
        //多选题
        List<Map<String,String>> eduMultiSelss = (ArrayList)eduTaskInfo.get("eduMultiSelMap");
        for(Map<String,String> multi:eduMultiSelss){
            id = multi.get("id");
            ans = multi.get("ans");
            System.out.println(id + " " + ans);
            eduMultiSel = eduMultiSelService.selectMultiById(id);
            if(ans.equals(eduMultiSel.getAnswer())){
                //单选题正确数加一
                trueNumMulti += 1;
                //总得分加4
                total += 4;
            }
        }

        List<Map<String,String>> eduTorfSelss = (ArrayList)eduTaskInfo.get("eduTrueorFalseMap");
        for(Map<String,String> torf:eduTorfSelss){
            id = torf.get("id");
            ans = torf.get("ans");
            System.out.println(id + " " + ans);
            eduTrueOrFalse = eduTrueOrFalseService.selectById(id);
            if(ans.equals(eduTrueOrFalse.getAnswer())){
                //单选题正确数加一
                trueNumTorf += 1;
                //总得分加2
                total += 2;
            }
        }

        //计算分数后，给用户上分
        EduUserTask eduUserTask = eduUserTaskService.findByUITI(userId,taskId);
        eduUserTask.setScore(total);
        eduUserTaskService.updUserTask(eduUserTask);
        System.out.println("得分" + total);

        Map<String,Integer> maps = new HashMap<>();
        maps.put("singleTrueNum",trueNumSingle);
        maps.put("multiTrueNum",trueNumMulti);
        maps.put("torfTrueNum",trueNumTorf);
        maps.put("totalScore",total);
        return Result.success(maps);
    }

    @PostMapping("/getScore")
    @ResponseBody
    public Result getScore(@RequestBody EduUserTask eduUserTask){
        EduUserTask eduUserTask1 = eduUserTaskService.findByUITI(eduUserTask.getUserId(),eduUserTask.getTaskId());
        eduUserTask.setId(eduUserTask1.getId());
        int result = eduUserTaskService.updUserTask(eduUserTask);
        if(result == 1){
            return Result.success();
        }
        else
            return Result.failure(ResultCode.SCORE_UPDATE_FAILED);

    }

}
