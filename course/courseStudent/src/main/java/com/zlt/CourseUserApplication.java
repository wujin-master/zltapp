package com.zlt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
@SpringBootApplication
@EnableDiscoveryClient
public class CourseUserApplication {
    public static void main(String[] args) {
        SpringApplication.run(CourseUserApplication.class, args);
    }
}

