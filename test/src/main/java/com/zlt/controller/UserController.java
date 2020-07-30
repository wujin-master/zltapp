package com.zlt.controller;

import com.zlt.pojo.EduUser;
import com.zlt.service.EduUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private EduUserService eduUserService;

    @RequestMapping(value="queryUsers",method = {RequestMethod.GET})
    @ResponseBody
    public List<EduUser> Test(){
        List<EduUser> eduUsers = eduUserService.findAll();
        for(EduUser eduUser:eduUsers){
            System.out.println(eduUser.getUserId());
        }
        return eduUsers;
    }

}
