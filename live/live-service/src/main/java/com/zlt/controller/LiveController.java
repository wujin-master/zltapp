package com.zlt.controller;


import com.zlt.pojo.EduChatinfo;
import com.zlt.pojo.EduCourse;
import com.zlt.pojo.EduUser;
import com.zlt.service.ChatInfoService;
import com.zlt.service.EduClassService;
import com.zlt.service.EduCourseService;
import com.zlt.service.EduUserService;
import com.zlt.utils.Result;
import com.zlt.utils.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("live")
public class LiveController {
    @Autowired(required = false)
    private EduUserService eduUserService;
    @Autowired(required = false)
    private ChatInfoService chatInfoService;
    @Autowired(required = false)
    private EduCourseService eduCourseService;

    //修改直播地址
    @RequestMapping(value = "ChangeLiveUrl", method={RequestMethod.POST})
    @ResponseBody
    public Result ChangeLiveUrl(@RequestBody EduCourse eduCourse1){
        try{
            //先取出来前端传来的courseId，去除对象之后修改直播地址，然后更新到数据库
            EduCourse eduCourse = eduCourseService.findById(eduCourse1.getCourseId());
            eduCourse.setLiveUrl(eduCourse1.getLiveUrl());
            eduCourseService.updateCourse(eduCourse);
            return Result.success();
        } catch (Exception e) {
            e.printStackTrace();
            //出错就发送错误代码
            return Result.failure(ResultCode.SQF_FAILED);
        }

    }

    //获取播放地址
    @RequestMapping(value = "getLiveUrl", method={RequestMethod.POST})
    @ResponseBody
    public Result getCourseUrl(@RequestBody EduCourse eduCourse1){
        try{
            //先取出来前端传来的courseId，查找出对应的对象，然后新建一个course对象，设置直播地址，传给前端
            EduCourse eduCourse = eduCourseService.findById(eduCourse1.getCourseId());
            EduCourse eduCourse2 = new EduCourse();
            eduCourse2.setLiveUrl(eduCourse.getLiveUrl());
            return Result.success(eduCourse2);
        } catch (Exception e) {
            e.printStackTrace();
            //出错就发送错误代码
            return Result.failure(ResultCode.SQF_FAILED);
        }
    }

    //

    //获取课程信息
    @RequestMapping(value = "getCourseInfo", method={RequestMethod.POST})
    @ResponseBody
    public EduUser getCourseInfo(@RequestBody String courseId){
        return null;
    }

    //获取群聊信息
    @RequestMapping(value = "getChatInfo", method={RequestMethod.POST})
    @ResponseBody
    public List<EduChatinfo> getChatInfo(@RequestBody EduChatinfo eduChatinfo){
        List<EduChatinfo> list = chatInfoService.findChatInfoByReceiver(eduChatinfo.getReceiver());
        return list;
    }

    //获取私聊信息
    @RequestMapping(value = "getPrivateChatInfo", method={RequestMethod.POST})
    @ResponseBody
    public List<EduChatinfo> getPrivateChatInfo(@RequestBody EduChatinfo eduChatinfo){
        System.out.println(eduChatinfo.getReceiver());
        System.out.println(eduChatinfo.getSender());
        List<EduChatinfo> list = chatInfoService.findChatInfoBySenderAndReceiver(eduChatinfo.getSender(), eduChatinfo.getReceiver());
        return list;
    }

    //获取用户信息
    @RequestMapping(value = "getUserInfo", method={RequestMethod.POST})
    @ResponseBody
    public EduUser getUserInfo(@RequestBody EduUser eduUser){
        EduUser eduUser1 = eduUserService.findById(eduUser.getUserId());
        return eduUser1;
    }
}
