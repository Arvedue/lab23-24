package com.company.brokencar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class BrokenCarApplication {
    public static void main(String[] args) {
        SpringApplication.run(BrokenCarApplication.class, args);
    }
}
