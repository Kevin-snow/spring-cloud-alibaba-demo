package com.daliantwop.cloud.daliantwopuser;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@MapperScan("com.daliantwop.cloud.daliantwopuser.mapper")
public class DalianTwopUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(DalianTwopUserApplication.class, args);
    }
}
