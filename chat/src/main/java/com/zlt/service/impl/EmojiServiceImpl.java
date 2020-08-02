package com.zlt.service.impl;

import com.zlt.mapper.EmojiMapper;
import com.zlt.pojo.EduEmoji;
import com.zlt.service.EmojiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmojiServiceImpl implements EmojiService {
    @Autowired(required = false)
    private EmojiMapper emojiMapper;
    @Override
    public List<EduEmoji> findAllEmoji() {
        System.out.println("正在获取表情数据库数据");
        System.out.println(emojiMapper.findAllEmoji());
        return emojiMapper.findAllEmoji();
    }
}
