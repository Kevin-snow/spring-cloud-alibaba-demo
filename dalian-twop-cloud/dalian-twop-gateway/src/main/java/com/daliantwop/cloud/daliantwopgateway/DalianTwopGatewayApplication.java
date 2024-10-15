package com.daliantwop.cloud.daliantwopgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class DalianTwopGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(DalianTwopGatewayApplication.class, args);
    }

}
