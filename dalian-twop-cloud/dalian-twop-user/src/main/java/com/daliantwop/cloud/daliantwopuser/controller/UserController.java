package com.daliantwop.cloud.daliantwopuser.controller;

import com.daliantwop.cloud.daliantwopcommon.response.R;
import com.daliantwop.cloud.daliantwopuser.entity.LoginForm;
import com.daliantwop.cloud.daliantwopuser.feign.StoreFeignService;
import com.daliantwop.cloud.daliantwopuser.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Kevin
 * @date 2024/10/15 17:45
 */
@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private StoreFeignService storeFeignService;

    @Autowired
    private UserService userService;

    @PostMapping("/getUser")
    public R<?> getUser(@RequestBody LoginForm loginForm){
        log.info("hello world" +  "开启了 openFeign：{}" , storeFeignService.getStore());
        return R.success(userService.getUser(loginForm));
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
        return R.success(list);
    }


}
