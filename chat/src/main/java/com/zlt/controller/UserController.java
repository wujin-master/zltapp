package com.zlt.controller;

import com.zlt.pojo.EduUser;
import com.zlt.service.EduUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired(required = false)
    private EduUserService userService;

    // http://localhost:8088/user/queryUsers
    // 返回的是json数据：List<User>
//    @RequestMapping(value = "queryUsers", method = {RequestMethod.GET})
//    @ResponseBody
//    public List<EduUser> queryUsers(){
//        return userService.queryUsers();
//    }

    @RequestMapping(value = "queryById/{id}", method={RequestMethod.GET})
    @ResponseBody
    public EduUser queryById(@PathVariable("id") String id){
        return userService.findById(id);
    }


}
