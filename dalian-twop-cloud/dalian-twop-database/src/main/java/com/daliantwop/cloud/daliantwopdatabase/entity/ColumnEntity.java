package com.daliantwop.cloud.daliantwopdatabase.entity;

import lombok.Data;

/**
 * 表字段信息实体.
 * @author Kevin
 * @date 2024/11/8 14:42
 */
@Data
public class ColumnEntity {

    /**
     * 字段名
     */
    private String columnName;

    /**
     * 字段类型
     */
    private String columnType;

    /**
     * 键类型
     */
    private String columnKey;

    /**
     * 允许为空
     */
    private String columnNull;

    /**
     * 默认值
     */
    private String defaultValue;

    /**
     * 注释
     */
    private String columnComment;

    /**
     * 其他信息
     */
    private String extra;
}
