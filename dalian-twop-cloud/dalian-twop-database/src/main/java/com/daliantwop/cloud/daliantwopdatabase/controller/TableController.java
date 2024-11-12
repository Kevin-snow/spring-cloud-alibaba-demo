package com.daliantwop.cloud.daliantwopdatabase.controller;

import com.daliantwop.cloud.daliantwopcommon.response.R;
import com.daliantwop.cloud.daliantwopdatabase.service.DataTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Kevin
 * @date 2024/11/8 17:11
 */
@RestController
@RequestMapping("/table")
public class TableController {

    @Autowired
    private DataTableService dataTableService;


    @GetMapping("/create")
    public R<?> createTable() {
//        dataTableService.createTable(SchemaConst.SCHEMA_NAME_TEST, TableEnum.ORDER.getTableEnName(), TableEnum.ORDER.getTableCnName());
        return dataTableService.createTable();
    }

}
