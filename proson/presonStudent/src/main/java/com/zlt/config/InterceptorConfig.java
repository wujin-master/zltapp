package com.zlt.config;

import com.zlt.interceptor.ParamInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
public class InterceptorConfig extends WebMvcConfigurationSupport {

    @Autowired(required = false)
    private ParamInterceptor paramInterceptor;

    public void addInterceptors(InterceptorRegistry registry) {
        //配置拦截路径
        registry.addInterceptor(paramInterceptor).addPathPatterns("/**").excludePathPatterns("/edu_user/validateLogin")
                .excludePathPatterns("/edu_user/validateRegister");
    }

}
