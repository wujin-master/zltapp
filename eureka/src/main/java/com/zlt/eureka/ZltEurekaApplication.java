package com.zlt.eureka;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ZltEurekaApplication {
    public static void main(String[] args ){
        SpringApplication.run(ZltEurekaApplication.class,args);
    }
}
