package com.daliantwop.cloud.daliantwopuser.controller;

import com.daliantwop.cloud.daliantwopcommon.utils.R;
import com.daliantwop.cloud.daliantwopuser.config.DataSourceConfig;
import com.daliantwop.cloud.daliantwopuser.feign.StoreFeignService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.asList;

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

    /**
     * 获取用户列表
     * @return
     */
    @GetMapping("/userList")
    public R<?> getUserList(){
        String msg = "hello world";
        String msg2 = "开启 openFeign1：" + storeFeignService.getStore();
        String msg3 = "开启 openFeign2：" + storeFeignService.getStore();
        List<String> list = new ArrayList<>();
        list.add(msg);
        list.add(msg2);
        list.add(msg3);
        return new R<>().success(list);
    }


}
