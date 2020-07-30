package com.zlt.controller;

import com.zlt.pojo.EduTeacher;
import com.zlt.service.TeacherService;
import com.zlt.utils.MD5Util;
import com.zlt.utils.Result;
import com.zlt.utils.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("edu_teacher")
public class ProsenTeacherController {
    //固定盐值
    private String salt = "4d5e6f";

    @Autowired(required=false)
    private TeacherService teacherService;

    @RequestMapping(value="/findAll",method={RequestMethod.GET})
    @ResponseBody
    public List<EduTeacher> queryUsers(){
        return teacherService.findAllTeacher();
    }

    @PostMapping(value="/updatePasswd")
    @ResponseBody
    public Result upDateTeacher(@RequestBody EduTeacher eduteacher){
        EduTeacher eduTeacher =  teacherService.findTeacherByMobile(eduteacher.getTeacherMobile());
        //手机号或邮箱不存在
        if(eduTeacher == null ){
            return Result.failure(ResultCode.USERNAME_NOT_EXIST);
        }else {
            //密码加盐加密入库
            String password = MD5Util.setDBPwd(eduteacher.getTeacherPassword(),salt);
            eduTeacher.setTeacherPassword(password);
            return Result.failure(ResultCode.SUCCESS);
        }
    }
}
