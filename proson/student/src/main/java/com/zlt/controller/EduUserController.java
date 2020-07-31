package com.zlt.controller;

import com.zlt.exception.EduException;
import com.zlt.pojo.EduUser;
import com.zlt.service.EduUserService;
import com.zlt.utils.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("user")
public class EduUserController {
    //目前是固定盐值
    private String salt = "4d5e6f";

    @Autowired
    private EduUserService eduUserService;

    @PostMapping("/validateLogin")
    @ResponseBody
    public Result Login(@RequestBody EduUser eduUser){
        EduUser eduUser1 = eduUserService.findByEmail(eduUser.getUserEmail());
        EduUser eduUser2 = eduUserService.findByMobile(eduUser.getUserMobile());
        //手机号或邮箱不存在
        if(eduUser1 == null && eduUser2 == null){
            return Result.failure(ResultCode.USERNAME_NOT_EXIST);
        }
        if(eduUser1 != null){
            //验证密码
            String password = MD5Util.setDBPwd(eduUser.getUserPassword(),salt);
            if(!password.equals(eduUser1.getUserPassword())){
                return Result.failure(ResultCode.LOGIN_PASSWORD_ERROR);
            }
            return Result.success(eduUser1);
        }
        else{
            //验证密码
            String password = MD5Util.setDBPwd(eduUser.getUserPassword(),salt);
            if(!password.equals(eduUser2.getUserPassword())){
                return Result.failure(ResultCode.LOGIN_PASSWORD_ERROR);
            }
            return Result.success(eduUser2);
        }
    }

    @PostMapping("/validateRegister")
        @ResponseBody
        public Result Register(@RequestBody EduUser eduUser){
            EduUser eduUser1 = null;
            EduUser eduUser2 = null;
            if(eduUser.getUserEmail()!=null){
                eduUser1 = eduUserService.findByEmail(eduUser.getUserEmail());
            }
            else{
                eduUser2 = eduUserService.findByMobile(eduUser.getUserMobile());
            }
            if(eduUser1 != null){
                return Result.failure(ResultCode.REGISTER_EMAIL_HAS_EXIST);
            }
            if(eduUser2 != null){
                return Result.failure(ResultCode.REGISTER_EMAIL_HAS_EXIST);
            }
            //注册成功
            //密码加盐加密入库
            String password = MD5Util.setDBPwd(eduUser.getUserPassword(),salt);
            eduUser.setUserId(UUIDUtil.getUUID());
            eduUser.setUserPassword(password);
            eduUserService.addUser(eduUser);
            return Result.success();
        }
        //修改密码
    @PostMapping(value="/updatePasswd")
    @ResponseBody
    public Result upDateTeacherPasswd(@RequestBody EduUser eduUser){
        EduUser eduUser1 =  eduUserService.findByMobile(eduUser.getUserMobile());
        //手机号不存在
        if(eduUser1 == null ){
            return Result.failure(ResultCode.USERNAME_NOT_EXIST);
        }else {
            //密码加盐加密入库
            String password = MD5Util.setDBPwd(eduUser.getUserPassword(),salt);
            eduUser1.setUserPassword(password);
            eduUserService.updateUser(eduUser1);
            return Result.success();
        }
    }

    @RequestMapping(value = "/user_findbyid/{id}", method={RequestMethod.GET})
    public Result findById(@PathVariable("id") String userId){
        EduUser eduUser = eduUserService.findById(userId);
        if(eduUser == null){
            //没有try...catch语句，异常抛出后，跳出程序，不再往下执行
            //如果有try...catch语句，try内异常后的代码不再运行，处理后继续向下执行
            throw new EduException(ResultCode.USER_NOT_EXIST);
        }
        return Result.success(eduUser);
    }

    @PostMapping("/user_updatebyid")
    @ResponseBody
    public Result updateById(@RequestBody EduUser eduUser){
        int result = eduUserService.updateUser(eduUser);
        if(result != 1){
            return Result.failure(ResultCode.USER_UPDATE_ERROR);
        }
        return Result.success();
    }

//    @PostMapping("/user_deletebyid/{id}")
//    @ResponseBody
//    public Result updateById(@PathVariable String id){
//        int result = eduUserService.deleteUser(id);
//        if(result != 1){
//            return Result.failure(ResultCode.USER_DELETE_ERROR);
//        }
//        return Result.success();
//    }







}
