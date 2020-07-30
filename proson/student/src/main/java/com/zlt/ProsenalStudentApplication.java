package com.zlt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@EnableCircuitBreaker   //开启熔断
public class ProsenalStudentApplication {
    public static void main(String[] args){
        SpringApplication.run(ProsenalStudentApplication.class , args);
    }
}
