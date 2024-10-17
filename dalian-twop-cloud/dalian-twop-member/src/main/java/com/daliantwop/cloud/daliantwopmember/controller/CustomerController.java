package com.daliantwop.cloud.daliantwopmember.controller;

import com.daliantwop.cloud.daliantwopcommon.response.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Kevin
 * @date 2024/10/17 15:45
 */
@Slf4j
@RestController
@RequestMapping("/customer")
public class CustomerController {


    public R<?> addCustomer() {
        log.info("addCustomer");
        return R.success();
    }




}
