package com.zlt.controller;

import com.netflix.discovery.converters.Auto;
import com.zlt.pojo.*;
import com.zlt.service.*;
import com.zlt.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("examStudent")
public class ExamStudentController {
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

    //显示所有考试
    @GetMapping("/show_allExam/{id}")
    public Result showExam(@PathVariable("ID") String id){
        List<EduUserExam> eduUserExamList = eduUserExamService.findExamByUserId(id);
        return Result.success(eduUserExamList);
    }
    //查看历史或过往考试
    @GetMapping("/show_pastExam/{id}")
    public Result showPastExam(String id){
        List<EduExam> eduExams = new ArrayList<>();
        List<EduUserExam> eduUserExamList = eduUserExamService.findExamByUserId(id);
        List<String> idList = eduUserExamList.stream().map(e->e.getExamId())
                                .collect(Collectors.toList());
        //获取当前时间
        Date day=new Date();
        //时间格式为yyyy-MM-dd HH:mm:ss
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        for(String examId:idList){
            EduExam eduExam = examService.findExamByExamId(examId);
            //比较日期
            if(df.format(eduExam.getExamEndTime()).compareTo(df.format(day))<0){
                //过时考试
                eduExams.add(eduExam);
            }
        }
        return Result.success(eduExams);
    }

    //点击列表参与答题
    @GetMapping("/startWriting/{examId}")
    public Result getPaperContext(@PathVariable("examId") String examId){
        EduExam eduExam = examService.findExamByExamId(examId);
        EduPaper eduPaper = paperService.findPaperByPaperId(eduExam.getPaperId());
        List<EduSingleSel> eduSingleSels = new ArrayList<>();
        List<EduMultiSel> eduMultiSels = new ArrayList<>();
        List<EduTrueOrFalse> eduTrueOrFalses = new ArrayList<>();
        List<EduPaperSingle> eduPaperSingleList = eduPaperSingleService.findPaperSingleById(eduPaper.getPaperId());
        List<EduPapermulti> eduPapermultiList = paperMultiService.findPaperMultiById(eduPaper.getPaperId());
        List<EduPapertorf> eduPapertorfList = paperTorfService.findPaperTorfById(eduPaper.getPaperId());
        List<String> idSingle = eduPaperSingleList.stream().map(e->e.getSingleId())
                                    .collect(Collectors.toList());
        List<String> idMulti = eduPapermultiList.stream().map(e->e.getMultiId())
                                    .collect(Collectors.toList());
        List<String> idTorf = eduPapertorfList.stream().map(e->e.getTorfId())
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

    //自动阅卷给出分数
    @PostMapping("/correctPaper")
    @ResponseBody
    public Result correctPaper(@RequestBody Map<String,String> eduSingleSelMap,
                                @RequestBody Map<String,String> eduMultiSelMap,
                                @RequestBody Map<String,String> eduTrueOrFalseMap){
        //试卷总得分
        int total = 0;
        int trueNumSingle = 0;
        int trueNumMulti = 0;
        int trueNumTorf = 0;
        EduSingleSel eduSingleSel = new EduSingleSel();
        EduMultiSel eduMultiSel = new EduMultiSel();
        EduTrueOrFalse eduTrueOrFalse = new EduTrueOrFalse();
        for(Map.Entry<String, String> entry : eduSingleSelMap.entrySet()){
            String mapKey = entry.getKey();
            String mapValue = entry.getValue();
            eduSingleSel = eduSingleSelService.selectSingleById(mapKey);
            if(mapValue.equals(eduSingleSel.getAnswer())){
                //单选正确数加一
                trueNumSingle += 1;
                total += 5;
            }
        }
        for(Map.Entry<String, String> entry : eduMultiSelMap.entrySet()){
            String mapKey = entry.getKey();
            String mapValue = entry.getValue();
            eduMultiSel = eduMultiSelService.selectMultiById(mapKey);
            if(mapValue.equals(eduMultiSel.getAnswer())){
                //多选正确数加一
                trueNumMulti += 1;
                total += 5;
            }
        }
        for(Map.Entry<String, String> entry : eduTrueOrFalseMap.entrySet()){
            String mapKey = entry.getKey();
            String mapValue = entry.getValue();
            eduTrueOrFalse = eduTrueOrFalseService.selectById(mapKey);
            if(mapValue.equals(eduTrueOrFalse.getAnswer())){
                //判断正确数加一
                trueNumTorf += 1;
                total += 5;
            }
        }
        Map<String,Integer> maps = new HashMap<>();
        maps.put("singleTrueNum",trueNumSingle);
        maps.put("multiTrueNum",trueNumMulti);
        maps.put("torfTrueNum",trueNumTorf);
        maps.put("totalScore",total);
        return Result.success(maps);
    }


}
