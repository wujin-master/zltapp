package com.zlt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
@SpringBootApplication
@EnableDiscoveryClient
public class CourseTeacherApplication {
    public static void main(String[] args) {
        SpringApplication.run(CourseTeacherApplication.class, args);
    }
}





