package com.zlt.service.impl;

import com.zlt.mapper.EduUserMapper;
import com.zlt.pojo.EduUser;
import com.zlt.service.EduUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EduUserServiceImpl implements EduUserService {

    @Autowired(required = false)
    private EduUserMapper eduUserMapper;

    @Override
    public int addUser(EduUser eduUser) {
        return eduUserMapper.addUser(eduUser);
    }

    @Override
    public int deleteUser(String userId) {
        return eduUserMapper.deleteUser(userId);
    }

    @Override
    public int updateUser(EduUser eduUser) {
        return eduUserMapper.updateUser(eduUser);
    }

    @Override
    public List<EduUser> findAll() {
        return eduUserMapper.queryUsers();
    }

    @Override
    public EduUser findById(String id) {
        return eduUserMapper.findById(id);
    }

    @Override
    public EduUser findByEmail(String email) {
        return eduUserMapper.findByEmail(email);
    }

    @Override
    public EduUser findByMobile(String mobile) {
        return eduUserMapper.findByMobile(mobile);
    }
}
