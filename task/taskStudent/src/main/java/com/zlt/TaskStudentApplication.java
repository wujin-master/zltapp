package com.zlt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import javax.annotation.Resource;

@SpringBootApplication
@EnableDiscoveryClient
public class TaskStudentApplication {
    public static void main(String[] args) {
        SpringApplication.run(TaskStudentApplication.class,args);
    }
}
