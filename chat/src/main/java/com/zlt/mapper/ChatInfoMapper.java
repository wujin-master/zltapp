package com.zlt.mapper;

import com.zlt.pojo.EduChatinfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ChatInfoMapper {
    List<EduChatinfo> findChatInfoBySender(String sender);
    int addChatInfo(EduChatinfo eduChatinfo);
}
