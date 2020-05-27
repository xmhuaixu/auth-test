package com.tfjybj.login;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class LoginMainApplication {

    public static void main(String[] args) {
        SpringApplication.run(LoginMainApplication.class,args);
    }

}
