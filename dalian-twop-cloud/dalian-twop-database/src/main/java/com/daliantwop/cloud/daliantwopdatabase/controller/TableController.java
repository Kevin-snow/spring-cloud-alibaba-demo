package com.daliantwop.cloud.daliantwopdatabase.controller;

import com.daliantwop.cloud.daliantwopdatabase.consts.SchemaConst;
import com.daliantwop.cloud.daliantwopdatabase.consts.TableEnum;
import com.daliantwop.cloud.daliantwopdatabase.service.DataTableService;
import org.springframework.beans.factory.annotation.Autowired;
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


    @RequestMapping("/create")
    public void createTable() {
        dataTableService.createTable(SchemaConst.SCHEMA_NAME_TEST, TableEnum.ORDER.getTableEnName(), TableEnum.ORDER.getTableCnName());
    }

}
