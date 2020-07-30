package com.zlt.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


/**
 * @program: hos-test
 * @description: wu
 * @create: 2019-05-17 15:10
 **/


@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //获取文件的真实路径 work_project代表项目工程名 需要更改
        String path = System.getProperty("D:\\java web\\mynewzltapp\\chat\\src\\main\\resources\\static\\images");
        String os = System.getProperty("os.name");
        if (os.toLowerCase().startsWith("win")) {
            registry.addResourceHandler("/images/**").
                    addResourceLocations("file:"+path);
        }else{//linux和mac系统 可以根据逻辑再做处理
            registry.addResourceHandler("/images/**").
                    addResourceLocations("file:"+path);
        }
        super.addResourceHandlers(registry);
    }

//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        //将所有/static/** 访问都映射到classpath:/static/ 目录下
//        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
//    }
}