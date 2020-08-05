package com.zlt.interceptor;

import com.zlt.utils.RedisUtil;
import com.zlt.utils.Result;
import com.zlt.utils.ResultCode;
import com.zlt.utils.TokenUtil;
import org.json.*;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@Component
public class ParamInterceptor implements HandlerInterceptor {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisUtil redisUtil;

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        String token = httpServletRequest.getHeader("token");
        //token验证
        if(token!=null){
            //获取token对应的value
            //有效期为1小时
            String id = redisUtil.get(token).toString();
            //String id = stringRedisTemplate.opsForValue().get(token);
            if(id!=null){
                if(TokenUtil.verify(token)) {
                    System.out.println("token验证成功");
                    return true;
                }
                else {
                    System.out.println("token验证失败");
                    return false;
                }
            }else{
                System.out.println("token验证失败");
                returnJson(httpServletResponse);
                return false;
            }
        }else{
            System.out.println("token验证失败");
            returnJson(httpServletResponse);
            return false;
        }

    }

    private void returnJson(HttpServletResponse response){
        PrintWriter writer = null;
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        try {
            writer = response.getWriter();
            Map<String,String> map = new HashMap<>();
            map.put("info", "没有token或token无效");
            Result msg = Result.failure(ResultCode.NO_TOKEN_OR_INVALIDATE);
            JSONObject jsonObject = new JSONObject(msg);
            writer.print(jsonObject);
        } catch (IOException e){
            e.printStackTrace();
        } finally {
            if(writer != null){
                writer.close();
            }
        }
    }


    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }

}
