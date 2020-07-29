package com.zlt.mapper;

import com.zlt.pojo.EduUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EduUserMapper {
    int addUser(EduUser eduUser);
    List<EduUser> queryUsers();
    int deleteUser(String id);
    int updateUser(EduUser eduUser);
    EduUser findById(String id);
}
