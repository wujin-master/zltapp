package com.zlt.utils;

import java.util.UUID;

/**
 * UUID工具类
 * 设置主键id时使用
 */
public class UUIDUtil {
    /**
     * 去掉-的UUID
     *
     * @return 32位的字符串
     */
    public static String getUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }

}
