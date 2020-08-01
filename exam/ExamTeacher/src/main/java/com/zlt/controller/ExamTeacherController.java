package com.zlt.controller;

import com.zlt.pojo.*;
import com.zlt.service.*;
import com.zlt.utils.Result;
import com.zlt.utils.ResultCode;
import com.zlt.utils.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("examTeacher")
public class ExamTeacherController {
    @Autowired(required = false)
    private EduUserExamService eduUserExamService;
    @Autowired(required = false)
    private ExamService examService;
    @Autowired(required = false)
    private PaperService paperService;
    @Autowired(required = false)
    private EduPaperSingleService eduPaperSingleService;
    @Autowired(required = false)
    private PaperMultiService paperMultiService;
    @Autowired(required = false)
    private PaperTorfService paperTorfService;
    @Autowired(required = false)
    private EduTrueOrFalseService eduTrueOrFalseService;
    @Autowired(required = false)
    private EduMultiSelService eduMultiSelService;
    @Autowired(required = false)
    private EduSingleSelService eduSingleSelService;
    @Autowired(required = false)
    private EduUserCourseService eduUserCourseService;
    @Autowired
    //获取题目
    @GetMapping("/getAllSingle")
    public Result getAllSingle(){
        List<EduSingleSel> eduSingleSelList = eduSingleSelService.selectAllSingle();
        Map<String,Object> map = new HashMap<>();
        map.put("singleList",eduSingleSelList);
        map.put("count",eduSingleSelList.size());
        return Result.success(map);
    }
    @GetMapping("/getAllMulti")
    public Result getAllMulti(){
        List<EduMultiSel> eduMultiSelList = eduMultiSelService.selectAllMulti();
        Map<String,Object> map = new HashMap<>();
        map.put("multiList",eduMultiSelList);
        map.put("count",eduMultiSelList.size());
        return Result.success(map);
    }
    @GetMapping("/getAllTorf")
    public Result getAllTorf(){
        List<EduTrueOrFalse> eduTrueOrFalseList = eduTrueOrFalseService.selectAll();
        Map<String,Object> map = new HashMap<>();
        map.put("torfList",eduTrueOrFalseList);
        map.put("count",eduTrueOrFalseList.size());
        return Result.success(map);
    }

    //添加题目
    @PostMapping("/addSingle")
    @ResponseBody
    public Result addSingle(@RequestBody EduSingleSel eduSingleSel){
        int result = eduSingleSelService.insertOne(eduSingleSel);
        if(result == 1)
            return Result.success();
        else
            return Result.failure(ResultCode.SINGLE_INSERT_FAILED);
    }
    @PostMapping("/addMulti")
    @ResponseBody
    public Result addMulti(@RequestBody EduMultiSel eduMultiSel){
        int result = eduMultiSelService.insertOne(eduMultiSel);
        if(result == 1)
            return Result.success();
        else
            return Result.failure(ResultCode.MULTI_INSERT_FAILED);
    }
    @PostMapping("/addTorf")
    @ResponseBody
    public Result addTorf(@RequestBody EduTrueOrFalse eduTrueOrFalse){
        int result = eduTrueOrFalseService.insertOne(eduTrueOrFalse);
        if(result == 1)
            return Result.success();
        else
            return Result.failure(ResultCode.TORF_INSERT_FAILED);
    }

    //生成一张试卷
    @PostMapping("/createPaper")
    @ResponseBody
    public Result createPaper(@RequestBody EduPaper eduPaper){
        int result = paperService.addPaper(eduPaper);
        if(result == 1)
            return Result.success();
        else
            return Result.failure(ResultCode.PAPER_CREATE_FAILED);
    }
//    @GetMapping("findAll")
//    public Result findAll(){
//        List<EduExam> eduExamList =
//    }

    //教师往试卷里添加题目
    //组卷
    @PostMapping("/organizePaperSingle")
    @ResponseBody
    public Result organizePaperSingle(@RequestBody List<String> idList,@RequestBody String paperId){
        EduPaperSingle eduPaperSingle = new EduPaperSingle();
        eduPaperSingle.setPaperId(paperId);
        for(String id:idList){
            eduPaperSingle.setId(UUIDUtil.getUUID());
            eduPaperSingle.setSingleId(id);
            eduPaperSingleService.addPaperSingle(eduPaperSingle);
        }
        return Result.success();
    }
    @PostMapping("/organizePaperMulti")
    @ResponseBody
    public Result organizePaperMulti(@RequestBody List<String> idList,@RequestBody String paperId){
        EduPapermulti eduPapermulti = new EduPapermulti();
        eduPapermulti.setPaperId(paperId);
        for(String id:idList){
            eduPapermulti.setId(UUIDUtil.getUUID());
            eduPapermulti.setMultiId(id);
            paperMultiService.addPaperMulti(eduPapermulti);
        }
        return Result.success();
    }
    @PostMapping("/organizePaperTorf")
    @ResponseBody
    public Result organizePaperTorf(@RequestBody List<String> idList,@RequestBody String paperId){
        EduPapertorf eduPapertorf = new EduPapertorf();
        eduPapertorf.setPaperId(paperId);
        for(String id:idList){
            eduPapertorf.setId(UUIDUtil.getUUID());
            eduPapertorf.setTorfId(id);
            paperTorfService.addPaperTorf(eduPapertorf);
        }
        return Result.success();
    }

    //安排考试相关信息并发布给选择了该门课程的同学
    @PostMapping("/setExamInfo")
    @ResponseBody
    public Result setExamInfo(@RequestBody EduExam eduExam){
        eduExam.setExamId(UUIDUtil.getUUID());
        int result = examService.addExam(eduExam);
        //发布给选择了该门课程的学生
        List<EduUserCourse> eduUserCourseList = eduUserCourseService.findByCourseId(eduExam.getCourseId());
        List<String> idUserList = eduUserCourseList.stream().map(e->e.getUserId())
                                    .collect(Collectors.toList());
        //添加考试到学生考试表
        EduUserExam eduUserExam = new EduUserExam();
        eduUserExam.setExamId(eduExam.getExamId());
        for(String idUser:idUserList){
            eduUserExam.setId(UUIDUtil.getUUID());
            eduUserExam.setUserId(idUser);
            eduUserExamService.addUserExam(eduUserExam);
        }
        if(result == 1){
            return Result.success();
        }
        else
            return Result.failure(ResultCode.SET_EXAM_FAILED);
    }

}
