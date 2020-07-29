package com.zlt.service.serviceImplTest;

import com.zlt.pojo.EduUser;
import com.zlt.service.EduUserService;
import com.zlt.service.impl.EduUserServiceImpl;
import com.zlt.utils.UUIDUtil;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EduUserServiceImplTest {

    @Autowired(required = false)
    private EduUserServiceImpl eduUserService;

    @Test
    public void addUser(){
        EduUser eduUser = new EduUser();
        eduUser.setUserId(UUIDUtil.getUUID());
        eduUser.setUserPassword("123456");
        int result = eduUserService.addUser(eduUser);
        Assert.assertEquals(1,result);
    }
}
