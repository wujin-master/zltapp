package com.zlt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ExamTeacherApplication {
    public static void main(String[] args) {
        SpringApplication.run(ExamTeacherApplication.class,args);
    }
}
