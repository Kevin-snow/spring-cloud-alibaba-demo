package com.daliantwop.cloud.daliantwopuser.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Kevin
 * @date 2024/10/16 11:41
 */
@FeignClient(value = "dalian-twop-store", path = "/store")
public interface StoreFeignService {


    @GetMapping("/getStore")
    String getStore();

}
