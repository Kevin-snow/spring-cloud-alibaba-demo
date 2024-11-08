package com.daliantwop.cloud.daliantwopdatabase.entity;

import lombok.Data;

/**
 * 表信息实体
 * @author Kevin
 * @date 2024/11/8 14:49
 */
@Data
public class TableEntity {

    /**
     * 表名称
     */
    private String tableName;

    /**
     * 表引擎
     */
    private String tableEngine;


    /**
     * 表编码
     */
    private String tableCollation;
}
