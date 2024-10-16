package com.daliantwop.cloud.daliantwopstore.controller;

import com.daliantwop.cloud.daliantwopstore.entity.Store;
import org.springframework.web.bind.annotation.*;

/**
 * @author Kevin
 * @date 2024/10/16 10:27
 */
@RestController
@RequestMapping("/store")
public class StoreController {


    @GetMapping("/getStore")
    public String getStore() {
        return "store";
    }


    @PostMapping("/save")
    public String saveStore(@RequestBody Store store){
        return "save is success";
    }

    @DeleteMapping("/delete")
    public String deleteStore(@RequestParam("id") Integer id){
        return "delete is success";
    }

}
