package com.zlt.service.impl;

import com.zlt.mapper.ChatInfoMapper;
import com.zlt.pojo.EduChatinfo;
import com.zlt.service.ChatInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatInfoServiceImpl implements ChatInfoService {
    @Autowired(required = false)
    private ChatInfoMapper chatInfoMapper;

    @Override
    public List<EduChatinfo> findChatInfoBySender(String sender) {
        return chatInfoMapper.findChatInfoBySender(sender);
    }

    @Override
    public List<EduChatinfo> findChatInfoByReceiver(String receiver) {
        return chatInfoMapper.findChatInfoByReceiver(receiver);
    }

    @Override
    public List<EduChatinfo> findChatInfoBySenderAndReceiver(String sender, String receiver) {
        List<EduChatinfo> list_1 = chatInfoMapper.findChatInfoBySenderAndReceiver(sender, receiver);
        return list_1;
    }

    @Override
    public int addChatInfo(EduChatinfo eduChatinfo) {
        return chatInfoMapper.addChatInfo(eduChatinfo);
    }
}
