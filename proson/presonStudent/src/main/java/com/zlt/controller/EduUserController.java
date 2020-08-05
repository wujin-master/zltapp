package com.zlt.controller;

import com.zlt.exception.EduException;
import com.zlt.pojo.EduUser;
import com.zlt.service.EduUserService;
import com.zlt.utils.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import static com.zlt.utils.Base64Util.GenerateImage;

@RestController
@RequestMapping("edu_user")
public class EduUserController {
    //目前是固定盐值
    private String salt = "4d5e6f";

    @Autowired(required = false)
    private EduUserService eduUserService;

    @Autowired(required = false)
    private StringRedisTemplate stringRedisTemplate;

    @Autowired(required = false)
    private RedisUtil redisUtil;

    @PostMapping("/validateLogin")
    @ResponseBody
    public Result Login(@RequestBody EduUser eduUser){
        System.out.println(eduUser.getUserMobile());
        EduUser eduUser1 = eduUserService.findByEmail(eduUser.getUserEmail());
        EduUser eduUser2 = eduUserService.findByMobile(eduUser.getUserMobile());
        Map<String,Object> map = new HashMap<>();
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
            //账号密码正确，签发token
            String token = TokenUtil.token(eduUser1.getUserEmail(),password);
            // 存储到redis
            // 参数分别为key,value,过期时间为3600,单位为s
            redisUtil.set(token,eduUser1.getUserId(),3600);
            //stringRedisTemplate.opsForValue().set(token, eduUser1.getUserId(), 3600, TimeUnit.SECONDS);
            map.put("token",token);
            map.put("eduUser",eduUser1);
            return Result.success(map);
        }
        else{
            //验证密码
            String password = MD5Util.setDBPwd(eduUser.getUserPassword(),salt);
            if(!password.equals(eduUser2.getUserPassword())){
                return Result.failure(ResultCode.LOGIN_PASSWORD_ERROR);
            }
            //账号密码正确，签发token
            String token = TokenUtil.token(eduUser2.getUserMobile(),password);
            //参数分别为key,value,过期时间为1小时
            redisUtil.set(token,eduUser1.getUserId(),3600);
            map.put("token",token);
            map.put("eduUser",eduUser2);
            return Result.success(map);
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
        if(eduUser1 != null || eduUser2 != null){
            if(eduUser1 != null)
                return Result.failure(ResultCode.REGISTER_EMAIL_HAS_EXIST);
            else
                return Result.failure(ResultCode.REGISTER_MOBILE_HAS_EXIST);
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
    public Result upDateStudentPasswd(@RequestBody EduUser eduUser){
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

    //添加头像
    @PostMapping("/addPortrait")
    @ResponseBody
    public Result addPortrait(@RequestBody Map<String,String> map){
        String userId = map.get("userId");
        System.out.println(userId);
        String[] strArr = map.get("base64Data").split(",");
        String uuid = UUIDUtil.getUUID();
        //"data:image/jpeg;base64,"
        String savePath = UUIDUtil.getUUID() + "." + strArr[0].replace("data:image/", "").replace(";base64", "");
        if(GenerateImage(strArr[1], savePath)) {
            //上传成功后，将url保存到数据库
            EduUser eduUser = eduUserService.findById(userId);
            eduUser.setUserPortrait("http://my.17f.club/" + savePath);
            eduUserService.updateUser(eduUser);
            return Result.success();
        }
        else
            return Result.failure(ResultCode.SET_PORTRAIT_FAILED);
    }


}