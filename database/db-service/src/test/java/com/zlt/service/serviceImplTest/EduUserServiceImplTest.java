package com.zlt.service.serviceImplTest;

import com.zlt.pojo.EduUser;
import com.zlt.service.EduUserService;
import com.zlt.utils.UUIDUtil;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class EduUserServiceImplTest {
    @Autowired(required = false)
    private EduUserService eduUserService;

    @Test
    public void addUser(){
        EduUser eduUser = new EduUser();
        eduUser.setUserId(UUIDUtil.getUUID());
        eduUser.setUserPassword("123456");
        int result = eduUserService.addUser(eduUser);
        Assert.assertEquals(1,result);
    }

    @Test
    public void deleteUser() {
        String id = "2746b44ad1cf4f6db3fc87ff8626fdf9";
        int result = eduUserService.deleteUser(id);
        Assert.assertEquals(1,result);
    }

    @Test
    public void updateUser() {
        String id = "2746b44ad1cf4f6db3fc87ff8626fdf9";
        EduUser eduUser = new EduUser();
        eduUser.setUserId(id);
        eduUser.setUserPassword("321654");
        int result = eduUserService.updateUser(eduUser);
        Assert.assertEquals(1,result);
    }

    @Test
    public void findAll() {
        List<EduUser> eduUsers = eduUserService.findAll();
        Assert.assertNotNull(eduUsers);
    }

    @Test
    public void findById() {
        String id = "2746b44ad1cf4f6db3fc87ff8626fdf9";
        EduUser eduUser = eduUserService.findById(id);
        Assert.assertNotNull(eduUser);
    }
}