package com.zlt.controller;

import com.zlt.pojo.EduTeacher;
import com.zlt.service.TeacherService;
import com.zlt.utils.MD5Util;
import com.zlt.utils.Result;
import com.zlt.utils.ResultCode;
import com.zlt.utils.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("edu_teacher")
public class PresonTeacherController {

    //固定盐值
    private String salt = "4d5e6f";

    @Autowired(required=false)
    private TeacherService teacherService;

    @PostMapping("/validateLogin")
    @ResponseBody
    public Result Login(@RequestBody EduTeacher eduteacher){
        EduTeacher eduTeacher1 = teacherService.findByEmail(eduteacher.getTeacherEmail());
        EduTeacher eduTeacher2 = teacherService.findTeacherByMobile(eduteacher.getTeacherMobile());
        //手机号或邮箱不存在
        if(eduTeacher1 == null && eduTeacher2 == null){
            return Result.failure(ResultCode.USERNAME_NOT_EXIST);
        }
        if(eduTeacher1 != null){
            //验证密码
            String password = MD5Util.setDBPwd(eduteacher.getTeacherPassword(),salt);
            if(!password.equals(eduTeacher1.getTeacherPassword())){
                return Result.failure(ResultCode.LOGIN_PASSWORD_ERROR);
            }
            return Result.success(eduTeacher1);
        }
        else{
            //验证密码
            String password = MD5Util.setDBPwd(eduteacher.getTeacherPassword(),salt);
            if(!password.equals(eduTeacher2.getTeacherPassword())){
                return Result.failure(ResultCode.LOGIN_PASSWORD_ERROR);
            }
            return Result.success(eduTeacher2);
        }
    }

    @PostMapping("/validateRegister")
    @ResponseBody
    public Result Register(@RequestBody EduTeacher eduteacher){
        EduTeacher eduTeacher1 = null;
        EduTeacher eduTeacher2 = null;
        if(eduteacher.getTeacherEmail()!=null){
            eduTeacher1 = teacherService.findByEmail(eduteacher.getTeacherEmail());
        }
        else{
            eduTeacher2 = teacherService.findTeacherByMobile(eduteacher.getTeacherMobile());
        }
        if(eduTeacher1 != null){
            return Result.failure(ResultCode.REGISTER_EMAIL_HAS_EXIST);
        }
        if(eduTeacher2 != null){
            return Result.failure(ResultCode.REGISTER_EMAIL_HAS_EXIST);
        }
        //注册成功
        //密码加盐加密入库
        String password = MD5Util.setDBPwd(eduteacher.getTeacherPassword(),salt);
        eduteacher.setTeacherId(UUIDUtil.getUUID());
        eduteacher.setTeacherPassword(password);
        teacherService.addTeacher(eduteacher);
        return Result.success();
    }





    @RequestMapping(value="/findAll",method={RequestMethod.GET})//获取所有老师
    @ResponseBody
    public Result queryUsers(){
        return Result.success(teacherService.findAllTeacher());
    }

    @PostMapping(value="/updatePasswd")//修改密码
    @ResponseBody
    public Result upDateTeacherPasswd(@RequestBody EduTeacher eduteacher){
        EduTeacher eduTeacher =  teacherService.findTeacherByMobile(eduteacher.getTeacherMobile());
        //手机号不存在
        if(eduTeacher == null ){
            return Result.failure(ResultCode.USERNAME_NOT_EXIST);
        }else {
            //密码加盐加密入库
            String password = MD5Util.setDBPwd(eduteacher.getTeacherPassword(),salt);
            eduTeacher.setTeacherPassword(password);
            teacherService.updateTeacher(eduTeacher);
            return Result.failure(ResultCode.SUCCESS);
        }
    }

    @PostMapping(value="/updateTeacher")//修改个人信息
    @ResponseBody
    public Result upDateTeacher(@RequestBody EduTeacher eduteacher){
        EduTeacher eduTeacher =  teacherService.findByTeacherId(eduteacher.getTeacherId());
        //用户不存在
        if(eduTeacher == null ){
            return Result.failure(ResultCode.USERNAME_NOT_EXIST);
        }else {
            //更新用户信息
            int result = teacherService.updateTeacher(eduteacher);
            return Result.failure(ResultCode.SUCCESS);
        }
    }
}
