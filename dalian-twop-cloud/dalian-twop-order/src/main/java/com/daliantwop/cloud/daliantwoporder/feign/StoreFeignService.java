package com.daliantwop.cloud.daliantwoporder.feign;

import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author Kevin
 * @date 2024/10/16 14:00
 */
@FeignClient(value = "dalian-twop-store", path = "/store")
public interface StoreFeignService {




}
