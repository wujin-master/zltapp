package com.zlt.service;

import com.zlt.pojo.EduUser;

import java.util.List;

public interface EduUserService {
    int addUser(EduUser eduClass);
    int deleteUser(String userId);
    int updateUser(EduUser eduUser);
    List<EduUser> findAll();
    EduUser findById(String id);
    EduUser findByEmail(String email);
    EduUser findByMobile(String mobile);
}
