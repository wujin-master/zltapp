package com.zlt.api;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("live")
public interface liveApi {
    @GetMapping("hello")
    public String hello();
}
