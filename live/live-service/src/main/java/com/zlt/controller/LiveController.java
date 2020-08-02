package com.zlt.controller;


import com.zlt.pojo.EduChatinfo;
import com.zlt.pojo.EduCourse;
import com.zlt.pojo.EduUser;
import com.zlt.service.ChatInfoService;
import com.zlt.service.EduClassService;
import com.zlt.service.EduCourseService;
import com.zlt.service.EduUserService;
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
    private EduClassService eduClassService;
    @Autowired(required = false)
    private ChatInfoService chatInfoService;
    @Autowired(required = false)
    private EduCourseService eduCourseService;

    //获取播放地址
    @RequestMapping(value = "getLiveUrl", method={RequestMethod.POST})
    @ResponseBody
    public String getCourseUrl(@RequestBody String courseId){
        EduCourse eduCourse = eduCourseService.findById(courseId);
        //此处无法调用get和set
        return "";
    }

    //获取课程信息
    @RequestMapping(value = "getCourseInfo", method={RequestMethod.POST})
    @ResponseBody
    public EduUser getCourseInfo(@RequestBody String courseId){
        return null;
    }

    //获取课程信息
    @RequestMapping(value = "getChatInfo", method={RequestMethod.POST})
    @ResponseBody
    public List<EduChatinfo> getChatInfo(@RequestBody EduChatinfo eduChatinfo){
        System.out.println(eduChatinfo.getReceiver());
        List<EduChatinfo> list = chatInfoService.findChatInfoByReceiver("01");
        return list;
    }

    //获取用户信息
    @RequestMapping(value = "getUserInfo", method={RequestMethod.POST})
    @ResponseBody
    public EduUser getUserInfo(@RequestBody EduUser eduUser){
        EduUser eduUser1 = eduUserService.findById(eduUser.getUserId());
        return eduUser1;
    }

//    //获取属于该课程的用户
//    @RequestMapping(value = "getClassUsers", method={RequestMethod.POST})
//    @ResponseBody
//    public List<EduUser> getClassUsers(@RequestBody String classId){
//        List<EduUser> list = eduUserService.findAll();
//        ArrayList<EduUser> userList = new ArrayList<EduUser>();
//        for(EduUser eduUser:list){
//            //此处负责写EduUser的同学，没有写classId属性，导致没有getClassId方法，添加即可
//            if(classId.equals(eduUser.getClassId())){
//                userList.add(eduUser);
//            }
//        }
//        return userList;
//    }
}
