package com.zlt.utils;

import com.obs.services.ObsClient;
import sun.misc.BASE64Decoder;

import java.io.ByteArrayInputStream;

public class Base64Util {
    /**
     * base64转图片
     * @param base64str base64码
     * @param savePath 图片路径
     * @return
     */
    public static boolean GenerateImage(String base64str, String savePath) {
        System.out.println("正在对base64进行接码并保存在华为云的对象存储");
        //对字节数组字符串进行Base64解码并生成图片
        if (base64str == null) {
            return false;
        }
        BASE64Decoder decoder = new BASE64Decoder();
        try {
            //Base64解码
            byte[] b = decoder.decodeBuffer(base64str);
            for (int i = 0; i < b.length; ++i) {
                //调整异常数据
                if (b[i] < 0) {
                    b[i] += 256;
                }
            }
            //上传到华为云obs
            String endPoint = "https://your-endpoint";
            String ak = "*** Provide your Access Key ***";
            String sk = "*** Provide your Secret Key ***";
            // 创建ObsClient实例
            ObsClient obsClient = new ObsClient("AHUI0M0TSOP9PULFXVXS", "eg8Zs8qiMps8ZM8fbcq2ZpPzOGvbuBjM2g8nDgVY", "obs.cn-east-3.myhuaweicloud.com");
            obsClient.putObject("public-clouddisk", savePath, new ByteArrayInputStream(b));
            return true;
        } catch (Exception e) {
            System.out.println("图片数据保存到华为云对象存储时出现错误");
            System.out.println("错误信息：" + e);
            return false;
        }
    }
}
