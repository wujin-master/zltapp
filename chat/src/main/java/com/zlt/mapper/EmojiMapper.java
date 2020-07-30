package com.zlt.mapper;

import com.zlt.pojo.EduEmoji;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EmojiMapper {
    List<EduEmoji> findAllEmoji();
}
