package com.daliantwop.cloud.daliantwopdatabase.consts;

import lombok.Getter;

/**
 * @author Kevin
 * @date 2024/11/8 15:06
 */
@Getter
public enum TableEnum {

    ORDER("order", "InnoDB", "utf8mb4_general_ci"),
    ORDER_DETAIL("order_detail", "InnoDB", "utf8mb4_general_ci"),
    ORDER_PAY_TYPE("order_pay_type", "InnoDB", "utf8mb4_general_ci"),
    ORDER_SERVER("order_server", "InnoDB", "utf8mb4_general_ci"),
    RECHARGE("recharge", "InnoDB", "utf8mb4_general_ci"),
    RECHARGE_PAY_TYPE("recharge_pay_type", "InnoDB", "utf8mb4_general_ci"),
    RECHARGE_SERVER("recharge_server", "InnoDB", "utf8mb4_general_ci"),
    ;

    private final String tableName;

    private final String tableEngine;

    private final String tableCollation;

    TableEnum(String tableName, String tableEngine, String tableCollation) {
        this.tableName = tableName;
        this.tableEngine = tableEngine;
        this.tableCollation = tableCollation;
    }

    /**
     * 根据表名获取表引擎
     * @param tableName 表名
     * @return 表引擎
     */
    public static String getTableName(String tableName){
        for (TableEnum tableEnum : TableEnum.values()) {
            if (tableEnum.getTableName().equals(tableName)){
                return tableEnum.getTableName();
            }
        }
        return null;
    }

    public static String getTableEngine(String tableName){
        for (TableEnum tableEnum : TableEnum.values()) {
            if (tableEnum.getTableName().equals(tableName)){
                return tableEnum.getTableEngine();
            }
        }
        return null;
    }

    public static String getTableCollation(String tableName){
        for (TableEnum tableEnum : TableEnum.values()) {
            if (tableEnum.getTableName().equals(tableName)){
                return tableEnum.getTableCollation();
            }
        }
        return null;
    }
}
