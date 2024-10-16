package com.daliantwop.cloud.daliantwopuser.controller;

import com.daliantwop.cloud.daliantwopuser.config.DataSourceConfig;
import com.daliantwop.cloud.daliantwopuser.feign.StoreFeignService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Kevin
 * @date 2024/10/15 17:45
 */
@RestController
@AllArgsConstructor
@RequestMapping("/user")
public class UserController {


    private final DataSourceConfig datasourceConfig;

    private final StoreFeignService storeFeignService;

    @GetMapping("/getUser")
    public String getUser(){

        return "hello world" +  datasourceConfig.getUrl() + "开启了 openFeign：" + storeFeignService.getStore();
    }

}
