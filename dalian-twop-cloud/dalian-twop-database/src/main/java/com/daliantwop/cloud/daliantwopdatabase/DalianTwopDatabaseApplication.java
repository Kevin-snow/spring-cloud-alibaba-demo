package com.daliantwop.cloud.daliantwopdatabase;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(value = "com.daliantwop.cloud.daliantwopdatabase.mapper")
public class DalianTwopDatabaseApplication {

    public static void main(String[] args) {
        SpringApplication.run(DalianTwopDatabaseApplication.class, args);
    }

}
