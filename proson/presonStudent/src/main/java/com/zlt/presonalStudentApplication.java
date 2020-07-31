package com.zlt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
@EnableDiscoveryClient
@SpringBootApplication
public class presonalStudentApplication {
    public static void main(String[] args) {
        SpringApplication.run(presonalStudentApplication.class,args);
    }
}
