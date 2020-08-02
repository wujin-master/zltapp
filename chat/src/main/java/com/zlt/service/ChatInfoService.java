package com.zlt.service;

import com.zlt.pojo.EduChatinfo;

import java.util.List;

public interface ChatInfoService {
    List<EduChatinfo> findChatInfoBySender(String sender);
    List<EduChatinfo> findChatInfoBySenderAndReceiver(String sender, String receiver);
    int addChatInfo(EduChatinfo eduChatinfo);
}
